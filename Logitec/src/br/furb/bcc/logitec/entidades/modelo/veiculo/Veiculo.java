package br.furb.bcc.logitec.entidades.modelo.veiculo;

import br.furb.bcc.logitec.entidades.modelo.IEntidade;

public class Veiculo implements IEntidade {

    private int id;
    private String placa;
    private String descricao;
    private ETipoVeiculo tipo;
    private double capacidade;

    public ETipoVeiculo getTipo() {
	return tipo;
    }

    public String getDescricao() {
	return descricao;
    }

    public void setDescricao(String descricao) {
	this.descricao = descricao;
    }

    public void setTipo(ETipoVeiculo tipo) {
	this.tipo = tipo;
    }

    public String getPlaca() {
	return placa;
    }

    public void setPlaca(String placa) {
	this.placa = placa;
    }

    public double getCapacidade() {
	return capacidade;
    }

    public void setCapacidade(double capacidade) {
	this.capacidade = capacidade;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

}
