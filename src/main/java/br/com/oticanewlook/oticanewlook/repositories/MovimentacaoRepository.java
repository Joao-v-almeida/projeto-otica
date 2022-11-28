package br.com.oticanewlook.oticanewlook.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.oticanewlook.oticanewlook.model.MovimentacaoModel;

public interface MovimentacaoRepository extends JpaRepository<MovimentacaoModel, Integer>{

    @Query(value = "SELECT * FROM movimentacao WHERE tipo_movi = 'ENTRADA'", nativeQuery = true)
    public List<MovimentacaoModel> findlAllEntrada();
    
}
