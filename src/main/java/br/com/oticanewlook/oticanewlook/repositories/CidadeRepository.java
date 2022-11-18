package br.com.oticanewlook.oticanewlook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.oticanewlook.oticanewlook.model.CidadeModel;

@Repository
public interface CidadeRepository extends JpaRepository<CidadeModel, Integer> {
    
    boolean existsByNome(String nome);
}
