<%@page import="br.furb.bcc.logitec.entidades.controle.dao.colunas.ColunasVeiculo"%>
<%@page import="br.furb.bcc.logitec.entidades.controle.dao.VeiculoDAO"%>
<%@page import="br.furb.bcc.logitec.entidades.modelo.IEntidade"%>
<%@page import="javax.swing.text.Document"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.furb.bcc.logitec.entidades.modelo.veiculo.ETipoVeiculo"%>
<%@page import="br.furb.bcc.logitec.entidades.modelo.veiculo.Veiculo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Buscar Veículos</title>

		<!-- Bootstrap Core CSS -->
		<link href="/Logitec/css/bootstrap.min.css" rel="stylesheet">
		<link href="/Logitec/css/bootstrap-theme.min.css" rel="stylesheet">
		
		<!-- jQuery  -->
		<script src="/Logitec/js/jquery-1.11.3.min.js"></script>
		<!-- Bootstrap Core JavaScript -->
		<script src="/Logitec/js/bootstrap.min.js"></script>

		<script type="text/javascript">
		
			function selecionaVeiculo(event) {
				if (event.srcElement.checked) {
					console.log(event.srcElement.value);
				}
			}
		</script>
	</head>
	<body>
		<form action="/Logitec/veiculo" method="post" class="form-horizontal">

			<div class="row">
				<hr>
			</div>
			<jsp:include page="camposVeiculo.jsp"></jsp:include>
			<div class="form-group">
				<div class="col-sm-6">
					<button type="submit" class="btn btn-primary">Buscar</button>
				</div>
			</div>

		</form>
		
		<table class="table table-striped table-condensed">
			<thead>
				<tr>
					<th data-field="state" data-radio="true"></th>       
					<th>Placa</th>
					<th>Tipo</th>
					<th>Descrição</th>
					<th>Capacidade</th>
				</tr>
			</thead>
			<tbody>
			     <%
				     List<Veiculo> veiculos = (List<Veiculo>) request.getAttribute("listaVeiculos");
				     
			     	if(veiculos == null) {
			     		veiculos = new ArrayList<Veiculo>();
			     	}
			     
				     for (Veiculo veiculo : veiculos) {
			     %>
				<tr>
					<td>
						<input type="radio" onclick="selecionaVeiculo(event)" value="<%=veiculo%>" name="veiculoSelecionado"></input>
					</td> 
					<td><%=veiculo.getPlaca() %></td> 
					<td><%=veiculo.getTipo().toString()%></td>
					<td><%=veiculo.getDescricao() %></td> 
					<td><%=veiculo.getCapacidade()%></td>
				</tr>
			     <%
			    	}
			     %>
			</tbody>
		</table>		
		
	</body>
</html>