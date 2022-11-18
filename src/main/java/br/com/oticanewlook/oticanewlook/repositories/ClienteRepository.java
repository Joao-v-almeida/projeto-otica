package br.com.oticanewlook.oticanewlook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import br.com.oticanewlook.oticanewlook.model.ClienteModel;


public interface ClienteRepository extends JpaRepository<ClienteModel, Integer> {
    
    @Query(value = "SELECT * FROM cliente WHERE ativo = 'S'", nativeQuery = true)
    public List<ClienteModel> findlAllAtivo();

    @Modifying@Query(value = "UPDATE cliente SET ativo = 'N' WHERE id_cliente =:id_cliente", nativeQuery = true)
    void inativar(@Param("id_cliente") ClienteModel clienteModel);

    boolean existsByCpf(String cpf);

    boolean existsById(int id_cliente);
}
