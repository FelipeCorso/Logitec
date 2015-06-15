package br.furb.bcc.logitec.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.furb.bcc.logitec.entidades.controle.dao.VeiculoDAO;
import br.furb.bcc.logitec.entidades.controle.dao.colunas.ColunasVeiculo;
import br.furb.bcc.logitec.entidades.modelo.IEntidade;

/**
 * Servlet implementation class Veiculo
 */
@WebServlet(name = "veiculo", urlPatterns = { "/veiculo" })
public class VeiculoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String placa = request.getParameter(ColunasVeiculo.PLACA);
	String tipo = request.getParameter(ColunasVeiculo.TIPO);
	String descricao = request.getParameter(ColunasVeiculo.DESCRICAO);
	String capacidade = request.getParameter(ColunasVeiculo.CAPACIDADE);

	try {
	    List<IEntidade> listaVeiculos = VeiculoDAO.getInstance().recuperar(placa, tipo, descricao, capacidade);
	    request.setAttribute("listaVeiculos", listaVeiculos);

	    RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/veiculo/buscaVeiculo.jsp");
	    if (dispatcher != null) {
		dispatcher.forward(request, response);
		return;
	    }

	} catch (SQLException e) {
	    e.printStackTrace();
	}

    }

}
