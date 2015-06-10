package br.furb.bcc.logitec.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.furb.bcc.logitec.entidades.controle.dao.ClienteDAO;
import br.furb.bcc.logitec.entidades.controle.dao.colunas.ColunasCliente;
import br.furb.bcc.logitec.entidades.controle.dao.colunas.ColunasPessoa;
import br.furb.bcc.logitec.entidades.modelo.pessoa.ETipoPessoa;
import br.furb.bcc.logitec.entidades.modelo.pessoa.cliente.Cliente;

/**
 * Servlet implementation class ClienteServlet
 */
@WebServlet("/Cliente")
public class ClienteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	try {
	    int id = Integer.valueOf(request.getParameter(ColunasCliente.ID)).intValue();
	    Cliente cliente = (Cliente) ClienteDAO.getInstance().recuperar(id);

	    cliente.setId(id);

	    // Pessoa
	    cliente.setNome(request.getParameter(ColunasPessoa.NOME));
	    cliente.setEndereco(request.getParameter(ColunasPessoa.ENDERECO));
	    cliente.setTelefone(request.getParameter(ColunasPessoa.TELEFONE));
	    cliente.setEmail(request.getParameter(ColunasPessoa.EMAIL));

	    // Cliente
	    cliente.setTipPessoa(ETipoPessoa.valueOf(request.getParameter(ColunasCliente.TIPO_PESSOA)));
	    cliente.setDatCad(request.getParameter(ColunasCliente.DATA_CADASTRO));
	    cliente.setCpf(request.getParameter(ColunasCliente.CPF));
	    cliente.setCnpj(request.getParameter(ColunasCliente.CNPJ));
	    cliente.setRg(request.getParameter(ColunasCliente.RG));
	    cliente.setInscEst(request.getParameter(ColunasCliente.INSCRICAO_ESTADUAL));

	    ClienteDAO.getInstance().inserir(cliente);

	} catch (SQLException e) {
	    e.printStackTrace();
	}

    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	try {
	    int id = Integer.valueOf(request.getParameter(ColunasCliente.ID)).intValue();
	    Cliente cliente = (Cliente) ClienteDAO.getInstance().recuperar(id);

	    cliente.setId(id);

	    /*
	     * TODO: tratar a parte de atualizar o cliente aqui
	     */

	    ClienteDAO.getInstance().alterar(cliente);
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	int id = Integer.valueOf(request.getParameter(ColunasCliente.ID)).intValue();

	/*
	 * TODO: tratar a parte de remover o cliente aqui
	 */

	try {
	    ClienteDAO.getInstance().remover(id);
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }
}
