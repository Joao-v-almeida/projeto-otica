package br.com.oticanewlook.oticanewlook.services;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import br.com.oticanewlook.oticanewlook.model.CidadeModel;
import br.com.oticanewlook.oticanewlook.repositories.CidadeRepository;


@Service
public class CidadeService {

    final CidadeRepository cidadeRepository;

    public CidadeService(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

    @Transactional
    public CidadeModel save(CidadeModel cidadeModel) {
        return cidadeRepository.save(cidadeModel);
    }

    @Transactional
    public void delete(CidadeModel cidadeModel) {
        cidadeRepository.delete(cidadeModel);
    }

    public List<CidadeModel> findAll() {
        return cidadeRepository.findAll();
    }

    public Optional<CidadeModel> findById(int id_cidade) {
        return cidadeRepository.findById(id_cidade);
    }

    public boolean existsByNome(String nome) {
        return cidadeRepository.existsByNome(nome);
    }
/* 
    public int localizarIdEstado(String nomeEstado) {
        int idEstado = 0;

        switch (nomeEstado) {
            case "ACRE":
                idEstado = 1;
                break;
            case "ALAGOAS":
                idEstado = 2;
                break;
            case "AMAPA":
                idEstado = 3;
                break;
            case "AMAZONAS":
                idEstado = 4;
                break;
            case "BAHIA":
                idEstado = 5;
                break;
            case "CEARA":
                idEstado = 6;
                break;
            case "ESPIRITO SANTO":
                idEstado = 7;
                break;
            case "GOIAS":
                idEstado = 8;
                break;
            case "MARANHAO":
                idEstado = 9;
                break;
            case "MATO GROSSO":
                idEstado = 10;
                break;
            case "MATO GROSSO DO SUL":
                idEstado = 11;
                break;
            case "MINAS GERAIS":
                idEstado = 12;
                break;
            case "PARA":
                idEstado = 13;
                break;
            case "PARAIBA":
                idEstado = 14;
                break;
            case "PARANA":
                idEstado = 15;
                break;
            case "PERNAMBUCO":
                idEstado = 16;
                break;
            case "PIAUI":
                idEstado = 17;
                break;
            case "RIO DE JANEIRO":
                idEstado = 18;
                break;
            case "RIO GRANDE DO NORTE":
                idEstado = 19;
                break;
            case "RIO GRANDE DO SUL":
                idEstado = 20;
                break;
            case "RONDONIA":
                idEstado = 21;
                break;
            case "RORAIMA":
                idEstado = 22;
                break;
            case "SANTA CATARINA":
                idEstado = 23;
                break;
            case "SAO PAULO":
                idEstado = 24;
                break;
            case "SERGIPE":
                idEstado = 25;
                break;
            case "TOCANTINS":
                idEstado = 26;
                break;
        }
        return idEstado;
    }*/
}
