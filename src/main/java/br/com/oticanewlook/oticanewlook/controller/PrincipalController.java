package br.com.oticanewlook.oticanewlook.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.oticanewlook.oticanewlook.services.CookieService;

@Controller
@RequestMapping("/principal")
public class PrincipalController {

    @GetMapping
    public String principal(Model model, HttpServletRequest request) throws UnsupportedEncodingException {
        model.addAttribute("nome", CookieService.getCookie(request, "funcionarioNome"));
        return "principal/index";
    }

}
