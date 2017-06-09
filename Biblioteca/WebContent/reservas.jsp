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
	<p class="hora"><%   %></p>
	
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
	<table class="tabela_livros" align="center">
			<tr class="tabela_livros">
				<td class="tabela_livros"><b>Livro</b></td>
				<td class="tabela_livros"><b>Data</b></td>
				<td class="tabela_livros"><b>Status</b></td>
			</tr>
			<% JDBCReservaDAO loc = new JDBCReservaDAO();
				Integer id = (Integer)session.getAttribute("ra"); %><%
				String teste = id.toString();
				int teste2 = Integer.parseInt(teste);
				List<Reserva> reservas = loc.listar(id);
				
				out.print(session.getAttribute("ra"));
				
			
				for(Reserva reserva : reservas){ %>
				<tr class="tabela_livros">
					<td class="tabela_livros"><%= reserva.getNome_livro() %></td>
					<td class="tabela_livros"><%= reserva.getData_reserva() %></td>
					<td class="tabela_livros"> Reservado </td>
				
				</tr>
				<%} %>
	</table>
		<hr />
		
		<p align="center"><a href="https://sga.impacta.com.br/sophia_web/" >Pagina de referencia</a></p>

</div>
</body>
</html>