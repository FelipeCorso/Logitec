package br.furb.bcc.logitec.clienteMySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.furb.bcc.logitec.entidades.modelo.pessoa.cliente.Cliente;

public class ClienteDAO {

    Connection con;
    PreparedStatement pstmt;
    ResultSet rs;

    public ClienteDAO() {

    }

    public int incluir(Cliente cliente, String imagemCaminho) throws ClassNotFoundException, SQLException {
	int registroIncluir = 0;
	try {
	    Class.forName("com.mysql.jdbc.Driver");

	    // String ip = "", usuario = "", senha = "", banco = "";
	    // Properties propriedades = new Properties();
	    // InputStream arqPropriedades = new FileInputStream(System.getProperty("user.dir")+"/src/propriedades/propriedadesConexaoBanco.properties");
	    // try {
	    // propriedades.load(arqPropriedades);
	    // } catch (Exception e) {
	    // JOptionPane.showMessageDialog(null, "Erro ao ler propriedades...");
	    // }
	    // ip=propriedades.getProperty("ip");
	    // usuario=propriedades.getProperty("usuario");
	    // senha=propriedades.getProperty("senha");
	    // banco=propriedades.getProperty("banco");
	    // con = DriverManager.getConnection("jdbc:mysql://" + ip + "/" + banco, usuario, senha);

	    con = DriverManager.getConnection("jdbc:mysql://" + "localhost" + "/" + "logitec", "root", "12345");

	    pstmt = con.prepareStatement("INSERT INTO clientes(nm_cliente, ds_imagem) VALUES ( ?, ?)");

	    pstmt.setString(1, cliente.getNome());
	    pstmt.setString(2, imagemCaminho);

	    System.out.println(pstmt);

	    registroIncluir = pstmt.executeUpdate();

	} catch (ClassNotFoundException e) {
	    throw new ClassNotFoundException();

	} catch (SQLException e) {
	    throw new SQLException();
	} finally {

	    if (pstmt != null)
		pstmt.close();

	    if (con != null)
		con.close();
	}

	return registroIncluir;
    }

}
