package br.furb.bcc.logitec.auth;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import br.furb.bcc.logitec.entidades.Usuario;

@Path("/usrAuth")
public class _UserAuthentication {

    @POST
    public void authentication(Usuario user) {

    }

}
