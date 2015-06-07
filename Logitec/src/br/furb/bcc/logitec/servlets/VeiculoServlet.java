package br.furb.bcc.logitec.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.furb.bcc.logitec.entidades.controle.dao.VeiculoDAO;
import br.furb.bcc.logitec.entidades.controle.dao.colunas.ColunasVeiculo;
import br.furb.bcc.logitec.entidades.modelo.veiculo.ETipoVeiculo;
import br.furb.bcc.logitec.entidades.modelo.veiculo.Veiculo;

/**
 * Servlet implementation class Veiculo
 */
@WebServlet(name = "Veiculo", urlPatterns = { "/Veiculo" })
public class VeiculoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
	    int intValue = Integer.valueOf(request.getParameter(ColunasVeiculo.ID)).intValue();
	    Veiculo veiculo = (Veiculo) VeiculoDAO.getInstance().recuperar(intValue);

	    boolean inserir = false;

	    if (veiculo == null) {
		veiculo = new Veiculo();
		veiculo.setId(intValue);
		inserir = true;
	    }

	    veiculo.setTipo(ETipoVeiculo.valueOf(request.getParameter(ColunasVeiculo.TIPO)));
	    veiculo.setPlaca(request.getParameter(ColunasVeiculo.PLACA));
	    veiculo.setCapacidade(Double.valueOf(request.getParameter(ColunasVeiculo.CAPACIDADE)).doubleValue());

	    if (inserir) {
		VeiculoDAO.getInstance().inserir(veiculo);
	    } else {
		VeiculoDAO.getInstance().alterar(veiculo);
	    }

	} catch (SQLException e) {
	    e.printStackTrace();
	}

    }

}
