package br.com.oticanewlook.oticanewlook.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.oticanewlook.oticanewlook.model.MovimentacaoModel;
import br.com.oticanewlook.oticanewlook.repositories.MovimentacaoRepository;

@Service
public class MovimentacaoService {

    final MovimentacaoRepository movimentacaoRepository;
    
    public MovimentacaoService(MovimentacaoRepository movimentacaoRepository) {
        this.movimentacaoRepository = movimentacaoRepository;
    }

    public List<MovimentacaoModel> findlAllEntrada() {
        return movimentacaoRepository.findlAllEntrada();
    }
}
