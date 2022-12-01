package br.com.oticanewlook.oticanewlook.model;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name="movimentacao")
public class MovimentacaoModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_movi;

    @Column(name = "valor")
    private double valor;

    @Column(name = "tipo_movi")
    private String tipoMovi;

    @Column(name = "data_movi")
    private LocalDate dataMovi;
    
    @ManyToOne 
    @JoinColumn(name = "id_contas_receb",insertable = false,updatable = false)
    private ContasReceberModel contas;
    private int id_contas_receb;

    @ManyToOne 
    @JoinColumn(name = "id_func",insertable = false,updatable = false)
    private FuncionarioModel funcionario;
    private int id_func;
    public int getId_movi() {
        return id_movi;
    }
    public void setId_movi(int id_movi) {
        this.id_movi = id_movi;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public String getTipoMovi() {
        return tipoMovi;
    }
    public void setTipoMovi(String tipoMovi) {
        this.tipoMovi = tipoMovi;
    }
    public LocalDate getDataMovi() {
        return dataMovi;
    }
    public void setDataMovi(LocalDate dataMovi) {
        this.dataMovi = dataMovi;
    }
    public ContasReceberModel getContas() {
        return contas;
    }
    public void setContas(ContasReceberModel contas) {
        this.contas = contas;
    }
    public int getId_contas_receb() {
        return id_contas_receb;
    }
    public void setId_contas_receb(int id_contas_receb) {
        this.id_contas_receb = id_contas_receb;
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
