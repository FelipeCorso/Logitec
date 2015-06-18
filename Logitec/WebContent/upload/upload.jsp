<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form id="formImagem" name="formImagem" method="post" action="upload" enctype="multipart/form-data">
		<input type="hidden" id="tipoForm" name="tipoForm" value="imagem" /> Nome: <input name="nome" id="nome" value="" /> Arqiuvo: <input name="imagem" type="file"
			accept="image/jpeg; image/gif; image/bmp; image/png" id="imagem" class="dados" maxlength="60" tabindex="1" value="c:/" /> <input type="submit" id="upload" name="upload" tabindex="2" />
	</form>
</body>
</html>
