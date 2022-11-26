package br.com.oticanewlook.oticanewlook.model;

import javax.persistence.*;

@Entity
@Table(name="venda")
public class VendaModel {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_venda;

    @Column
    private String desconto;

    @Column
    private double total_desc;
    
    @Column
    private double valor;

    @ManyToOne 
    @JoinColumn(name = "id_receita",insertable = false,updatable = false)
    private ReceitaModel receita;
    private int id_receita;



    //GET E SET
    public int getId_venda() {
        return id_venda;
    }
    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }
    public String getDesconto() {
        return desconto;
    }
    public void setDesconto(String desconto) {
        this.desconto = desconto;
    }
    public double getTotal_desc() {
        return total_desc;
    }
    public void setTotal_desc(double total_desc) {
        this.total_desc = total_desc;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public ReceitaModel getReceita() {
        return receita;
    }
    public void setReceita(ReceitaModel receita) {
        this.receita = receita;
    }
    public int getId_receita() {
        return id_receita;
    }
    public void setId_receita(int id_receita) {
        this.id_receita = id_receita;
    }

    
}
