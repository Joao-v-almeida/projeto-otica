package br.com.oticanewlook.oticanewlook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.oticanewlook.oticanewlook.model.TipoFuncionarioModel;

@Repository
public interface TipoFuncionarioRepository extends JpaRepository<TipoFuncionarioModel, Integer> {

    boolean existsByNome(String nome);
}
