package br.com.oticanewlook.oticanewlook.model;

import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
@Table(name="contas_receber")
public class ContasReceberModel {

    //ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_contas_receb;

    @Column
    private int num_parc_total;

    @Column
    private int num_parc_paga;

    @Column
    private double valor_parcela;

    @Column
    private String situacao;

    @Column
    private LocalDateTime data_venci;

    @ManyToOne 
    @JoinColumn(name = "id_receb",insertable = false,updatable = false)
    private RecebimentoModel recebimento;
    private int id_receb;


    public int getId_contas_receb() {
        return id_contas_receb;
    }
    public void setId_contas_receb(int id_contas_receb) {
        this.id_contas_receb = id_contas_receb;
    }
    public int getNum_parc_total() {
        return num_parc_total;
    }
    public void setNum_parc_total(int num_parc_total) {
        this.num_parc_total = num_parc_total;
    }
    public int getNum_parc_paga() {
        return num_parc_paga;
    }
    public void setNum_parc_paga(int num_parc_paga) {
        this.num_parc_paga = num_parc_paga;
    }
    public double getValor_parcela() {
        return valor_parcela;
    }
    public void setValor_parcela(double valor_parcela) {
        this.valor_parcela = valor_parcela;
    }
    public String getSituacao() {
        return situacao;
    }
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    public LocalDateTime getData_venci() {
        return data_venci;
    }
    public void setData_venci(LocalDateTime data_venci) {
        this.data_venci = data_venci;
    }
    public RecebimentoModel getRecebimento() {
        return recebimento;
    }
    public void setRecebimento(RecebimentoModel recebimento) {
        this.recebimento = recebimento;
    }
    public int getId_receb() {
        return id_receb;
    }
    public void setId_receb(int id_receb) {
        this.id_receb = id_receb;
    }  
}