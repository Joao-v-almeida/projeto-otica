package br.com.oticanewlook.oticanewlook.services;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import br.com.oticanewlook.oticanewlook.model.TipoFuncionarioModel;
import br.com.oticanewlook.oticanewlook.repositories.TipoFuncionarioRepository;


@Service
public class TipoFuncionarioService {

    final TipoFuncionarioRepository tipoFuncionarioRepository;

    public TipoFuncionarioService(TipoFuncionarioRepository tipoFuncionarioRepository) {
        this.tipoFuncionarioRepository = tipoFuncionarioRepository;
    }

    @Transactional
    public TipoFuncionarioModel save(TipoFuncionarioModel tipoFuncionarioModel) {
        return tipoFuncionarioRepository.save(tipoFuncionarioModel);
    }

    @Transactional
    public void delete(TipoFuncionarioModel tipoFuncionarioModel) {
        tipoFuncionarioRepository.delete(tipoFuncionarioModel);
    }

    public List<TipoFuncionarioModel> findAll() {
        return tipoFuncionarioRepository.findAll();
    }

    public Optional<TipoFuncionarioModel> findById(int id_tipo_func) {
        return tipoFuncionarioRepository.findById(id_tipo_func);
    }

    public boolean existsByNome(String nome) {
        return tipoFuncionarioRepository.existsByNome(nome);
    }
}
