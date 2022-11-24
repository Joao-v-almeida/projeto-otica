package br.com.oticanewlook.oticanewlook.model;

import javax.persistence.*;

@Entity
@Table(name="item_venda")
public class ItemVendaModel {
    
    @Id
    private int id_venda;

    @ManyToOne
    @JoinColumn(name = "id_venda",insertable = false,updatable = false)
    private VendaModel venda;

    @Column
    private int quantidade;

    @Column
    private double preco;

    @ManyToOne
    @JoinColumn(name = "id_produto",insertable = false,updatable = false)
    private ProdutoModel produto;
    private String id_produto;

    public int getId_venda() {
        return id_venda;
    }
    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public ProdutoModel getProduto() {
        return produto;
    }
    public void setProduto(ProdutoModel produto) {
        this.produto = produto;
    }
    public String getId_produto() {
        return id_produto;
    }
    public void setId_produto(String id_produto) {
        this.id_produto = id_produto;
    }

    
}
