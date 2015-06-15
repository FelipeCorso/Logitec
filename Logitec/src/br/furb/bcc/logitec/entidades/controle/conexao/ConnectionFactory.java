package br.furb.bcc.logitec.entidades.controle.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    static {

	try {
	    // Class.forName("com.mysql.jdbc.Driver");
	    String driverName = "oracle.jdbc.driver.OracleDriver";
	    Class.forName(driverName);
	} catch (Exception e) {
	    System.out.println("ERRO");
	    e.printStackTrace();
	}
    }

    public Connection getConnection() {
	try {

	    // return DriverManager.getConnection("jdbc:mysql://localhost:3306/fj21", "root", "root");
	    return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "logitec", "logitec");
	} catch (SQLException e) {
	    throw new RuntimeException(e);
	}
    }

}