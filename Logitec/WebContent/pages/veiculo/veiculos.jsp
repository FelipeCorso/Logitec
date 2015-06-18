<%@include file="../login/valida.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<!-- Bootstrap Core CSS -->
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/bootstrap-theme.min.css" rel="stylesheet">
		
		<!-- jQuery  -->
		<script src="js/jquery-1.11.3.min.js"></script>
		<!-- Bootstrap Core JavaScript -->
		<script src="js/bootstrap.min.js"></script>
		<style type="text/css">
			.panel-heading a:after {
			    font-family:'Glyphicons Halflings';
			    content:"\e114";
			    float: right;
			    color: grey;
			}
			.panel-heading a.collapsed:after {
			    content:"\e080";
			}
			.collapse {
				display: none;
			}
		</style>
	</head>
	<body>
	
		<div class="row">
			<div class="col-md-2 panel text-center">
				<div class="panel-heading">
					<a href="pages/veiculo/buscaVeiculo.jsp">
						<img src="icon/frete_64.png" alt="Cinque Terre" width="64" height="64">
						<h5>Buscar Veículos</h5>
					</a>
				</div>
			</div>
			<div class="col-md-2 panel text-center">
				<div class="panel-heading">
					<a href="pages/veiculo/veiculo.jsp">
						<img src="icon/frete_64.png" alt="Cinque Terre" width="64" height="64">
						<h5>Inserir/Editar Veículos</h5>
					</a>
				</div>
			</div>
		</div>
	</body>
</html>