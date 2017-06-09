package sistema;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class Biblioteca {
	
	
	//--------------------- Variaveis ------------------//
	
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	ArrayList<Locacao> locacoes = new ArrayList<Locacao>();
	ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	ArrayList<Livro> livros = new ArrayList<Livro>();
	
	//--------------------- Metodos ------------------//
	
	/*
	public boolean cadastrar_livro(String autor, String nome, String tema,int qtde){
		Livro novo_livro = new Livro(autor,nome,tema, qtde);
		livros.add(novo_livro);
		return true;
	}
	
	public boolean cadastrar_usuario( int ra, String nome, String senha, int nivel){
		Usuario novo_usuario = new Usuario(ra,nome, senha, nivel);
		usuarios.add(novo_usuario);
		return true;
	}
	
	public boolean locar_livro(Usuario usuario, Livro livro){
		int id_livro = livro.getId();
		int ra_usuario = usuario.getRa();
		Locacao nova_locacao = new Locacao(ra_usuario,id_livro);
		locacoes.add(nova_locacao);
		return true;
	}
	
	public boolean reservar_livro(Usuario usuario, Livro livro){
		int id_livro = livro.getId();
		int ra_usuario = usuario.getRa();
		Reserva nova_reserva = new Reserva(id_livro,ra_usuario);
		reservas.add(nova_reserva);
		return true;
	}
	
	public boolean login(){
		
		return true;
	}
	

	
	public Livro pesquisar_livro(String nome){
		for(Livro livro_da_vez : livros){
			if(livro_da_vez.getNome().contains(nome)){
				return livro_da_vez;
			}
		}
		return null;
		
		
	}
	
	public static List<Livro> listar_livro() throws SQLException {
			
		LivroDAO ld = DAOFactory.createLivroDAO();
		List<Livro> livros = ld.listar();
		
		return livros;
		
	}
	
	*/
	
	//--------------------- Main ---------------------//
	
	public static void main(String[] args) throws ServletException, IOException, SQLException {
		
		//System.out.println(listar_livro());

	}

}
