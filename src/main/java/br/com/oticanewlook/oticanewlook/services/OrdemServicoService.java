package br.com.oticanewlook.oticanewlook.services;

import java.util.List;
import org.springframework.stereotype.Service;
import br.com.oticanewlook.oticanewlook.model.OrdemServicoModel;
import br.com.oticanewlook.oticanewlook.repositories.OrdemServicoRepository;

@Service
public class OrdemServicoService {

    final OrdemServicoRepository ordemServicoRepository;
    
    public OrdemServicoService(OrdemServicoRepository ordemServicoRepository) {
        this.ordemServicoRepository = ordemServicoRepository;
    }

    public List<OrdemServicoModel> findAll() {
        return ordemServicoRepository.findAll();
    }

    public boolean existsBynum_os(int num_os) {
        return ordemServicoRepository.existsBynum_os(num_os);
    }
}
