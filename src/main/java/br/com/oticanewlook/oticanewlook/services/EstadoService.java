package br.com.oticanewlook.oticanewlook.services;

import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import br.com.oticanewlook.oticanewlook.model.EstadoModel;
import br.com.oticanewlook.oticanewlook.repositories.EstadoRepository;

@Service
public class EstadoService {
    
    final EstadoRepository estadoRepository;


    public EstadoService(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }
     
    @Transactional
    public EstadoModel save(EstadoModel estadoModel) {
        return estadoRepository.save(estadoModel);
    }

    @Transactional
    public void delete(EstadoModel estadoModel) {
        estadoRepository.delete(estadoModel);
    }

    public Object findAll() {
        return estadoRepository.findAll();
    }

    public Optional<EstadoModel> findById(int id_estado) {
        return estadoRepository.findById(id_estado);
    }

    public boolean existsByNome(String nome) {
        return estadoRepository.existsByNome(nome);
    }
}
