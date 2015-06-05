package br.furb.bcc.logitec.entidades.controle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.furb.bcc.logitec.entidades.controle.conexao.ConnectionFactory;
import br.furb.bcc.logitec.entidades.modelo.Cliente;
import br.furb.bcc.logitec.entidades.modelo.IEntidade;

public class ClienteDAO implements IDataAccessObject {

	@Override
	public void insere(IEntidade entidade) throws SQLException {
		int newId = getNewId();
		if (newId == 0) {
			newId = 1;
		}

		Connection connection = new ConnectionFactory().getConnection();
		try {

			String sql = "insert into cliente " + "(nome, tipPessoa, datCad, cpf, cnpj, rg, inscEst, endereco, telefone, email, id)" + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			Cliente cliente = (Cliente) entidade;
			cliente.setId(newId);

			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getTipPessoa().toString());
			stmt.setString(3, cliente.getDatCad());
			stmt.setString(4, cliente.getCpf());
			stmt.setString(5, cliente.getCnpj());
			stmt.setString(6, cliente.getRg());
			stmt.setString(7, cliente.getInscEst());
			stmt.setString(8, cliente.getEndereco());
			stmt.setString(9, cliente.getTelefone());
			stmt.setString(10, cliente.getEmail());
			stmt.setInt(11, cliente.getId());

			// executa
			stmt.execute();
			stmt.close();

		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}

	@Override
	public void altera(IEntidade entidade) throws SQLException {
		Connection connection = new ConnectionFactory().getConnection();
		try {
			String sql = "update cliente set nome=?, tipPessoa=?, datCad=?, cpf=?, cnpj=?, rg=?, inscEst=?, endereco=?, telefone=?, email=?" + "where id=?";

			Cliente cliente = (Cliente) entidade;

			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getTipPessoa().toString());
			stmt.setString(3, cliente.getDatCad());
			stmt.setString(4, cliente.getCpf());
			stmt.setString(5, cliente.getCnpj());
			stmt.setString(6, cliente.getRg());
			stmt.setString(7, cliente.getInscEst());
			stmt.setString(8, cliente.getEndereco());
			stmt.setString(9, cliente.getTelefone());
			stmt.setString(10, cliente.getEmail());
			stmt.setInt(11, cliente.getId());

			stmt.execute();
			stmt.close();
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}

	@Override
	public void remove(IEntidade entidade) throws SQLException {

		Connection connection = new ConnectionFactory().getConnection();
		try {
			Cliente cliente = (Cliente) entidade;

			PreparedStatement stmt = connection.prepareStatement("delete from cliente where id=?");
			stmt.setInt(1, cliente.getId());
			stmt.execute();
			stmt.close();
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}

	private int getNewId() throws SQLException {
		Connection connection = new ConnectionFactory().getConnection();
		try {

			int newId;
			PreparedStatement stmt = connection.prepareStatement("select max(id) as id from cliente;");
			ResultSet rs = stmt.executeQuery();

			rs.first();
			newId = rs.getInt("id");

			rs.close();
			stmt.close();

			return newId;

		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}

}
