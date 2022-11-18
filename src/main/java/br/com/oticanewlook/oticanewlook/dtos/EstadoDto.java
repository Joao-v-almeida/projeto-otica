package br.com.oticanewlook.oticanewlook.dtos;

import javax.validation.constraints.NotBlank;

public class EstadoDto {
    
    //VALIDAÇÃO
    @NotBlank
    private String nome;

    //GET E SET
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
