package br.com.oticanewlook.oticanewlook.model;

import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
@Table(name="funcionario")
public class FuncionarioModel {
    
    //ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_func;

    @Column()
    private String nome;

    @Column
    private String email;

    @Column
    private String senha;

    @Column
    private String endereco;

    @Column
    private String tel;

    @Column
    private String cel;

    @Column
    private String cpf;

    @Column
    private String ativo;

    @Column
    private LocalDateTime data_cadastro;

    private int id_cidade;

    private int id_tipo_func;

    public int getId_func() {
        return id_func;
    }

    public void setId_func(int id_func) {
        this.id_func = id_func;
    }

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

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public LocalDateTime getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(LocalDateTime localDateTime) {
        this.data_cadastro = localDateTime;
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
