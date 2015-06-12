package br.furb.bcc.logitec.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//@WebServlet("/usrAuth")

@Path("/usrAuth")
public class UserAuthentication extends HttpServlet {

    private static final long serialVersionUID = -5027049441943115201L;

    @POST
    public void authentication() {
	System.out.println("PASSOU!!! \0/");
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String authenticationGet() {
	String passou = "PASSOU!!! \0/";
	System.out.println(passou);
	return passou;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	super.doPost(req, resp);
    }

}
