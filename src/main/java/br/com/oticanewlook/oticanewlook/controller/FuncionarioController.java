package br.com.oticanewlook.oticanewlook.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
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
import br.com.oticanewlook.oticanewlook.dtos.FuncionarioDto;
import br.com.oticanewlook.oticanewlook.model.CidadeModel;
import br.com.oticanewlook.oticanewlook.model.FuncionarioModel;
import br.com.oticanewlook.oticanewlook.model.TipoFuncionarioModel;
import br.com.oticanewlook.oticanewlook.services.CidadeService;
import br.com.oticanewlook.oticanewlook.services.FuncionarioService;
import br.com.oticanewlook.oticanewlook.services.TipoFuncionarioService;

@Controller
@RequestMapping
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private CidadeService cidadeService;

    @Autowired
    private TipoFuncionarioService tipoFuncionarioService;

    // TELA PRINCIPAL
    @GetMapping("/funcionarios")
    public String funcionarios(Model model) {
        List<FuncionarioModel> funcionarios = funcionarioService.findlAllAtivo();
        model.addAttribute("funcionarios", funcionarios);

        return "generico/funcionario";
    }

    // PROCESSO NOVO FUNCIONÁRIO
    @GetMapping("/funcionarios/novo")
    public String novo(Model model) {

        List<TipoFuncionarioModel> tipo_funcionarios = tipoFuncionarioService.findAll();
        List<CidadeModel> cidades = cidadeService.findAll();
        model.addAttribute("tipo_funcionarios", tipo_funcionarios);
        model.addAttribute("cidades", cidades);
        return "cadastros/novoFunc";
    }

    @PostMapping("/funcionarios/criar")
    public String criar(FuncionarioModel funcionario, @Valid FuncionarioDto funcionarioDto, BindingResult result,
            Model model) {

        List<TipoFuncionarioModel> tipo_funcionarios = tipoFuncionarioService.findAll();
        List<CidadeModel> cidades = cidadeService.findAll();
        model.addAttribute("tipo_funcionarios", tipo_funcionarios);
        model.addAttribute("cidades", cidades);

        var msgErro = "";
        boolean erro = false;
        if (funcionarioService.existsByEmail(funcionarioDto.getEmail())) {
            erro = true;
            msgErro = "CONFLITO: O email : " + funcionarioDto.getEmail() + " já existe! | ";
        }

        if (funcionarioService.existsByCpf(funcionarioDto.getCpf())) {
            erro = true;
            msgErro = msgErro + "CONFLITO: O CPF : " + funcionarioDto.getCpf() + " já existe!";
        }

        var funcionarioModel = new FuncionarioModel();
        BeanUtils.copyProperties(funcionarioDto, funcionarioModel);
        funcionarioModel.setAtivo("S");
        funcionarioModel.setData_cadastro(LocalDateTime.now(ZoneId.of("UTC")));

        if (result.hasErrors() || erro) {
            var br = "";
            List<FieldError> e = result.getFieldErrors();
            for (FieldError error : e) {
                br = error.getDefaultMessage() + " | ";
            }

            model.addAttribute("erro", br + " | " + msgErro);

            return "cadastros/novoFunc";
        }

        funcionarioService.save(funcionarioModel);
        return "redirect:/funcionarios";
    }

    // PROCESSO ALTERAÇÃO DE FUNCIONÁRIO

    @GetMapping("/funcionarios/{id_func}")
    public String buscar(@PathVariable int id_func, Model model) {
        Optional<FuncionarioModel> funcionario = funcionarioService.findById(id_func);

        List<TipoFuncionarioModel> tipo_funcionarios = tipoFuncionarioService.findAll();
        List<CidadeModel> cidades = cidadeService.findAll();

        try {
            model.addAttribute("funcionario", funcionario.get());
            model.addAttribute("tipo_funcionarios", tipo_funcionarios);
            model.addAttribute("cidades", cidades);
        } catch (Exception e) {
            return "redirect:/funcionarios";
        }

        return "editar/editarFunc";
    }

    @PostMapping("/funcionarios/{id_func}/atualizar")
    public String atualizar(@PathVariable int id_func, FuncionarioModel funcionario,
            @Valid FuncionarioDto funcionarioDto, BindingResult result,
            Model model) {

        if (!funcionarioService.existsById(id_func)) {
            return "redirect:/funcionarios";
        }

        Optional<FuncionarioModel> funcionarioOp = funcionarioService.findById(id_func);
        var funcionarioModel = new FuncionarioModel();
        funcionarioModel = funcionarioOp.get();

        BeanUtils.copyProperties(funcionarioDto, funcionarioModel);

        if (result.hasErrors()) {
            var br = "";
            List<FieldError> e = result.getFieldErrors();
            for (FieldError error : e) {
                br = error.getDefaultMessage() + " | ";
            }

            model.addAttribute("erro", " | " + br + " | ");
            return "redirect:/funcionarios/{id_func}";

        }
        funcionarioService.save(funcionarioModel);
        return "redirect:/funcionarios";
    }

    // PROCESSO EXCLUIR FUNCIONARIO

    @GetMapping("/funcionarios/{id_func}/inativar")
    public String inativar(@PathVariable int id_func) {

        Optional<FuncionarioModel> funcionario = funcionarioService.findById(id_func);

        if (funcionarioService.existsById(id_func)) {
            funcionarioService.inativar(funcionario.get());
        }
        return "redirect:/funcionarios";
    }
}
