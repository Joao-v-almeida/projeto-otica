package br.com.oticanewlook.oticanewlook.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.oticanewlook.oticanewlook.model.OrdemServicoModel;

public interface OrdemServicoRepository extends JpaRepository<OrdemServicoModel, Integer> {

    @Query(value = "SELECT * FROM ordem_servico WHERE num_os =:num_os", nativeQuery = true)
    boolean findByNum_os(@Param("num_os")int num_os);

}
