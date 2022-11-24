package br.com.oticanewlook.oticanewlook.services;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import br.com.oticanewlook.oticanewlook.model.VendaModel;
import br.com.oticanewlook.oticanewlook.repositories.VendaRepository;

@Service
public class VendaService {

    final VendaRepository vendaRepository;

    public VendaService(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    @Transactional
    public VendaModel save(VendaModel vendaModel) {
        return vendaRepository.save(vendaModel);
    }

    public List<VendaModel> findAll() {
        return vendaRepository.findAll();
    }

    public Optional<VendaModel> findById(int id_venda) {
        return vendaRepository.findById(id_venda);
    }

    public boolean existsById(int id_venda) {
        return vendaRepository.existsById(id_venda);
    }

    public void registrar_dependentes_venda(double desconto, int id_receita, double total_desc, double valor, int id_produto,
            int quantidade, int num_parc_total, int num_os, int id_func) {
        vendaRepository.registrar_dependentes_venda(desconto, id_receita, total_desc, valor, id_produto, quantidade,
                num_parc_total, num_os, id_func);
    }
}
