package br.com.oticanewlook.oticanewlook.services;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import br.com.oticanewlook.oticanewlook.model.ClienteModel;
import br.com.oticanewlook.oticanewlook.repositories.ClienteRepository;


@Service
public class ClienteService {
    
    final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public ClienteModel save(ClienteModel clienteModel) {
        return clienteRepository.save(clienteModel);
    }

    @Transactional
    public void delete(ClienteModel clienteModel) {
        clienteRepository.delete(clienteModel);
    }

    @Transactional
    public void inativar(ClienteModel clienteModel) {
        clienteRepository.inativar(clienteModel);
    }

    public List<ClienteModel> findAll() {
        return clienteRepository.findAll();
    }

    public List<ClienteModel> findlAllAtivo() {
        return clienteRepository.findlAllAtivo();
    }

    public Optional<ClienteModel> findById(int id_cliente) {
        return clienteRepository.findById(id_cliente);
    }

    public boolean existsByCpf(String cpf) {
        return clienteRepository.existsByCpf(cpf);
    }

    public boolean existsById(int id_cliente) {
        return clienteRepository.existsById(id_cliente);
    }
}
