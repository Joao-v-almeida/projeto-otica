package br.com.oticanewlook.oticanewlook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.oticanewlook.oticanewlook.model.ProdutoModel;


public interface ProdutoRepository extends JpaRepository<ProdutoModel,Integer>{
    boolean existsByCodigo(int codigo);
    boolean existsByNome(String nome);
}
