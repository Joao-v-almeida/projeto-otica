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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.com.oticanewlook.oticanewlook.dtos.ReceitaDto;
import br.com.oticanewlook.oticanewlook.model.ClienteModel;
import br.com.oticanewlook.oticanewlook.model.ReceitaModel;
import br.com.oticanewlook.oticanewlook.services.ClienteService;
import br.com.oticanewlook.oticanewlook.services.CookieService;
import br.com.oticanewlook.oticanewlook.services.ReceitaService;

@Controller
@RequestMapping
public class ReceitaController {
    
    @Autowired
    private ReceitaService receitaService;

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/receitas")
    public String receitas(Model model, HttpServletRequest request) throws UnsupportedEncodingException {

        model.addAttribute("nome", CookieService.getCookie(request, "funcionarioNome"));

        List<ReceitaModel> receitas = receitaService.findAll();
        model.addAttribute("receitas", receitas);

        return "generico/receita";
    }

    @GetMapping("/receitas/novo")
    public String novo(Model model, HttpServletRequest request) throws UnsupportedEncodingException{

        model.addAttribute("nome", CookieService.getCookie(request, "funcionarioNome"));

        List<ClienteModel> clientes = clienteService.findlAllAtivo();
        model.addAttribute("clientes", clientes);

        return "cadastros/novoReceita";
    }
    
    @PostMapping("/receitas/criar")
    public String criar(ReceitaModel receita, @Valid ReceitaDto receitaDto, BindingResult result, Model model) {

        List<ClienteModel> clientes = clienteService.findlAllAtivo();
        model.addAttribute("clientes", clientes);
        
        boolean erro = false;
        var receitaModel = new ReceitaModel();

        BeanUtils.copyProperties(receitaDto, receitaModel);

        if (result.hasErrors() || erro) {
            var br = "";
            List<FieldError> e = result.getFieldErrors();
            for (FieldError error : e) {
                br = " * " + error.getDefaultMessage() + " * ";
            }

            model.addAttribute("erro", br);

            return "cadastros/novoReceita";
        }

        receitaService.save(receitaModel);
        return "redirect:/receitas";
    }
    
    @GetMapping("/receitas/{id_receita}")
    public String buscar(@PathVariable int id_receita, Model model, HttpServletRequest request)
            throws UnsupportedEncodingException {

        model.addAttribute("nome", CookieService.getCookie(request, "funcionarioNome"));

        Optional<ReceitaModel> receita = receitaService.findById(id_receita);

        List<ClienteModel> clientes = clienteService.findlAllAtivo();

        try {
            model.addAttribute("receita", receita.get());
            model.addAttribute("clientes", clientes);
        } catch (Exception e) {
            return "redirect:/receitas";
        }

        return "editar/editarReceita";
    }
    
    @PostMapping("/receitas/{id_receita}/atualizar")
    public String atualizar(@PathVariable int id_receita, ReceitaModel receita,
            @Valid ReceitaDto receitaDto, BindingResult result, RedirectAttributes redirectAttributes) {

        if (!receitaService.existsById(id_receita)) {
            return "redirect:/receitas";
        }

        Optional<ReceitaModel> receitaOp = receitaService.findById(id_receita);

        var receitaModel = new ReceitaModel();

        receitaModel = receitaOp.get();

        BeanUtils.copyProperties(receitaDto, receitaModel);

        if (result.hasErrors()) {
            var br = "";
            List<FieldError> e = result.getFieldErrors();
            for (FieldError error : e) {
                br = " * " + error.getDefaultMessage() + " * ";
            }

            redirectAttributes.addFlashAttribute("erro", br);
            return "redirect:/receitas/{id_receita}";

        }
        receitaService.save(receitaModel);
        return "redirect:/receitas";
    }
}
