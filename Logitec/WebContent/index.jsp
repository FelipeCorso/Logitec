<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="pages/login/valida.jsp" %>

<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LogiTec - Página Principal</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-theme.min.css" rel="stylesheet">

<!-- 
<link rel="stylesheet" type="text/css" href="css/estilo.css" />
 -->

<!-- jQuery  -->
<script src="js/jquery-1.11.3.min.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>

<script type="text/javascript" src="js/javascript.js"></script>

<%
	String username = (String)session.getAttribute("username");
%>

</head>
<body>

	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="index.jsp">LogiTec</a>
			</div>
			<div>
				<ul class="nav navbar-nav">
					<li><a href="#noticia1">Home</a></li>
					<li><a href="#noticia2">Clientes</a></li>
					<li><a href="#noticia3">Funcionários</a></li>
					<li><a href="#noticia4">Veículos</a></li>
					<li><a href="#noticia5">Fretes</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li>
						<a>
							<span class="glyphicon glyphicon-user"></span>
							<label><%out.print(username);%></label>
						</a>
					</li>
					<li>
						<a href="/Logitec/pages/logoff/logoff.jsp">
							<span class="glyphicon glyphicon-log-in"></span>
							<label>Sair</label>
						</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container-fluid">
		<!--
		<div class="row">
			<div class="col-md-2 panel text-center">
				<div class="panel-heading">
					<img src="icon/frete_64.png" alt="Cinque Terre" width="64" height="64">

					<h5>Fretes em Aberto</h5>
				</div>

			</div>
			<div class="col-md-2 panel text-center">
				<div id ="teste"class="panel-heading">
					<img src="icon/frete_64.png" alt="Cinque Terre" width="64" height="64">

					<h5>Fretes Finalizados</h5>
				</div>

			</div>
		</div>
		-->
		
		<div id="noticia"></div>

		<div id="conteudo">
		
		    <div id="noticia1">
			    <h2>Bem Vindo ao Logitec</h2>
			    <div>
			    	Resumo do sistema...
			    </div>
		    </div>

		    <div id="noticia2">
			    <jsp:include page="pages/cliente/cliente.html"/>
		    </div>
		    
		    <div id="noticia3">
			    <jsp:include page="pages/funcionario/funcionario.html"/>
	    	</div>

		    <div id="noticia4">
			    <jsp:include page="pages/veiculo/veiculos.jsp"/>
		    </div>

		    <div id="noticia5">
			    <jsp:include page="pages/frete/frete.html"/>
		    </div>
		</div>
		
		<div class="row">
			<hr>
		</div>
	</div>
	
</body>
</html>