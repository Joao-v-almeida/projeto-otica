package br.com.oticanewlook.oticanewlook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import br.com.oticanewlook.oticanewlook.model.VendaModel;

public interface VendaRepository extends JpaRepository<VendaModel, Integer> {

    @Procedure @Query(value = "CALL registrar_dependentes_venda(:desconto, :id_receita, :total_desc, :valor, :id_produto, :quantidade, :num_parc_total, :num_os, :id_func);", nativeQuery = true)
    void registrar_dependentes_venda(@Param("desconto") double desconto, @Param("id_receita") int id_receita, @Param("total_desc") double total_desc, @Param("valor") double valor, @Param("id_produto") int id_produto, @Param("quantidade") int quantidade, @Param("num_parc_total") int num_parc_total,  @Param("num_os") int num_os, @Param("id_func") int id_func);
    
}
