package br.com.oticanewlook.oticanewlook.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.oticanewlook.oticanewlook.model.ContasReceberModel;
import br.com.oticanewlook.oticanewlook.repositories.ContasReceberRespository;
import br.com.oticanewlook.oticanewlook.services.CookieService;

@Controller
@RequestMapping
public class ContasReceberController {
    
    @Autowired
    private ContasReceberRespository contasReceberRespository;

    @GetMapping("/contasReceber")
    public String contasReceber(Model model, HttpServletRequest request) throws UnsupportedEncodingException {

        model.addAttribute("nome", CookieService.getCookie(request, "funcionarioNome"));

        List<ContasReceberModel> contasReceber = contasReceberRespository.findAll();

        model.addAttribute("contasReceber", contasReceber);

        return "generico/contasReceber";
    }

    @GetMapping("/contasReceber/{id_contas_receb}/receber")
    public String receber(@PathVariable int id_contas_receb, HttpServletRequest request) throws UnsupportedEncodingException {

        int id_funcionario;

        id_funcionario = Integer.parseInt(CookieService.getCookie(request, "funcionarioID"));

        if (contasReceberRespository.existsById(id_contas_receb)) {
            contasReceberRespository.rebeberConta(id_contas_receb, id_funcionario);
        }
        return "redirect:/contasReceber";
    }

    @GetMapping("/contasReceber/{id_contas_receb}/cancelar")
    public String cancelar(@PathVariable int id_contas_receb, HttpServletRequest request) throws UnsupportedEncodingException {


        int id_funcionario;

        id_funcionario = Integer.parseInt(CookieService.getCookie(request, "funcionarioID"));

        if (contasReceberRespository.existsById(id_contas_receb)) {
            contasReceberRespository.cancelarRecebimento(id_contas_receb, id_funcionario);;
        }
        return "redirect:/contasReceber";
    }
}
