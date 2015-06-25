package br.furb.bcc.logitec.auth;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

@Path("/users")
public class UserAuthentication {

    @POST
    public String getUserByIdPost(@Context HttpServletResponse response, @Context HttpServletRequest request) throws ServletException {

	/*
	 * FIXME: Ajustar SQL e relacionamentos das tabelas
	 * 
	 * Usuario usuario = (Usuario) UsuarioDAO.getInstance().recuperar(email, password);
	 * 
	 * if (usuario != null) { HttpSession session = request.getSession(); session.setAttribute(INPUT_EMAIL, usuario.getEmail());
	 * 
	 * session.setAttribute(INPUT_PASSWORD, usuario.getPassword());
	 */

	response.setContentType("application/json");
	response.setHeader("Access-Control-Allow-Origin", "*");
	response.setHeader("Access-Control-Allow-Headers", "X-Requested-With");

	String email = request.getParameter("inputEmail");
	String senha = request.getParameter("inputPassword");
	if (email == null) {
	    email = "";
	}
	if (senha == null) {
	    senha = "";
	}

	if ((email.equals("felipe.corso@live.com")) && senha.equals("abc")) {
	    HttpSession session = request.getSession();
	    session.setAttribute("email", email);
	    String username = "Felipe Corso";
	    session.setAttribute("username", username);

	    return "{\"errno\": \"0\", \"msg\": \"Ok\"}";

	} else {
	    return "{\"errno\": \"1\", \"msg\": \"Usu&aacute;rio inv&aacute;lido\"}";
	}
    }

}
