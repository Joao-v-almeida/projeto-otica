package br.com.oticanewlook.oticanewlook.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;

public class FornecedorDto {
    
    @NotBlank(message = "Nome não pode ser vazio!")
    private String nome;

    @Length(max = 12, message = "Maximo de 12 caracteres, conforme a máscara!")
    private String tel;

    @NotBlank(message = "Celular não pode ser vazio!")
    @Length(max = 13, message = "Maximo de 13 caracteres, conforme a máscara!")
    @Length(min = 13, message="Minimo de 13 caracteres, conforme a máscara!")
    private String cel;

    @NotBlank
    @Length(max = 18, message = "Maximo de 18 caracteres, conforme a máscara!")
    @Length(min = 18, message="Minimo de 18 caracteres, conforme a máscara!")
    @CNPJ(message = "CNPJ Inválido!")
    private String cnpj;

    @NotNull
    private int id_cidade;

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

    public int getId_cidade() {
        return id_cidade;
    }

    public void setId_cidade(int id_cidade) {
        this.id_cidade = id_cidade;
    }
}
