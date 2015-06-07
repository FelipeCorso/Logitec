package br.furb.bcc.logitec.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.furb.bcc.logitec.entidades.controle.dao.ClienteDAO;
import br.furb.bcc.logitec.entidades.controle.dao.FuncionarioDAO;
import br.furb.bcc.logitec.entidades.controle.dao.colunas.ColunasCliente;
import br.furb.bcc.logitec.entidades.controle.dao.colunas.ColunasFuncionario;
import br.furb.bcc.logitec.entidades.controle.dao.colunas.ColunasPessoa;
import br.furb.bcc.logitec.entidades.modelo.pessoa.funcionario.ECNH;
import br.furb.bcc.logitec.entidades.modelo.pessoa.funcionario.Funcionario;

/**
 * Servlet implementation class FuncionarioServlet
 */
@WebServlet(name = "Funcionario", urlPatterns = { "/Funcionario" })
public class FuncionarioServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
	    int id = Integer.valueOf(request.getParameter(ColunasCliente.ID)).intValue();
	    Funcionario funcionario = (Funcionario) ClienteDAO.getInstance().recuperar(id);
	    boolean inserir = false;

	    if (funcionario == null) {
		funcionario = new Funcionario();
		funcionario.setId(id);
		inserir = true;
	    }

	    // Pessoa
	    funcionario.setNome(request.getParameter(ColunasPessoa.NOME));
	    funcionario.setEndereco(request.getParameter(ColunasPessoa.ENDERECO));
	    funcionario.setTelefone(request.getParameter(ColunasPessoa.TELEFONE));
	    funcionario.setEmail(request.getParameter(ColunasPessoa.EMAIL));

	    // Funcionário
	    funcionario.setGenero(request.getParameter(ColunasFuncionario.GENERO).charAt(0));
	    funcionario.setDataAdm(request.getParameter(ColunasFuncionario.DATA_ADMISSAO));
	    funcionario.setDataNasc(request.getParameter(ColunasFuncionario.DATA_NASCIMENTO));
	    funcionario.setCpf(request.getParameter(ColunasFuncionario.CPF));
	    funcionario.setRg(request.getParameter(ColunasFuncionario.RG));
	    funcionario.setCargo(request.getParameter(ColunasFuncionario.CARGO));
	    funcionario.setEstadoCivil(request.getParameter(ColunasFuncionario.ESTADO_CIVIL));
	    funcionario.setSalario(Float.valueOf(request.getParameter(ColunasFuncionario.SALARIO)).floatValue());
	    funcionario.setCnh(ECNH.valueOf(request.getParameter(ColunasFuncionario.CNH)));

	    if (inserir) {
		FuncionarioDAO.getInstance().inserir(funcionario);
	    } else {
		FuncionarioDAO.getInstance().alterar(funcionario);
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}

    }

}
