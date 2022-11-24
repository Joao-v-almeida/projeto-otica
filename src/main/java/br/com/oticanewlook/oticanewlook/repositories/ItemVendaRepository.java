package br.com.oticanewlook.oticanewlook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.oticanewlook.oticanewlook.model.ItemVendaModel;

public interface ItemVendaRepository extends JpaRepository<ItemVendaModel,Integer>{
    
}
