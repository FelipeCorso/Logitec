package com.mkyong.rest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

@Path("/users")
public class UserRestService {
    // @Context
    // private HttpServletResponse response;
    // @Context
    // private HttpServletRequest request;

    @POST
    // @Path("{id}")
    // @Produces(MediaType.APPLICATION_JSON)
    // public Response getUserByIdPost(@PathParam("id") String id) {
    public String getUserByIdPost(@Context HttpServletResponse response, @Context HttpServletRequest request
    // , @PathParam("username") String username, @PathParam("password") String password
    ) throws ServletException {

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

	String username = "Felipe Corso";
	// Consultar um banco de dados, ou um array, por exemplo

	// try {
	if ((email.equals("felipe.corso@live.com")) && senha.equals("abc")) {
	    HttpSession session = request.getSession();
	    session.setAttribute("email", email);
	    session.setAttribute("username", username);
	    // Se houver outra informa��o importante que mere�a ser guardada
	    // session.setAttribute("sIdade",idade);

	    // response.getOutputStream().println("{\"errno\": \"0\", \"msg\": \"Ok\"}");
	    // response.getOutputStream().flush();
	    // response.getOutputStream().close();

	    // response.sendRedirect("/Logitec/index.jsp");

	    // RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
	    // if (dispatcher != null) {
	    // dispatcher.forward(request, response);
	    // dispatcher.include(request, response);
	    // return;
	    // }

	    return "{\"errno\": \"0\", \"msg\": \"Ok\"}";

	} else {
	    return "{\"errno\": \"1\", \"msg\": \"Usu&aacute;rio inv&aacute;lido\"}";
	    // response.getOutputStream().println("{\"errno\": \"1\", \"msg\": \"Usu&aacute;rio inv&aacute;lido\"}");
	    // response.getOutputStream().flush();
	    // response.getOutputStream().close();
	}
	// } catch (IOException e) {
	// e.printStackTrace();
	// }

	// return Response.ok("{sUsername: 'teste'}", MediaType.APPLICATION_JSON).build();
	// return Response.status(200).entity("getUserById is called, id : " + id).build();
	// return Response.status(200).build();
	// return "{\"teste\":\"Felipe\"}";
    }

}