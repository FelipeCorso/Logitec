package br.furb.bcc.logitec.entidades.controle.dao;

import java.sql.SQLException;

import br.furb.bcc.logitec.entidades.modelo.IEntidade;

public interface IDataAccessObject {

    public IEntidade recuperar(int id) throws SQLException;

    public void inserir(IEntidade entidade) throws SQLException;

    public void alterar(IEntidade entidade) throws SQLException;

    public void remover(IEntidade entidade) throws SQLException;
}
