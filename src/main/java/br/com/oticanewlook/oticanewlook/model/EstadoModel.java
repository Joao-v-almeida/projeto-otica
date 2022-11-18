package br.com.oticanewlook.oticanewlook.model;

import javax.persistence.*;

@Entity
@Table(name="estado")
public class EstadoModel {

    //ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_estado;

    @Column()
    private String nome;
    
    //SET E GET
    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
