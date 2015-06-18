<%@page import="br.furb.bcc.logitec.entidades.modelo.veiculo.ETipoVeiculo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../login/valida.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Inserir/Editar Veículos</title>

		<!-- Bootstrap Core CSS -->
		<link href="/Logitec/css/bootstrap.min.css" rel="stylesheet">
		<link href="/Logitec/css/bootstrap-theme.min.css" rel="stylesheet">
		
		<!-- jQuery  -->
		<script src="/Logitec/js/jquery-1.11.3.min.js"></script>
		<!-- Bootstrap Core JavaScript -->
		<script src="/Logitec/js/bootstrap.min.js"></script>
		
		<script type="text/javascript">
			function limparCampos() {
				document.getElementById("placa").value = "";
				document.getElementById("tipo").selectedIndex = 0;
				document.getElementById("descricao").value = "";
				document.getElementById("capacidade").value = "";
			}
			
			function postForm(e) {
				
				e.preventDefault();
				//o serialize retorna uma string pronta para ser enviada
				var valores = $("#veiculo").serialize();
				console.log(valores);
				
				$("#msg").html("Salvando veículo, aguarde ...");
				
	//			var url2 = "http://localhost/Logitec/users/";
				var url2 = "/Logitec/updateVeiculo/";
				$.ajax({type: "post", url: url2, 
					//async: false, cache: false, crossDomain: false,
					dataType: "json",
					data: valores,
					success: function(result){
						if (result.errno == 0) {
							$("#msg").html(result.msg);
						} else {
							$("#msg").html(result.msg);
							console.error(result);
						}
					},
					error: function(result, txt){
						console.error(result);
					}
				});
			}
			
		</script>
		
	</head>
	<body>
		<form class="form-horizontal" role="form" id="veiculo">

			<div class="row">
				<hr>
			</div>
			<jsp:include page="camposVeiculo.jsp"></jsp:include>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					
					<button type="button" class="btn btn-primary" onclick="postForm(event);">Salvar</button>
					<button type="submit" class="btn btn-default" onclick="limparCampos();">Limpar</button>
					<div id="msg"></div>
				</div>
			</div>
		</form>
	</body>
</html>