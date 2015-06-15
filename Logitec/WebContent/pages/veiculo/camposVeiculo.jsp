<%@page import="br.furb.bcc.logitec.entidades.modelo.veiculo.ETipoVeiculo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
	<body>
		<div class="form-group">
			<label class="control-label col-sm-2" for="placa">Placa:</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="placa" name="placa">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="tipo">Tipo:</label>
			<div class="col-sm-6">
				<select class="form-control" id="tipo" name="tipo">
					<option></option>
					<%
					     /*<!-- ContatoDao dao = new ContatoDao(); -->*/
					    for (ETipoVeiculo tipoVeiculo : ETipoVeiculo.values() ) {
				     %>
					<option><%=tipoVeiculo.toString()%></option>
				     <%
						}
				     %>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="descricao">Descrição:</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="descricao" name="descricao">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="capacidade">Capacidade:</label>
			<div class="col-sm-6">
				<input type="number" class="form-control" id="capacidade" name="capacidade">
			</div>
		</div>
	</body>
</html>