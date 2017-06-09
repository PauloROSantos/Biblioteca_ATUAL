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

	<header> 
	<!-- ESPAÇO PARA O BANNER -->

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
			"<input type='submit' value='sair'/>"+"</form>"+
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
	<table class="tabela_livros" align="center" style="width:50%">
			<tr class="tabela_livros">
				<td class="tabela_livros"><b>Nome</b></td>
				<td class="tabela_livros"><b>Tema</b></td>
				<td class="tabela_livros"><b>Autor</b></td>
				<td class="tabela_livros"><b>Status</b></td>
				<td class="tabela_livros" colspan="1"><b>Locar</b></td>
			</tr>
			<% JDBCLivroDAO ld = new JDBCLivroDAO();
				List<Livro> livros = ld.listar();
			
				for(Livro livro : livros){ %>
				<tr class="tabela_livros">
					<td class="tabela_livros"><%= livro.getNome() %></td>
					<td class="tabela_livros"><%= livro.getTema() %></td>
					<td class="tabela_livros"><%= livro.getAutor() %></td>
					<td class="tabela_livros"><%= livro.getStatus() %></td>
					<td class="tabela_livros"><form action="locado.jsp" method="POST">
											<input type="text" name="txtRA"/>
											<input type="hidden" value="<%= livro.getId() %>" name="txtLivro"/>
				<% 
					int teste = livro.getId();
					if(session.getAttribute("logado") != null)
						out.print("<input type='submit' value='locar'></form></td>");%>	
					
				
				</tr>
					
				<%} %>
			
			
		
	</table>
		<p></p>
		
		<hr />
		
		<p align="center"><a href="https://sga.impacta.com.br/sophia_web/" >Pagina de referencia</a></p>
		
		

</div>
</body>
</html>