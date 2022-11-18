package br.com.oticanewlook.oticanewlook.services;

import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import br.com.oticanewlook.oticanewlook.model.ProdutoModel;
import br.com.oticanewlook.oticanewlook.repositories.ProdutoRepository;

@Service
public class ProdutoService {
    
    final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Transactional
    public ProdutoModel save(ProdutoModel produtoModel) {
        return produtoRepository.save(produtoModel);
    }

    @Transactional
    public void delete(ProdutoModel produtoModel) {
        produtoRepository.delete(produtoModel);
    }

    public Object findAll() {
        return produtoRepository.findAll();
    }

    public Optional<ProdutoModel> findById(int id_produto) {
        return produtoRepository.findById(id_produto);
    }

    public boolean existsByCodigo(int codigo) {
        return produtoRepository.existsByCodigo(codigo);
    }

    public boolean existsByNome(String nome) {
        return produtoRepository.existsByNome(nome);
    }
}
