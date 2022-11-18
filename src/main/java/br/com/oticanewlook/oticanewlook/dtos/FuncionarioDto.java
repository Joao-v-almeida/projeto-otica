package br.com.oticanewlook.oticanewlook.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

public class FuncionarioDto {
    
    @NotBlank
    private String nome;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String senha;

    @NotBlank
    private String endereco;

    @Length(max = 13)
    private String tel;

    @NotBlank
    @Length(max = 14)
    private String cel;

    @NotBlank
    @Length(max = 14)
    @CPF(message = "CPF inválido!")
    private String cpf;

    @NotNull
    private int id_cidade;

    @NotNull
    private int id_tipo_func;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    public int getId_tipo_func() {
        return id_tipo_func;
    }

    public void setId_tipo_func(int id_tipo_func) {
        this.id_tipo_func = id_tipo_func;
    }
}
