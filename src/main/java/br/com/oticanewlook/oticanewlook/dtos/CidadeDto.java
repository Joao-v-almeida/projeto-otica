package br.com.oticanewlook.oticanewlook.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CidadeDto {
    
    //VALIDAÇÃO
    @NotBlank
    private String nome;

    @NotNull
    private int id_estado;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }
}
