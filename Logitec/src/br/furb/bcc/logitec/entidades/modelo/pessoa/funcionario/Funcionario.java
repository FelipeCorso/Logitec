package br.furb.bcc.logitec.entidades.modelo.pessoa.funcionario;

import br.furb.bcc.logitec.entidades.modelo.pessoa.Pessoa;

public class Funcionario extends Pessoa {

    private char genero;
    private String dataAdm;
    private String dataNasc;
    private String cpf;
    private String rg;
    private String cargo;
    private String estadoCivil;
    private float salario;
    private ECNH cnh;

    public char getGenero() {
	return genero;
    }

    public void setGenero(char genero) {
	this.genero = genero;
    }

    public String getDataAdm() {
	return dataAdm;
    }

    public void setDataAdm(String dataAdm) {
	this.dataAdm = dataAdm;
    }

    public String getDataNasc() {
	return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
	this.dataNasc = dataNasc;
    }

    public String getCpf() {
	return cpf;
    }

    public void setCpf(String cpf) {
	this.cpf = cpf;
    }

    public String getRg() {
	return rg;
    }

    public void setRg(String rg) {
	this.rg = rg;
    }

    public String getCargo() {
	return cargo;
    }

    public void setCargo(String cargo) {
	this.cargo = cargo;
    }

    public String getEstadoCivil() {
	return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
	this.estadoCivil = estadoCivil;
    }

    public float getSalario() {
	return salario;
    }

    public void setSalario(float salario) {
	this.salario = salario;
    }

    public ECNH getCnh() {
	return cnh;
    }

    public void setCnh(ECNH cnh) {
	this.cnh = cnh;
    }

}
