<%
	String email = (String)session.getAttribute("email");

	if (email == null) {
		response.sendRedirect("/Logitec/pages/login/login.jsp");
	}
%>