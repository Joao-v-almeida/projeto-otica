package br.com.oticanewlook.oticanewlook.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

public class ClienteDto {
    
    @NotBlank(message = "Nome não pode estar em branco!")
    private String nome;

    @NotBlank(message = "Endereço não pode estar em branco!")
    private String endereco;

    @Length(max = 12)
    private String tel;

    @NotBlank(message = "Celular não pode estar em branco!")
    @Length(max = 13)
    private String cel;

    @NotBlank
    @Length(max = 14)
    @CPF(message = "CPF inválido!")
    private String cpf;

    @NotNull
    private int id_cidade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getId_cidade() {
        return id_cidade;
    }

    public void setId_cidade(int id_cidade) {
        this.id_cidade = id_cidade;
    }
}
