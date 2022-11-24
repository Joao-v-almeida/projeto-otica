package br.com.oticanewlook.oticanewlook.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.oticanewlook.oticanewlook.dtos.VendaDto;
import br.com.oticanewlook.oticanewlook.model.ProdutoModel;
import br.com.oticanewlook.oticanewlook.model.ReceitaModel;
import br.com.oticanewlook.oticanewlook.model.VendaModel;
import br.com.oticanewlook.oticanewlook.services.CookieService;
import br.com.oticanewlook.oticanewlook.services.ProdutoService;
import br.com.oticanewlook.oticanewlook.services.ReceitaService;
import br.com.oticanewlook.oticanewlook.services.VendaService;

@Controller
@RequestMapping
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ReceitaService receitaService;


    @GetMapping("/vendas")
    public String vendas(Model model, HttpServletRequest request) throws UnsupportedEncodingException {

        model.addAttribute("nome", CookieService.getCookie(request, "funcionarioNome"));

        List<VendaModel> vendas = vendaService.findAll();
        List<ReceitaModel> receitas = receitaService.findAll();

        model.addAttribute("vendas", vendas);
        model.addAttribute("receitas", receitas);

        return "generico/venda";
    }

    @GetMapping("/vendas/novo")
    public String novo(Model model, HttpServletRequest request) throws UnsupportedEncodingException {

        model.addAttribute("nome", CookieService.getCookie(request, "funcionarioNome"));

        List<ReceitaModel> receitas = receitaService.findAll();

        List<ProdutoModel> produtos = produtoService.findAll();

        model.addAttribute("receitas", receitas);
        model.addAttribute("produtos", produtos);

        return "cadastros/novoVenda";
    }

    /**
     * @param venda
     * @param vendaDto
     * @param result
     * @param model
     * @return
     */
    @PostMapping("/vendas/criar")
    public String criar(VendaModel venda, @Valid VendaDto vendaDto, BindingResult result, Model model, HttpServletRequest request) throws UnsupportedEncodingException {

        List<ReceitaModel> receitas = receitaService.findAll();
        List<ProdutoModel> produtos = produtoService.findAll();

        model.addAttribute("receitas", receitas);
        model.addAttribute("produtos", produtos);

        int quantidade, num_os, numero_parcelas, id_func;
        double desconto;
        var msgErro = "";
        boolean erro = false;

        Optional<ProdutoModel> produtoOp = produtoService.findById(vendaDto.getId_produto());
        var produtoModel = new ProdutoModel();
        produtoModel = produtoOp.get();

        // VALIDACAO
        try {
            quantidade = Integer.parseInt(vendaDto.getQuantidade());
            num_os = Integer.parseInt(vendaDto.getNum_os());
            numero_parcelas = Integer.parseInt(vendaDto.getNum_parc_total());
            id_func = Integer.parseInt(CookieService.getCookie(request, "funcionarioID"));

            if (vendaDto.getDesconto().equals("")) {
                vendaDto.setDesconto("0");
            }
            desconto = Double.parseDouble(vendaDto.getDesconto().replace(',', '.'));

            if (quantidade <= 0) {
                if (produtoModel.getTipo_produto().equals("LENTE")) {
                    quantidade = 0;
                } else {
                    erro = true;
                    msgErro = "CONFLITO: Campo quantidade não pode ser menor ou igual a zero.";
                }
            }

            if (produtoModel.getEstoque() < quantidade
                    & !produtoModel.getTipo_produto().equals("LENTE")) {
                erro = true;
                msgErro = "CONFLITO: O produto selecionado possui somente: " + produtoModel.getEstoque()
                        + " unidades em estoque";
            }

            if (desconto < 0) {
                erro = true;
                msgErro = "CONFLITO: Campo desconto não pode ser menor que zero.";
            }

            if (desconto > produtoModel.getPreco_venda() * quantidade) {
                erro = true;
                msgErro = "CONFLITO: O Desconto não pode ser maior que o valor total.";
            }

            if (num_os <= 0) {
                erro = true;
                msgErro = "CONFLITO: Campo Número O.S não pode ser menor ou igual a zero.";
            }

            var vendaModel = new VendaModel();

            BeanUtils.copyProperties(vendaDto, vendaModel);

            vendaDto.setValor(produtoModel.getPreco_venda() * quantidade);
            vendaDto.setTotal_desc(vendaDto.getValor() - desconto);

            var total_desc = vendaDto.getTotal_desc();
            var valor = vendaDto.getValor();

            vendaModel.setTotal_desc(total_desc);
            vendaModel.setDesconto(String.valueOf(desconto));
            vendaModel.setValor(valor);

            if (!erro) {
                vendaService.registrar_dependentes_venda(desconto, vendaModel.getId_receita(), total_desc, valor,
                        produtoModel.getId_produto(), quantidade, numero_parcelas, num_os, id_func);
                    }
            
            

        } catch (NumberFormatException e) {
            erro = true;
            msgErro = "CONFLITO: Erro, verifique se o campos estão númericos";
        }

        if (result.hasErrors() || erro) {
            var br = "";
            List<FieldError> e = result.getFieldErrors();
            for (FieldError error : e) {
                br = " * " + error.getDefaultMessage() + " * ";
            }

            model.addAttribute("erro", br + " * " + msgErro + " * ");

            return "cadastros/novoVenda";
        }

        return "redirect:/vendas";
    }
}
