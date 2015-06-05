package br.furb.bcc.logitec.entidades.controle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;

import br.furb.bcc.logitec.entidades.controle.conexao.ConnectionFactory;
import br.furb.bcc.logitec.entidades.controle.dao.colunas.ColunasFuncionario;
import br.furb.bcc.logitec.entidades.controle.dao.colunas.ColunasPessoa;
import br.furb.bcc.logitec.entidades.modelo.IEntidade;
import br.furb.bcc.logitec.entidades.modelo.pessoa.funcionario.ECNH;
import br.furb.bcc.logitec.entidades.modelo.pessoa.funcionario.Funcionario;

public class FuncionarioDAO implements IDataAccessObject {
    @Override
    public IEntidade recuperar(int id) throws SQLException {
	Connection connection = new ConnectionFactory().getConnection();
	try {

	    String sql = "SELECT * FROM FUNCIONARIO WHERE id={0}";
	    PreparedStatement stmt = connection.prepareStatement(MessageFormat.format(sql, id));
	    ResultSet rs = stmt.executeQuery();

	    Funcionario funcionario = new Funcionario();

	    // Pessoa
	    funcionario.setNome(rs.getString(ColunasPessoa.NOME));
	    funcionario.setEndereco(rs.getString(ColunasPessoa.ENDERECO));
	    funcionario.setTelefone(rs.getString(ColunasPessoa.TELEFONE));
	    funcionario.setEmail(rs.getString(ColunasPessoa.EMAIL));

	    // Funcionário
	    funcionario.setId(rs.getInt(ColunasFuncionario.ID));
	    funcionario.setGenero(rs.getString(ColunasFuncionario.GENERO).charAt(0));
	    funcionario.setDataAdm(rs.getString(ColunasFuncionario.DATA_ADMISSAO));
	    funcionario.setDataNasc(rs.getString(ColunasFuncionario.DATA_NASCIMENTO));
	    funcionario.setCpf(rs.getString(ColunasFuncionario.CPF));
	    funcionario.setRg(rs.getString(ColunasFuncionario.RG));
	    funcionario.setCargo(rs.getString(ColunasFuncionario.CARGO));
	    funcionario.setEstadoCivil(rs.getString(ColunasFuncionario.ESTADO_CIVIL));
	    funcionario.setSalario(rs.getFloat(ColunasFuncionario.SALARIO));
	    funcionario.setCnh(ECNH.valueOf(rs.getString(ColunasFuncionario.CNH)));

	    return funcionario;

	} finally {
	    if (connection != null) {
		connection.close();
	    }
	}
    }

    @Override
    public void inserir(IEntidade entidade) throws SQLException {
	int newId = getNewId();
	if (newId == 0) {
	    newId = 1;
	}

	Connection connection = new ConnectionFactory().getConnection();
	try {

	    String sql = "insert into funcionario " + "(nome, genero, dataNasc, cpf, rg, estadoCivil, endereco, cargo, dataAdm, salario, cnh, telefone, email, id)"
		    + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	    Funcionario funcionario = (Funcionario) entidade;
	    funcionario.setId(newId);

	    // prepared statement para inserção
	    PreparedStatement stmt = connection.prepareStatement(sql);

	    // seta os valores
	    stmt.setString(1, funcionario.getNome());
	    stmt.setString(2, String.valueOf(funcionario.getGenero()));
	    stmt.setString(3, funcionario.getDataNasc());
	    stmt.setString(4, funcionario.getCpf());
	    stmt.setString(5, funcionario.getRg());
	    stmt.setString(6, funcionario.getEstadoCivil());
	    stmt.setString(7, funcionario.getEndereco());
	    stmt.setString(8, funcionario.getCargo());
	    stmt.setString(9, funcionario.getDataAdm());
	    stmt.setFloat(10, funcionario.getSalario());
	    stmt.setString(11, funcionario.getCnh().toString());
	    stmt.setString(12, funcionario.getTelefone());
	    stmt.setString(13, funcionario.getEmail());
	    stmt.setInt(14, funcionario.getId());

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
    public void alterar(IEntidade entidade) throws SQLException {
	Connection connection = new ConnectionFactory().getConnection();
	try {
	    String sql = "update funcionario set nome=?, genero=?, dataNasc=?, cpf=?, rg=?, estadoCivil=?, endereco=?, cargo=?, dataAdm=?, salario=?, cnh=?, telefone=?, email=?" + " where id=?";
	    // nome=?, genero=?, dataNasc=?, cpf=?, rg=?, estadoCivil=?,
	    // endereco=?, cargo=?, dataAdm=?, salario=?, cnh=?, telefone=?,
	    // email=?, id
	    Funcionario funcionario = (Funcionario) entidade;

	    PreparedStatement stmt = connection.prepareStatement(sql);
	    stmt.setString(1, funcionario.getNome());
	    stmt.setString(2, String.valueOf(funcionario.getGenero()));
	    stmt.setString(3, funcionario.getDataNasc());
	    stmt.setString(4, funcionario.getCpf());
	    stmt.setString(5, funcionario.getRg());
	    stmt.setString(6, funcionario.getEstadoCivil());
	    stmt.setString(7, funcionario.getEndereco());
	    stmt.setString(8, funcionario.getCargo());
	    stmt.setString(9, funcionario.getDataAdm());
	    stmt.setFloat(10, funcionario.getSalario());
	    stmt.setString(11, funcionario.getCnh().toString());
	    stmt.setString(12, funcionario.getTelefone());
	    stmt.setString(13, funcionario.getEmail());
	    stmt.setInt(14, funcionario.getId());

	    stmt.execute();
	    stmt.close();
	} finally {
	    if (connection != null) {
		connection.close();
	    }
	}
    }

    @Override
    public void remover(IEntidade entidade) throws SQLException {

	Connection connection = new ConnectionFactory().getConnection();
	try {
	    Funcionario funcionario = (Funcionario) entidade;

	    PreparedStatement stmt = connection.prepareStatement("delete from funcionario where id=?");
	    stmt.setInt(1, funcionario.getId());
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
	    PreparedStatement stmt = connection.prepareStatement("select max(id) as id from funcionario;");
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
