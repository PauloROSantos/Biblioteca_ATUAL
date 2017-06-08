<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logado</title>
</head>
<body>
	
	<%
		String login = request.getParameter("txtUsuario");
		String senha = request.getParameter("txtSenha");
		
		if(login.contains("teste") && senha.contains("senha")){
			session.setAttribute("user", login);
			session.setAttribute("logado", true);
			response.sendRedirect("index.jsp");
		}else{
			%><script>alert("Login ou senha incorreta!")
			  window.location.href="login.jsp";</script> <%
		}
	
	
	
	%>

</body>
</html>