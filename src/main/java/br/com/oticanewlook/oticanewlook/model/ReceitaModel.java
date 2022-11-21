package br.com.oticanewlook.oticanewlook.model;

import javax.persistence.*;

@Entity
@Table(name="receita")
public class ReceitaModel {
    
    //ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_receita;

    @Column
    private String medico;

    @Column
    private String longe_esf_od;

    @Column
    private String longe_cil_od;

    @Column
    private String longe_eixo_od;

    @Column
    private String longe_dnp_od;

    @Column
    private String longe_esf_oe;

    @Column
    private String longe_cil_oe;

    @Column
    private String longe_eixo_oe;

    @Column
    private String longe_dnp_oe;

    @Column
    private String perto_esf_od;

    @Column
    private String perto_cil_od;

    @Column
    private String perto_eixo_od;

    @Column
    private String perto_dnp_od;

    @Column
    private String perto_esf_oe;

    @Column
    private String perto_cil_oe;

    @Column
    private String perto_eixo_oe;

    @Column
    private String perto_dnp_oe;

    @Column
    private String adicao;

    @Column
    private String altura;

    @ManyToOne 
    @JoinColumn(name = "id_cliente",insertable = false,updatable = false)
    private ClienteModel cliente;
    private int id_cliente;

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public int getId_receita() {
        return id_receita;
    }

    public void setId_receita(int id_receita) {
        this.id_receita = id_receita;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getLonge_esf_od() {
        return longe_esf_od;
    }

    public void setLonge_esf_od(String longe_esf_od) {
        this.longe_esf_od = longe_esf_od;
    }

    public String getLonge_cil_od() {
        return longe_cil_od;
    }

    public void setLonge_cil_od(String longe_cil_od) {
        this.longe_cil_od = longe_cil_od;
    }

    public String getLonge_eixo_od() {
        return longe_eixo_od;
    }

    public void setLonge_eixo_od(String longe_eixo_od) {
        this.longe_eixo_od = longe_eixo_od;
    }

    public String getLonge_dnp_od() {
        return longe_dnp_od;
    }

    public void setLonge_dnp_od(String longe_dnp_od) {
        this.longe_dnp_od = longe_dnp_od;
    }

    public String getLonge_esf_oe() {
        return longe_esf_oe;
    }

    public void setLonge_esf_oe(String longe_esf_oe) {
        this.longe_esf_oe = longe_esf_oe;
    }

    public String getLonge_cil_oe() {
        return longe_cil_oe;
    }

    public void setLonge_cil_oe(String longe_cil_oe) {
        this.longe_cil_oe = longe_cil_oe;
    }

    public String getLonge_eixo_oe() {
        return longe_eixo_oe;
    }

    public void setLonge_eixo_oe(String longe_eixo_oe) {
        this.longe_eixo_oe = longe_eixo_oe;
    }

    public String getLonge_dnp_oe() {
        return longe_dnp_oe;
    }

    public void setLonge_dnp_oe(String longe_dnp_oe) {
        this.longe_dnp_oe = longe_dnp_oe;
    }

    public String getPerto_esf_od() {
        return perto_esf_od;
    }

    public void setPerto_esf_od(String perto_esf_od) {
        this.perto_esf_od = perto_esf_od;
    }

    public String getPerto_cil_od() {
        return perto_cil_od;
    }

    public void setPerto_cil_od(String perto_cil_od) {
        this.perto_cil_od = perto_cil_od;
    }

    public String getPerto_eixo_od() {
        return perto_eixo_od;
    }

    public void setPerto_eixo_od(String perto_eixo_od) {
        this.perto_eixo_od = perto_eixo_od;
    }

    public String getPerto_dnp_od() {
        return perto_dnp_od;
    }

    public void setPerto_dnp_od(String perto_dnp_od) {
        this.perto_dnp_od = perto_dnp_od;
    }

    public String getPerto_esf_oe() {
        return perto_esf_oe;
    }

    public void setPerto_esf_oe(String perto_esf_oe) {
        this.perto_esf_oe = perto_esf_oe;
    }

    public String getPerto_cil_oe() {
        return perto_cil_oe;
    }

    public void setPerto_cil_oe(String perto_cil_oe) {
        this.perto_cil_oe = perto_cil_oe;
    }

    public String getPerto_eixo_oe() {
        return perto_eixo_oe;
    }

    public void setPerto_eixo_oe(String perto_eixo_oe) {
        this.perto_eixo_oe = perto_eixo_oe;
    }

    public String getPerto_dnp_oe() {
        return perto_dnp_oe;
    }

    public void setPerto_dnp_oe(String perto_dnp_oe) {
        this.perto_dnp_oe = perto_dnp_oe;
    }

    public String getAdicao() {
        return adicao;
    }

    public void setAdicao(String adicao) {
        this.adicao = adicao;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    
}
