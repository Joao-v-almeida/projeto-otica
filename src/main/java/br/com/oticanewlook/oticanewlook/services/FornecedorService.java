package br.com.oticanewlook.oticanewlook.services;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import br.com.oticanewlook.oticanewlook.model.FornecedorModel;
import br.com.oticanewlook.oticanewlook.repositories.FornecedorRepository;

@Service
public class FornecedorService {
    
    final FornecedorRepository fornecedorRepository;

    public FornecedorService(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    @Transactional
    public FornecedorModel save(FornecedorModel fornecedorModel) {
        return fornecedorRepository.save(fornecedorModel);
    }

    @Transactional
    public void delete(FornecedorModel fornecedorModel) {
        fornecedorRepository.delete(fornecedorModel);
    }

    @Transactional
    public void inativar(FornecedorModel fornecedorModel) {
        fornecedorRepository.inativar(fornecedorModel);
    }

    public List<FornecedorModel> findAll() {
        return fornecedorRepository.findAll();
    }

    public List<FornecedorModel> findlAllAtivo() {
        return fornecedorRepository.findlAllAtivo();
    }

    public Optional<FornecedorModel> findById(int id_forne) {
        return fornecedorRepository.findById(id_forne);
    }

    public boolean existsByCnpj(String cnpj) {
        return fornecedorRepository.existsByCnpj(cnpj);
    }

    public boolean existsById(int id_forne) {
        return fornecedorRepository.existsById(id_forne);
    }
}
