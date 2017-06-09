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
		Livro livro = new Livro();
	
		livro.setNome(request.getParameter("txtNome"));
		livro.setTema(request.getParameter("txtTema"));
		livro.setAutor(request.getParameter("txtAutor"));
		livro.setQtde_estoque(Integer.parseInt(request.getParameter("txtQtde")));
		
		
		
		JDBCLivroDAO ud = new JDBCLivroDAO();
		
		
		
		if(ud.inserir(livro)){
			%><script>alert("Cadastro Efetuado com sucesso")
			  window.location.href="cadastrar_livro.jsp";</script> <%
		}else{
			%><script>alert("Falha no cadastro!")
			  window.location.href="cadastrar_livro.jsp";</script> <%
		}
	
	
	
	%>

</body>
</html>