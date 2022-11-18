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
import br.com.oticanewlook.oticanewlook.dtos.ClienteDto;
import br.com.oticanewlook.oticanewlook.model.CidadeModel;
import br.com.oticanewlook.oticanewlook.model.ClienteModel;
import br.com.oticanewlook.oticanewlook.services.CidadeService;
import br.com.oticanewlook.oticanewlook.services.ClienteService;

@Controller
@RequestMapping
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private CidadeService cidadeService;

    //TELA PRINCIPAL
     @GetMapping("/clientes")
     public String cliente(Model model) {
         List<ClienteModel> clientes = clienteService.findlAllAtivo();
         model.addAttribute("clientes", clientes);
         return "generico/cliente";
     }
     
     //PROCESSO NOVO CLIENTE
    @GetMapping("/clientes/novo")
    public String novo(Model model) {

        List<CidadeModel> cidades = cidadeService.findAll();
        model.addAttribute("cidades", cidades);

        return "cadastros/novoClie";
    }

    @PostMapping("/clientes/criar")
    public String criar(ClienteModel cliente, @Valid ClienteDto clienteDto, BindingResult result, Model model) {

        List<CidadeModel> cidades = cidadeService.findAll();
        model.addAttribute("cidades", cidades);

        var msgErro = "";
        boolean erro = false;

        if (clienteService.existsByCpf(clienteDto.getCpf())) {
            erro = true;
            msgErro = "CONFLITO: O CPF : " + clienteDto.getCpf() + " já existe! | ";
        }

        var clienteModel = new ClienteModel();
        BeanUtils.copyProperties(clienteDto, clienteModel);
        clienteModel.setAtivo("S");
        clienteModel.setData_cadastro(LocalDateTime.now(ZoneId.of("UTC")));

        if (result.hasErrors() || erro) {
            var br = "";
            List<FieldError> e = result.getFieldErrors();
            for (FieldError error : e) {
                br = error.getDefaultMessage() + " | ";
            }

            model.addAttribute("erro", br + " | " + msgErro);
            return "cadastros/novoClie";
        }

        clienteService.save(clienteModel);
        return "redirect:/clientes";
    }
    
    @GetMapping("/clientes/{id_cliente}")
    public String buscar(@PathVariable int id_cliente, Model model) {

        Optional<ClienteModel> cliente = clienteService.findById(id_cliente);
        List<CidadeModel> cidades = cidadeService.findAll();

        try {
            model.addAttribute("cliente", cliente.get());
            model.addAttribute("cidades", cidades);
        } catch (Exception e) {
            return "redirect:/clientes";
        }

        return "editar/editarClie";
    }
    
    @PostMapping("/clientes/{id_cliente}/atualizar")
    public String atualizar(@PathVariable int id_cliente, ClienteModel cliente, @Valid ClienteDto clienteDto,
            BindingResult result, Model model) {

        if (!clienteService.existsById(id_cliente)) {
            return "redirect:/clientes";
        }

        Optional<ClienteModel> clienteOp = clienteService.findById(id_cliente);

        var clienteModel = new ClienteModel();
        clienteModel = clienteOp.get();

        BeanUtils.copyProperties(clienteDto, clienteModel);

        if (result.hasErrors()) {
            var br = "";
            List<FieldError> e = result.getFieldErrors();
            for (FieldError error : e) {
                br = error.getDefaultMessage() + " | ";
            }

            model.addAttribute("erro", br + " | ");
            return "redirect:/clientes/{id_cliente}";
        }

        clienteService.save(clienteModel);
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/{id_cliente}/inativar")
    public String inativar(@PathVariable int id_cliente) {

        Optional<ClienteModel> cliente = clienteService.findById(id_cliente);

        if (clienteService.existsById(id_cliente)) {
            clienteService.inativar(cliente.get());
        }
        return "redirect:/clientes";
    }
}
