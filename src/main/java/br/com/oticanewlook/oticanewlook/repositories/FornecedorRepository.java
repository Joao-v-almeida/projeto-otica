package br.com.oticanewlook.oticanewlook.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.oticanewlook.oticanewlook.model.FornecedorModel;


public interface FornecedorRepository extends JpaRepository<FornecedorModel, Integer> {
    
    @Query(value = "SELECT * FROM fornecedor WHERE ativo = 'S'", nativeQuery = true)
    public List<FornecedorModel> findlAllAtivo();

    @Modifying@Query(value = "UPDATE fornecedor SET ativo = 'N' WHERE id_forne =:id_forne", nativeQuery = true)
    void inativar(@Param("id_forne") FornecedorModel fornecedorModel);

    boolean existsByCnpj(String cnpj);

    boolean existsById(int id_forne);
}
