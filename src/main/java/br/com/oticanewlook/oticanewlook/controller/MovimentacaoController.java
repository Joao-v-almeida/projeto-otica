package br.com.oticanewlook.oticanewlook.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.oticanewlook.oticanewlook.model.FuncionarioModel;
import br.com.oticanewlook.oticanewlook.model.MovimentacaoModel;
import br.com.oticanewlook.oticanewlook.services.CookieService;
import br.com.oticanewlook.oticanewlook.services.FuncionarioService;
import br.com.oticanewlook.oticanewlook.services.MovimentacaoService;

@Controller
@RequestMapping
public class MovimentacaoController {
    
    @Autowired
    private MovimentacaoService movimentacaoService;
    
    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping("/movimentacoes")
     public String cliente(Model model, HttpServletRequest request) throws UnsupportedEncodingException {

         model.addAttribute("nome", CookieService.getCookie(request, "funcionarioNome"));

         var funcionarioID = CookieService.getCookie(request, "funcionarioID");
         int funcID = Integer.parseInt(funcionarioID);

         Optional<FuncionarioModel> funcionario = funcionarioService.findById(funcID);

         var tipoFuncionario = funcionario.get().getId_tipo_func();

         if (tipoFuncionario == 1) {
             List<MovimentacaoModel> movimentacoes = movimentacaoService.findlAllEntrada();
             model.addAttribute("movimentacoes", movimentacoes);
             return "generico/movimentacao";
         }
         
         return "generico/acessoNegado";
     }
}
