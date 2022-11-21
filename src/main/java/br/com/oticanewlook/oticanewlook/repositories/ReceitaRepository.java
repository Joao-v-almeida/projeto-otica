package br.com.oticanewlook.oticanewlook.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.oticanewlook.oticanewlook.model.ReceitaModel;

public interface ReceitaRepository extends JpaRepository<ReceitaModel, Integer> {

    @Query(value = "SELECT *, c.nome nomeCliente FROM receita r INNER JOIN cliente c WHERE r.id_cliente = c.id_cliente", nativeQuery= true)
    List<ReceitaModel> findInnerCliente();
    
}
