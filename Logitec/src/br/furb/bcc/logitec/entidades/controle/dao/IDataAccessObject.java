package br.furb.bcc.logitec.entidades.controle.dao;

import java.sql.SQLException;

import br.furb.bcc.logitec.entidades.modelo.IEntidade;

public interface IDataAccessObject {
	public void insere(IEntidade entidade) throws SQLException;

	public void altera(IEntidade entidade) throws SQLException;

	public void remove(IEntidade entidade) throws SQLException;
}
