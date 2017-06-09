<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="sistema.*,java.util.List" %>
<%@ page import="br.com.biblioteca.dao.*" %>
<%@ page import="br.com.biblioteca.banco.*" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logado</title>
</head>
<body>
	
	<%
		int login = Integer.parseInt(request.getParameter("txtUsuario"));
		String senha = request.getParameter("txtSenha");
		
		
		JDBCUsuarioDAO ud = new JDBCUsuarioDAO();
		Usuario usuario = new Usuario();
		
		
		usuario = ud.buscar(login);
		
		
		
		
		if(usuario.getSenha().equals(senha)){
			session.setAttribute("user", usuario.getNome());
			session.setAttribute("ra", usuario.getRa());
			session.setAttribute("logado", true);
			response.sendRedirect("index.jsp");
		}else{
			%><script>alert("Login ou senha incorreta!")
			  window.location.href="login.jsp";</script> <%
		}
	
	
	
	%>

</body>
</html>