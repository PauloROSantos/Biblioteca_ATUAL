<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="sistema.*,java.util.List" %>
<%@ page import="br.com.biblioteca.dao.*" %>
<%@ page import="br.com.biblioteca.banco.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		Locacao locacao = new Locacao();
		
		
		locacao.setId_livro(Integer.parseInt(request.getParameter("txtLivro")));
		locacao.setRa_usuario(Integer.parseInt(request.getParameter("txtRA")));
		
				
		JDBCLocacaoDAO loc = new JDBCLocacaoDAO();
		
		
		
		if(loc.inserir(locacao)){
			%><script>alert("Livro emprestado com sucesso!")
			  window.location.href="livros.jsp";</script> <%
		}else{
			%><script>alert("Falha no emprestimo!")
			  window.location.href="livros.jsp";</script> <%
		}
	
	
	
	%>

</body>
</html>