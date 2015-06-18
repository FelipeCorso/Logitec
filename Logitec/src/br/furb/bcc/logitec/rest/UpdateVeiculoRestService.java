package br.furb.bcc.logitec.rest;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import br.furb.bcc.logitec.entidades.controle.dao.VeiculoDAO;
import br.furb.bcc.logitec.entidades.controle.dao.colunas.ColunasVeiculo;
import br.furb.bcc.logitec.entidades.modelo.veiculo.ETipoVeiculo;
import br.furb.bcc.logitec.entidades.modelo.veiculo.Veiculo;

@Path("/updateVeiculo")
public class UpdateVeiculoRestService {

    @POST
    public String updateVeiculo(@Context HttpServletResponse response, @Context HttpServletRequest request) throws ServletException {

	String placa = request.getParameter(ColunasVeiculo.PLACA);
	int tipo = Integer.valueOf(request.getParameter(ColunasVeiculo.TIPO));
	String descricao = request.getParameter(ColunasVeiculo.DESCRICAO);
	String capacidade = request.getParameter(ColunasVeiculo.CAPACIDADE);

	response.setContentType("application/json");
	response.setHeader("Access-Control-Allow-Origin", "*");
	response.setHeader("Access-Control-Allow-Headers", "X-Requested-With");

	try {
	    Veiculo veiculo = (Veiculo) VeiculoDAO.getInstance().recuperar(placa);
	    if (veiculo != null) {
		veiculo.setPlaca(placa);
		veiculo.setTipo(ETipoVeiculo.valueOf(tipo));
		veiculo.setDescricao(descricao);
		veiculo.setCapacidade(Double.parseDouble(capacidade));

		VeiculoDAO.getInstance().alterar(veiculo);

		return "{\"errno\": \"0\", \"msg\": \"Ve&iacute;culo alterado com sucesso\"}";
	    }

	    veiculo = new Veiculo();
	    veiculo.setPlaca(placa);
	    veiculo.setTipo(ETipoVeiculo.valueOf(tipo));
	    veiculo.setDescricao(descricao);
	    veiculo.setCapacidade(Double.parseDouble(capacidade));

	    VeiculoDAO.getInstance().inserir(veiculo);

	    return "{\"errno\": \"0\", \"msg\": \"Ve&iacute;culo inserido com sucesso\"}";
	} catch (SQLException e) {
	    e.printStackTrace();
	    return "{\"errno\": \"1\", \"msg\": \"N&aring;o foi poss&iacute;vel salvar o ve&iacute;culo\"}";
	}
    }

}