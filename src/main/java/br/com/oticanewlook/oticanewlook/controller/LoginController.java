package br.com.oticanewlook.oticanewlook.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import br.com.oticanewlook.oticanewlook.model.FuncionarioModel;
import br.com.oticanewlook.oticanewlook.services.CookieService;
import br.com.oticanewlook.oticanewlook.services.FuncionarioService;

@Controller
public class LoginController {

    @Autowired
    final FuncionarioService funcionarioService;
    
    public LoginController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping("/")
    public String login() {
        return "home/login";
    }

    @PostMapping("/logar")
    public String logar(Model model, @Valid FuncionarioModel funcParam, BindingResult result, HttpServletResponse response) throws IOException{
        FuncionarioModel func = this.funcionarioService.Login(funcParam.getEmail(), funcParam.getSenha());
        if (func != null) {
            int tempoLogado = (60 * 60);
            CookieService.setCookie(response, "funcionarioID", String.valueOf(func.getId_func()), tempoLogado);
            CookieService.setCookie(response, "funcionarioNome", String.valueOf(func.getNome()), tempoLogado);
            return "redirect:/principal";
        }

        model.addAttribute("erro", "Dados incorretos!");
        return "home/login";
    }

    @GetMapping("/sair")
    public String logar(HttpServletResponse response) throws IOException {
        CookieService.setCookie(response, "funcionarioID", "", 0);
        CookieService.setCookie(response, "funcionarioNome", "", 0);
        return "redirect:/";
    }

}
