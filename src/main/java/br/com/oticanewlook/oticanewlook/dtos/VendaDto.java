package br.com.oticanewlook.oticanewlook.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class VendaDto {

    private String desconto;
    
    @NotNull(message = "Total não pode estar em branco")
    private double total_desc;
    
    private double valor;

    @NotBlank(message = "Quantidade não pode estar em branco")
    private String quantidade;

    @NotBlank(message = "Número de parcela não ser estar em branco")
    private String num_parc_total;

    @NotBlank(message = "Numero de O.S não pode estar em branco")
    private String num_os;

    private int id_produto;

    private int id_receita;


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

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getNum_parc_total() {
        return num_parc_total;
    }

    public void setNum_parc_total(String num_parc_total) {
        this.num_parc_total = num_parc_total;
    }

    public String getNum_os() {
        return num_os;
    }

    public void setNum_os(String num_os) {
        this.num_os = num_os;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public String getDesconto() {
        return desconto;
    }

    public void setDesconto(String desconto) {
        this.desconto = desconto;
    }

    public int getId_receita() {
        return id_receita;
    }

    public void setId_receita(int id_receita) {
        this.id_receita = id_receita;
    }
}
