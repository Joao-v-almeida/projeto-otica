package br.com.oticanewlook.oticanewlook.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.oticanewlook.oticanewlook.model.OrdemServicoModel;
import br.com.oticanewlook.oticanewlook.repositories.OrdemServicoRepository;
import br.com.oticanewlook.oticanewlook.services.CookieService;

@Controller
@RequestMapping
public class OrdemServicoController {
    
    @Autowired
    private OrdemServicoRepository ordemServicoService;

    @GetMapping("/ordemServicos")
    public String vendas(Model model, HttpServletRequest request) throws UnsupportedEncodingException {

        model.addAttribute("nome", CookieService.getCookie(request, "funcionarioNome"));

        List<OrdemServicoModel> ordemServicos = ordemServicoService.findAll();

        model.addAttribute("ordemServicos", ordemServicos);

        return "generico/ordemServico";
    }
}
