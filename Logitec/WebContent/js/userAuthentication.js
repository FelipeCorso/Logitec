/**
 * 
 */

function login() {
	$("#submit").click(function(e) {
		
		//$('input[type=submit]').click(function(e){
		//setamos para quando submeter não atualizar a pagina   
		e.preventDefault();
		//o serialize retorna uma string pronta para ser enviada
		var valores = $("#login").serialize();
		
		$("#msg").html("Validando o usuário, aguarde ...");
		
//		var url2 = "http://localhost/Logitec/users/";
		var url2 = "/Logitec/users/";
		$.ajax({type: "post", url: url2, 
			//async: false, cache: false, crossDomain: false,
			dataType: "json",
			data: valores,
			success: function(result){
				if (result.errno == 0) {
//					 similar behavior as an HTTP redirect
					window.location.replace("/Logitec/index.jsp");
//					window.location.assign("http://localhost/Logitec/index.jsp");
//					 similar behavior as clicking on a link
//					window.location.href = "http://localhost/Logitec/index.jsp";
				} else {
					$("#msg").html(result.msg);
					console.error(result);
				}
			},
			error: function(result, txt){
				$("#msg").html(txt);
				console.error(result);
			}
		});
	});
}

$(document).ready(login);