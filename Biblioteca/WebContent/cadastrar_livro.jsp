<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="sistema.*,java.util.List" %>
<%@ page import="br.com.biblioteca.dao.*" %>
<%@ page import="br.com.biblioteca.banco.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="estilo.css">



<title>Biblioteca</title>

</head>

<body>

	<header> <!-- ESPAÇO PARA O BANNER -->

	<h1>Book Books</h1>
	<p class="sub">Livros nota 10!</p>
	<p class="hora">
		<%
			
		%>
	</p>
	
	<form class="menu" action="index.jsp" method="POST">
		 <input type="submit" value="inicio" />
	</form>
	<form class="menu" action="livros.jsp" method="POST">
		 <input type="submit" value="livros" />
	</form>
	<form class="menu" action="pesquisar.jsp" method="POST">
		 <input type="submit" value="pesquisar" />
	</form>
	<%
			//boolean teste = (boolean)session.getAttribute("logado");
			
			if(session.getAttribute("logado") != null){
				out.print("<form class='menu' action='reservas.jsp' method='POST'>"+
			"<input type='submit' value='reservas' />"+
				"</form>"+"<form class='menu' action='locacoes.jsp' method='POST'>"+
			"<input type='submit' value='locações' />"+"</form>"+
				"<form class='login' action='sair.jsp' method='POST'>"+
			"<input type='submit' value='sair' />"+"</form>"+
			"<form class='login' action='cadastrar_livro.jsp' method='POST'>"+
			"<input type='submit' value='Cadastrar Livro'/>"+"</form>");
			}else{
				out.print("<form class='login' action='login.jsp' method='POST'>"+
						"<input type='submit' value='login' />"+"</form>");
			}
		
		%>

	<hr />
	</header>

<div class="corpo">
	<p align="center">
		
		<form action="cadastro.jsp" method="POST">
			<table align="center" border="0">
				<tr><td>Nome:</td><td><input type="text" name="txtNome"/></td></tr>
				<tr><td>Tema:</td><td><input type="text" name="txtTema"/></td></tr>
				<tr><td>Autor:</td><td><input type="text" name="txtAutor"/></td></tr>
				<tr><td>Quantidade:</td><td><input type="text" name="txtQtde"/></td></tr>
				<tr><td colspan="2" align="center"><input type="submit" value="Cadastrar"></td></tr>
			</table>	
		</form>
	</p>

		<hr />
		
		<p align="center"><a href="https://sga.impacta.com.br/sophia_web/" >Pagina de referencia</a></p>

</div>
</body>
</html>