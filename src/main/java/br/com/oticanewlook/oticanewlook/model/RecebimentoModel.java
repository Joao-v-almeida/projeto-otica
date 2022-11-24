package br.com.oticanewlook.oticanewlook.model;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name="recebimento")
public class RecebimentoModel {

    //ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_receb;

    @Column
    private double valor;

    @Column
    private String situacao;

    @Column
    private LocalDateTime data_receb;

    @ManyToOne 
    @JoinColumn(name = "id_venda",insertable = false,updatable = false)
    private VendaModel venda;
    private int id_venda;
    
    public int getId_receb() {
        return id_receb;
    }
    public void setId_receb(int id_receb) {
        this.id_receb = id_receb;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public String getSituacao() {
        return situacao;
    }
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    public LocalDateTime getData_receb() {
        return data_receb;
    }
    public void setData_receb(LocalDateTime data_receb) {
        this.data_receb = data_receb;
    }
    public VendaModel getVenda() {
        return venda;
    }
    public void setVenda(VendaModel venda) {
        this.venda = venda;
    }
    public int getId_venda() {
        return id_venda;
    }
    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }

    
}
