package br.furb.bcc.logitec.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.furb.bcc.logitec.entidades.Usuario;
import br.furb.bcc.logitec.entidades.controle.dao.UsuarioDAO;

/**
 * Servlet implementation class UserAuthServlet
 */
@WebServlet("/usrAuth")
public class UserAuthServlet extends HttpServlet {
    private static final String INPUT_EMAIL = "inputEmail";
    private static final String INPUT_PASSWORD = "inputPassword";
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	System.out.println("Triste");
	super.doGet(req, resp);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String email = request.getParameter(INPUT_EMAIL);
	String password = request.getParameter(INPUT_PASSWORD);

	try {
	    Usuario usuario = (Usuario) UsuarioDAO.getInstance().recuperar(email, password);

	    if (usuario != null) {
		HttpSession session = request.getSession();
		session.setAttribute(INPUT_EMAIL, usuario.getEmail());
		session.setAttribute(INPUT_PASSWORD, usuario.getPassword());

		RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
		if (dispatcher != null) {
		    dispatcher.forward(request, response);
		}
	    } else {
		RequestDispatcher dispatcher = request.getRequestDispatcher("pages/login/login.html");
		if (dispatcher != null) {
		    dispatcher.forward(request, response);
		}
	    }

	} catch (SQLException e) {
	    e.printStackTrace();
	}

    }

}
