package br.com.oticanewlook.oticanewlook.model;

import javax.persistence.*;

@Entity
@Table(name="tipo_funcionario")
public class TipoFuncionarioModel {
    
    //ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_tipo_func;

    @Column()
    private String nome;

    //SET E GET
    public int getId_tipo_func() {
        return id_tipo_func;
    }

    public void setId_tipo_func(int id_tipo_func) {
        this.id_tipo_func = id_tipo_func;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
