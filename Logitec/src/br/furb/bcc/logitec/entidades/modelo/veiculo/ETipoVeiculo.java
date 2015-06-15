package br.furb.bcc.logitec.entidades.modelo.veiculo;

public enum ETipoVeiculo {
    MOTO(1, "Moto"), CARRO(2, "Carro"), CAMINHAO(3, "Caminhão"), CARRETA(4, "Carreta");

    private int codigoTipo;
    private String descricao;

    private ETipoVeiculo(int codTipo, String descricao) {
	this.codigoTipo = codTipo;
	this.descricao = descricao;
    }

    public int getCodigoTipo() {
	return codigoTipo;
    }

    public void setCodigoTipo(int codigoTipo) {
	this.codigoTipo = codigoTipo;
    }

    @Override
    public String toString() {
	return descricao;
    }

    public static ETipoVeiculo valueOf(int codTipo) {
	for (ETipoVeiculo tipoVeiculo : ETipoVeiculo.values()) {
	    if (tipoVeiculo.getCodigoTipo() == codTipo) {
		return tipoVeiculo;
	    }
	}
	return null;
    }
}
