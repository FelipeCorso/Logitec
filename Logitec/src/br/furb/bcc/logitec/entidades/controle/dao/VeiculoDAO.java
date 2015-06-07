package br.furb.bcc.logitec.entidades.controle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;

import br.furb.bcc.logitec.entidades.controle.conexao.ConnectionFactory;
import br.furb.bcc.logitec.entidades.controle.dao.colunas.ColunasVeiculo;
import br.furb.bcc.logitec.entidades.modelo.IEntidade;
import br.furb.bcc.logitec.entidades.modelo.veiculo.ETipoVeiculo;
import br.furb.bcc.logitec.entidades.modelo.veiculo.Veiculo;

public class VeiculoDAO implements IDataAccessObject {

    private static final VeiculoDAO INSTANCE = new VeiculoDAO();

    private VeiculoDAO() {

    }

    public static VeiculoDAO getInstance() {
	return INSTANCE;
    }

    @Override
    public IEntidade recuperar(int id) throws SQLException {

	Connection connection = new ConnectionFactory().getConnection();
	try {

	    String sql = "SELECT * FROM VEICULO WHERE id={0}";
	    PreparedStatement stmt = connection.prepareStatement(MessageFormat.format(sql, id));
	    ResultSet rs = stmt.executeQuery();

	    Veiculo veiculo = new Veiculo();
	    veiculo.setId(rs.getInt(ColunasVeiculo.ID));
	    veiculo.setTipo(ETipoVeiculo.valueOf(rs.getString(ColunasVeiculo.TIPO)));
	    veiculo.setPlaca(rs.getString(ColunasVeiculo.PLACA));
	    veiculo.setCapacidade(rs.getDouble(ColunasVeiculo.CAPACIDADE));

	    return veiculo;

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

	    String sql = "insert into veiculo " + "(id, tipo, placa, capacidade)" + " values (?, ?, ?, ?)";

	    Veiculo veiculo = (Veiculo) entidade;
	    veiculo.setId(newId);

	    // prepared statement para inserção
	    PreparedStatement stmt = connection.prepareStatement(sql);

	    // seta os valores
	    stmt.setInt(1, veiculo.getId());
	    stmt.setString(2, veiculo.getTipo().toString());
	    stmt.setString(3, veiculo.getPlaca());
	    stmt.setDouble(4, veiculo.getCapacidade());

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
	    String sql = "update veiculo set tipo=?, placa=?, capacidade=?" + " where id=?";

	    Veiculo veiculo = (Veiculo) entidade;

	    PreparedStatement stmt = connection.prepareStatement(sql);
	    stmt.setString(1, veiculo.getTipo().toString());
	    stmt.setString(2, veiculo.getPlaca());
	    stmt.setDouble(3, veiculo.getCapacidade());
	    stmt.setInt(4, veiculo.getId());

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
	    Veiculo veiculo = (Veiculo) entidade;

	    PreparedStatement stmt = connection.prepareStatement("delete from veiculo where id=?");
	    stmt.setInt(1, veiculo.getId());
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
	    PreparedStatement stmt = connection.prepareStatement("select max(id) as id from veiculo;");
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
