package br.com.oticanewlook.oticanewlook.model;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name="fornecedor")
public class FornecedorModel {
    
    //ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_forne;

    @Column()
    private String nome;

    @Column
    private String tel;

    @Column
    private String cel;

    @Column
    private String cnpj;

    @Column
    private String ativo;

    @Column
    private LocalDate data_cadastro;

    private int id_cidade;

    public int getId_forne() {
        return id_forne;
    }

    public void setId_forne(int id_forne) {
        this.id_forne = id_forne;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public LocalDate getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(LocalDate data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public int getId_cidade() {
        return id_cidade;
    }

    public void setId_cidade(int id_cidade) {
        this.id_cidade = id_cidade;
    }
}
