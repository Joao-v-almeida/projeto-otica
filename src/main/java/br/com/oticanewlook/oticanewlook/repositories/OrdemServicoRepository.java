package br.com.oticanewlook.oticanewlook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.oticanewlook.oticanewlook.model.OrdemServicoModel;

public interface OrdemServicoRepository extends JpaRepository<OrdemServicoModel, Integer>{

    boolean existsByNum_os(String num_os);
}
