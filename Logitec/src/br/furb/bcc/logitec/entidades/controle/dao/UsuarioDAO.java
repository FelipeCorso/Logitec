package br.furb.bcc.logitec.entidades.controle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;

import br.furb.bcc.logitec.entidades.Usuario;
import br.furb.bcc.logitec.entidades.controle.conexao.ConnectionFactory;
import br.furb.bcc.logitec.entidades.modelo.IEntidade;

public class UsuarioDAO {
    private static final UsuarioDAO INSTANCE = new UsuarioDAO();

    private UsuarioDAO() {

    }

    public static UsuarioDAO getInstance() {
	return INSTANCE;
    }

    public IEntidade recuperar(String email, String password) throws SQLException {
	Connection connection = new ConnectionFactory().getConnection();
	try {

	    String sql = "SELECT * FROM usuario WHERE email={0} AND password={1}";
	    PreparedStatement stmt = connection.prepareStatement(MessageFormat.format(sql, email, password));
	    ResultSet rs = stmt.executeQuery();

	    Usuario user = new Usuario();
	    user.setEmail(rs.getString("email"));
	    user.setPassword(rs.getString("password"));

	    return user;

	} finally {
	    if (connection != null) {
		connection.close();
	    }
	}

    }

}
