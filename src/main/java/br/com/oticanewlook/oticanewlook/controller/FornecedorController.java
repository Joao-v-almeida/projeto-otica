package br.com.oticanewlook.oticanewlook.controller;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.ZoneId;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.oticanewlook.oticanewlook.dtos.FornecedorDto;
import br.com.oticanewlook.oticanewlook.model.CidadeModel;
import br.com.oticanewlook.oticanewlook.model.FornecedorModel;
import br.com.oticanewlook.oticanewlook.services.CidadeService;
import br.com.oticanewlook.oticanewlook.services.CookieService;
import br.com.oticanewlook.oticanewlook.services.FornecedorService;


@Controller
@RequestMapping
public class FornecedorController {
    
    @Autowired
    private FornecedorService fornecedorService;

    @Autowired
    private CidadeService cidadeService;

    //TELA PRINCIPAL
     @GetMapping("/fornecedores")
     public String cliente(Model model, HttpServletRequest request) throws UnsupportedEncodingException {

         model.addAttribute("nome", CookieService.getCookie(request, "funcionarioNome"));
        
         List<FornecedorModel> fornecedores = fornecedorService.findlAllAtivo();
         model.addAttribute("fornecedores", fornecedores);

         return "generico/fornecedor";
     }
     
     //PROCESSO NOVO FORNECEDOR
    @GetMapping("/fornecedores/novo")
    public String novo(Model model, HttpServletRequest request) throws UnsupportedEncodingException {

        model.addAttribute("nome", CookieService.getCookie(request, "funcionarioNome"));

        List<CidadeModel> cidades = cidadeService.findAll();
        model.addAttribute("cidades", cidades);

        return "cadastros/novoForn";
    }

    @PostMapping("/fornecedores/criar")
    public String criar(FornecedorModel fornecedor, @Valid FornecedorDto fornecedorDto, BindingResult result,
            Model model, HttpServletRequest request) throws UnsupportedEncodingException {

        model.addAttribute("nome", CookieService.getCookie(request, "funcionarioNome"));

        List<CidadeModel> cidades = cidadeService.findAll();
        model.addAttribute("cidades", cidades);

        var msgErro = "";
        boolean erro = false;

        if (fornecedorService.existsByCnpj(fornecedorDto.getCnpj())) {
            erro = true;
            msgErro = "CONFLITO: O CNPJ : " + fornecedorDto.getCnpj() + " já existe! | ";
        }

        var fornecedorModel = new FornecedorModel();
        BeanUtils.copyProperties(fornecedorDto, fornecedorModel);
        fornecedorModel.setAtivo("S");
        fornecedorModel.setData_cadastro(LocalDate.now(ZoneId.of("UTC")));

        if (result.hasErrors() || erro) {
            var br = "";
            List<FieldError> e = result.getFieldErrors();
            for (FieldError error : e) {
                br = error.getDefaultMessage() + " | ";
            }

            model.addAttribute("erro", br + " | " + msgErro);
            return "cadastros/novoForn";
        }

        fornecedorService.save(fornecedorModel);
        return "redirect:/fornecedores";
    }
    
    @GetMapping("/fornecedores/{id_forne}")
    public String buscar(@PathVariable int id_forne, Model model, HttpServletRequest request) throws UnsupportedEncodingException {

        model.addAttribute("nome", CookieService.getCookie(request, "funcionarioNome"));

        Optional<FornecedorModel> fornecedor = fornecedorService.findById(id_forne);
        List<CidadeModel> cidades = cidadeService.findAll();

        try {
            model.addAttribute("fornecedor", fornecedor.get());
            model.addAttribute("cidades", cidades);
        } catch (Exception e) {
            return "redirect:/fornecedores";
        }

        return "editar/editarForn";
    }

    @PostMapping("/fornecedores/{id_forne}/atualizar")
    public String atualizar(@PathVariable int id_forne, FornecedorModel fornecedor, @Valid FornecedorDto fornecedorDto,
            BindingResult result, Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) throws UnsupportedEncodingException {

        model.addAttribute("nome", CookieService.getCookie(request, "funcionarioNome"));

        if (!fornecedorService.existsById(id_forne)) {
            return "redirect:/clientes";
        }

        Optional<FornecedorModel> clienteOp = fornecedorService.findById(id_forne);

        var fornecedorModel = new FornecedorModel();
        fornecedorModel = clienteOp.get();

        BeanUtils.copyProperties(fornecedorDto, fornecedorModel);

        if (result.hasErrors()) {
            var br = "";
            List<FieldError> e = result.getFieldErrors();
            for (FieldError error : e) {
                br = error.getDefaultMessage() + " | ";
            }

            redirectAttributes.addFlashAttribute("erro", br);
            return "redirect:/fornecedores/{id_forne}";
        }

        fornecedorService.save(fornecedorModel);
        return "redirect:/fornecedores";
    }

    @GetMapping("/fornecedores/{id_forne}/inativar")
    public String inativar(@PathVariable int id_forne) {

        Optional<FornecedorModel> fornecedor = fornecedorService.findById(id_forne);

        if (fornecedorService.existsById(id_forne)) {
            fornecedorService.inativar(fornecedor.get());
        }
        return "redirect:/fornecedores";
    }
}
