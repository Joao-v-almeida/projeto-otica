package br.com.oticanewlook.oticanewlook.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.oticanewlook.oticanewlook.model.ItemVendaModel;
import br.com.oticanewlook.oticanewlook.repositories.ItemVendaRepository;

@Service
public class ItemVendaService {
    
    final ItemVendaRepository itemVendaRepository;

    public ItemVendaService(ItemVendaRepository itemVendaRepository) {
        this.itemVendaRepository = itemVendaRepository;
    }

    public List<ItemVendaModel> findAll() {
        return itemVendaRepository.findAll();
    }

    public Optional<ItemVendaModel> findById(int id_produto) {
        return itemVendaRepository.findById(id_produto);
    }

}
