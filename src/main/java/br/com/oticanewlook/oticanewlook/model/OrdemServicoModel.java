package br.com.oticanewlook.oticanewlook.model;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name="ordem_servico")
public class OrdemServicoModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_os;

    @Column(name = "num_os")
    private int numOs;

    @Column(name = "valor_total")
    private double valorTotal;

    @Column
    private String situacao;

    @Column(name = "data_cadastro")
    private LocalDate dataCadastro;

    @ManyToOne 
    @JoinColumn(name = "id_venda",insertable = false,updatable = false)
    private VendaModel venda;
    private int id_venda;

    @ManyToOne 
    @JoinColumn(name = "id_func",insertable = false,updatable = false)
    private FuncionarioModel funcionario;
    private int id_func;
    
    public int getId_os() {
        return id_os;
    }

    public void setId_os(int id_os) {
        this.id_os = id_os;
    }

    public int getNumOs() {
        return numOs;
    }

    public void setNumOs(int numOs) {
        this.numOs = numOs;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
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

    public FuncionarioModel getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(FuncionarioModel funcionario) {
        this.funcionario = funcionario;
    }

    public int getId_func() {
        return id_func;
    }

    public void setId_func(int id_func) {
        this.id_func = id_func;
    }
}
