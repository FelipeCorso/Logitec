package br.furb.bcc.logitec.entidades;

import br.furb.bcc.logitec.entidades.modelo.IEntidade;

public class Usuario implements IEntidade {

    private String username;
    private String email;
    private String password;
    private int id;

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    @Override
    public void setId(int id) {
	this.id = id;
    }

    @Override
    public int getId() {
	return id;
    }
}
