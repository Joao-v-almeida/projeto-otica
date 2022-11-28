package br.com.oticanewlook.oticanewlook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.oticanewlook.oticanewlook.model.OrdemServicoModel;

public interface OrdemServicoRepository extends JpaRepository<OrdemServicoModel, Integer> {

    boolean existsByNumOs(int numOs);
}
