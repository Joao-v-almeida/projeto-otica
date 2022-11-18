package br.com.oticanewlook.oticanewlook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.oticanewlook.oticanewlook.model.EstadoModel;


public interface EstadoRepository extends JpaRepository<EstadoModel, Integer>{
    
    boolean existsByNome(String nome);
}
