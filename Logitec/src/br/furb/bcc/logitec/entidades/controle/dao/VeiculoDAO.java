package br.furb.bcc.logitec.entidades.controle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

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

    public IEntidade recuperar(String placa) throws SQLException {
	List<IEntidade> entidades = recuperar(placa, "", "", "");

	if (entidades.isEmpty()) {
	    return null;
	}

	return entidades.get(0);

    }

    public List<IEntidade> recuperar(String placa, String tipo, String descricao, String capacidade) throws SQLException {
	Connection connection = new ConnectionFactory().getConnection();
	try {

	    String sql = "SELECT * FROM VEICULO {0}";

	    String where = createWhere(placa, tipo, descricao, capacidade);
	    if (!where.isEmpty()) {
		where = " WHERE " + where;
	    }

	    List<IEntidade> veiculos = new ArrayList<IEntidade>();

	    PreparedStatement stmt = connection.prepareStatement(MessageFormat.format(sql, where));
	    ResultSet rs = stmt.executeQuery();

	    while (rs.next()) {

		Veiculo veiculo = new Veiculo();
		veiculo.setPlaca(rs.getString(ColunasVeiculo.PLACA));
		veiculo.setTipo(ETipoVeiculo.valueOf(rs.getInt("IDTIPOVEICULO")));
		veiculo.setDescricao(rs.getString(ColunasVeiculo.DESCRICAO));
		veiculo.setCapacidade(rs.getDouble(ColunasVeiculo.CAPACIDADE));

		veiculos.add(veiculo);
	    }
	    rs.close();
	    stmt.close();
	    return veiculos;

	} finally {
	    if (connection != null) {
		connection.close();
	    }
	}
    }

    private String createWhere(String placa, String tipo, String descricao, String capacidade) {

	StringBuilder sb = new StringBuilder();

	if (placa != null && !placa.isEmpty()) {
	    sb.append(" placa='" + placa + "'");
	}
	if (tipo != null && !tipo.isEmpty()) {
	    ETipoVeiculo tipoVeiculo = ETipoVeiculo.valueOf(Integer.valueOf(tipo));
	    sb.append(" IDTIPOVEICULO=");
	    sb.append(tipoVeiculo.getCodigoTipo());
	}
	if (descricao != null && !descricao.isEmpty()) {
	    sb.append(" descricao='" + descricao + "'");
	}
	if (capacidade != null && !capacidade.isEmpty()) {
	    sb.append(" capacidade=");
	    sb.append(capacidade);
	}

	return sb.toString();
    }

    @Override
    public void inserir(IEntidade entidade) throws SQLException {

	Connection connection = new ConnectionFactory().getConnection();
	try {

	    String sql = "insert into veiculo " + "(placa, capacidade, descricao, idTipoVeiculo)" + " values (?, ?, ?, ?)";

	    Veiculo veiculo = (Veiculo) entidade;

	    // prepared statement para inserção
	    PreparedStatement stmt = connection.prepareStatement(sql);

	    // seta os valores
	    stmt.setString(1, veiculo.getPlaca());
	    stmt.setDouble(2, veiculo.getCapacidade());
	    stmt.setString(3, veiculo.getDescricao());
	    stmt.setInt(4, veiculo.getTipo().getCodigoTipo());

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
	    String sql = "update veiculo set capacidade=?, descricao=?, idTipoVeiculo=?" + " where placa=?";

	    Veiculo veiculo = (Veiculo) entidade;

	    PreparedStatement stmt = connection.prepareStatement(sql);
	    stmt.setDouble(1, veiculo.getCapacidade());
	    stmt.setString(2, veiculo.getDescricao());
	    stmt.setInt(3, veiculo.getTipo().getCodigoTipo());
	    stmt.setString(4, veiculo.getPlaca());

	    stmt.execute();
	    stmt.close();
	} finally {
	    if (connection != null) {
		connection.close();
	    }
	}
    }

    @Override
    public void remover(int idEntidade) throws SQLException {

	Connection connection = new ConnectionFactory().getConnection();
	try {
	    PreparedStatement stmt = connection.prepareStatement("delete from veiculo where id=?");
	    stmt.setInt(1, idEntidade);
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

    @Override
    public IEntidade recuperar(int id) throws SQLException {
	throw new IllegalAccessError("Método não implementado");
    }

}
