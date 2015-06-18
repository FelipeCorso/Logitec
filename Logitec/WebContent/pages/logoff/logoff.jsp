<%
	try {
		session.removeAttribute("email");
		session.removeAttribute("username");
		response.sendRedirect("../login/login.jsp");	
	} catch(Exception e) {}
		
%>

