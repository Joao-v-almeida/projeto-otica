package br.com.oticanewlook.oticanewlook.services;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import br.com.oticanewlook.oticanewlook.model.FuncionarioModel;
import br.com.oticanewlook.oticanewlook.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {
    
    final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @Transactional
    public FuncionarioModel save(FuncionarioModel funcionarioModel) {
        return funcionarioRepository.save(funcionarioModel);
    }

    @Transactional
    public void delete(FuncionarioModel funcionarioModel) {
        funcionarioRepository.delete(funcionarioModel);
    }

    public List<FuncionarioModel> findAll() {
        return funcionarioRepository.findAll();
    }

    public List<FuncionarioModel> findlAllAtivo() {
        return funcionarioRepository.findlAllAtivo();
    }

    public Optional<FuncionarioModel> findById(int id_func) {
        return funcionarioRepository.findById(id_func);
    }

    @Transactional
    public void inativar(FuncionarioModel funcionarioModel) {
        funcionarioRepository.inativar(funcionarioModel);
    }

    public boolean existsById(int id_func) {
        return funcionarioRepository.existsById(id_func);
    }
 
    public boolean existsByEmail(String email) {
        return funcionarioRepository.existsByEmail(email);
    }

    public boolean existsByCpf(String cpf) {
        return funcionarioRepository.existsByCpf(cpf);
    }

    public FuncionarioModel Login(String email, String senha) {
        return funcionarioRepository.Login(email, senha);
    }

    
}
