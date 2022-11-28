package br.com.oticanewlook.oticanewlook.model;

import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
@Table(name="ordem_servico")
public class OrdemServicoModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_os;

    @Column
    private int num_os;

    @Column
    private double valor_total;

    @Column
    private String situacao;

    @Column
    private LocalDateTime data_cadastro;

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
    public int getNum_os() {
        return num_os;
    }
    public void setNum_os(int num_os) {
        this.num_os = num_os;
    }
    public double getValor_total() {
        return valor_total;
    }
    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }
    public String getSituacao() {
        return situacao;
    }
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    public LocalDateTime getData_cadastro() {
        return data_cadastro;
    }
    public void setData_cadastro(LocalDateTime data_cadastro) {
        this.data_cadastro = data_cadastro;
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
