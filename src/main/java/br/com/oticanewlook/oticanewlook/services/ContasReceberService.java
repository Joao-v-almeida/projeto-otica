package br.com.oticanewlook.oticanewlook.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import br.com.oticanewlook.oticanewlook.model.ContasReceberModel;
import br.com.oticanewlook.oticanewlook.repositories.ContasReceberRespository;

@Service
public class ContasReceberService {

    final ContasReceberRespository contasReceberRespository;

    public ContasReceberService(ContasReceberRespository contasReceberRespository) {
        this.contasReceberRespository = contasReceberRespository;
    }

    public List<ContasReceberModel> findAll() {
        return contasReceberRespository.findAll();
    }

    public Optional<ContasReceberModel> findById(int id_contas_receb) {
        return contasReceberRespository.findById(id_contas_receb);
    }

    public boolean existsById(int id_contas_receb) {
        return contasReceberRespository.existsById(id_contas_receb);
    }

    public void rebeberConta(int id_contas_receb, int id_funcionario) {
        contasReceberRespository.rebeberConta(id_contas_receb, id_funcionario);
    }

    public void cancelarRecebimento(int id_contas_receb, int id_funcionario) {
        contasReceberRespository.cancelarRecebimento(id_contas_receb, id_funcionario);
    }
}
