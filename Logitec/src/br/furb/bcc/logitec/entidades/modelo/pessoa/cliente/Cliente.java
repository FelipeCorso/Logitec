package br.furb.bcc.logitec.entidades.modelo.pessoa.cliente;

import br.furb.bcc.logitec.entidades.modelo.pessoa.ETipoPessoa;
import br.furb.bcc.logitec.entidades.modelo.pessoa.Pessoa;

public class Cliente extends Pessoa {

    private ETipoPessoa tipPessoa;
    private String datCad;
    private String cpf;
    private String cnpj;
    private String rg;
    /**
     * Inscrição Estadual
     */
    private String inscEst;
    private int id;

    public ETipoPessoa getTipPessoa() {
	return tipPessoa;
    }

    public void setTipPessoa(ETipoPessoa tipPessoa) {
	this.tipPessoa = tipPessoa;
    }

    public String getDatCad() {
	return datCad;
    }

    public void setDatCad(String datCad) {
	this.datCad = datCad;
    }

    public String getCpf() {
	return cpf;
    }

    public void setCpf(String cpf) {
	this.cpf = cpf;
    }

    public String getCnpj() {
	return cnpj;
    }

    public void setCnpj(String cnpj) {
	this.cnpj = cnpj;
    }

    public String getRg() {
	return rg;
    }

    public void setRg(String rg) {
	this.rg = rg;
    }

    public String getInscEst() {
	return inscEst;
    }

    public void setInscEst(String inscEst) {
	this.inscEst = inscEst;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

}
