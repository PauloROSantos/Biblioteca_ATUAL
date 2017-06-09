<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="sistema.*,java.util.List" %>
<%@ page import="br.com.biblioteca.dao.JDBCLivroDAO" %>
<%@ page import="br.com.biblioteca.banco.ConnectionFactory" %>
<%@ page import="br.com.biblioteca.banco.DAOFactory" %>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%	JDBCLivroDAO ld = new JDBCLivroDAO();
		List<Livro> livros = ld.listar(); 
		
		for(Livro livro: livros){
			out.print(livro.getNome()+"<br/>");
			out.print(livro.getTema()+"<br/>");
			out.print(livro.getStatus()+"<br/>");
			
		}
		
		
		%>

</body>
</html>