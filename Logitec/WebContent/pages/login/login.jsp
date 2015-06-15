<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LogiTec</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap Core CSS -->
<link href="../../css/bootstrap.min.css" rel="stylesheet">
<link href="../../css/bootstrap-theme.min.css" rel="stylesheet">

<!-- jQuery  -->
<script src="../../js/jquery-1.11.3.min.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="../../js/bootstrap.min.js"></script>
<!-- Script Autenticacao -->
<script src="../../js/userAuthentication.js"></script>

<%
	String email = (String)session.getAttribute("email");

	if (email == null) {
		email = "";
	}

	if (email != "") {
		response.sendRedirect("pages/login/index.jsp");
	}
%>

</head>
<body>
<div class="container col-md-4 panel">
</div>
	<div class="container col-md-4 panel">

<!-- action = "/Logitec/usrAuth" -->
		<form id="login" action = "" method = "post" class="form-signin">
			<h2 class="form-signin-heading">LogiTec</h2>
			<label for="inputEmail" class="sr-only">Usuário</label>
			<input value="felipe.corso@live.com" type="email" name="inputEmail" id="inputEmail" class="form-control" placeholder="usuário" required autofocus></input>
			<label for="inputPassword" class="sr-only">Senha</label>
			<input value="abc" type="password" name="inputPassword" id="inputPassword" class="form-control" placeholder="senha" required></input>
			<div class="checkbox">
				<label><input type="checkbox" value="remember-me"> Lembre-me</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit" id="submit" onclick="login();">Login</button>
		</form>
		
		<div id="msg"></div>

	</div>
	<!-- /container -->
</body>
</html>