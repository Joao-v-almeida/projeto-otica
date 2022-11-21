package br.com.oticanewlook.oticanewlook.services;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import br.com.oticanewlook.oticanewlook.model.ReceitaModel;
import br.com.oticanewlook.oticanewlook.repositories.ReceitaRepository;

@Service
public class ReceitaService {
    
    final ReceitaRepository receitaRepository;

    public ReceitaService(ReceitaRepository receitaRepository) {
        this.receitaRepository = receitaRepository;
    }

    @Transactional
    public ReceitaModel save(ReceitaModel receitaModel) {
        return receitaRepository.save(receitaModel);
    }

    public List<ReceitaModel> findAll() {
        return receitaRepository.findAll();
    }

    public Optional<ReceitaModel> findById(int id_receita) {
        return receitaRepository.findById(id_receita);
    }

    public boolean existsById(int id_receita) {
        return receitaRepository.existsById(id_receita);
    }

    public List<ReceitaModel> findInnerCliente() {
        return receitaRepository.findInnerCliente();
    }
}
