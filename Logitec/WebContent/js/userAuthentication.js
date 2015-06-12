/**
 * 
 */

function p(){
	$("#submit").click(function(e){
		
		//$('input[type=submit]').click(function(e){
		//setamos para quando submeter não atualizar a pagina   
		e.preventDefault();
		//o serialize retorna uma string pronta para ser enviada
		var valores = $("#login").serialize();
		
		$("#msg").html("Validando o usuário, aguarde ...");
		
		var url2 = "http://localhost:9090/Logitec/usrAuth";
		$.ajax({type: "post", url: url2, 
			//async: false, cache: false, crossDomain: false,
			dataType: "json",
			data: valores, 
			success: function(result){
				//alert(result.msg);
				console.log(result);
				if (result.errno==0) {
					// similar behavior as an HTTP redirect
					window.location.replace("http://localhost:9090/Logitec/index.html");
					// similar behavior as clicking on a link
					//window.location.href = "http://localhost:8080/examples/jsp/pagpri.jsp";
				} else {
					$("#msg").html(result.msg);
					console.log(result);
				}
			},
			error: function(result,txt){
				$("#msg").html(txt);
				console.log(result);
			}
		});
	});
}

$(document).ready(p);