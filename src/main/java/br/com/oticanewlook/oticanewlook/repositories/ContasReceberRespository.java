package br.com.oticanewlook.oticanewlook.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import br.com.oticanewlook.oticanewlook.model.ContasReceberModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface ContasReceberRespository extends JpaRepository<ContasReceberModel, Integer> {

    @Procedure
    @Query(value = "CALL rebeberConta(:id_contas_receb, :id_funcionario);", nativeQuery = true)
    void rebeberConta(@Param("id_contas_receb") int id_contas_receb, @Param("id_funcionario") int id_funcionario);

    @Procedure
    @Query(value = "CALL cancelarRecebimento(:id_contas_receb, :id_funcionario);", nativeQuery = true)
    void cancelarRecebimento(@Param("id_contas_receb") int id_contas_receb, @Param("id_funcionario") int id_funcionario);
}
