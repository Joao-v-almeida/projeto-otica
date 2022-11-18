package br.com.oticanewlook.oticanewlook.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProdutoDto {
    
    @NotBlank
    private String nome;

    @NotNull
    private int codigo;

    @NotBlank
    private String descricao;

    @NotBlank
    private String outros;

    @NotNull
    private double preco_custo;

    @NotNull
    private double preco_venda;

    @NotNull
    private int estoque;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getOutros() {
        return outros;
    }

    public void setOutros(String outros) {
        this.outros = outros;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public double getPreco_custo() {
        return preco_custo;
    }

    public void setPreco_custo(double preco_custo) {
        this.preco_custo = preco_custo;
    }

    public double getPreco_venda() {
        return preco_venda;
    }

    public void setPreco_venda(double preco_venda) {
        this.preco_venda = preco_venda;
    }

    
}
