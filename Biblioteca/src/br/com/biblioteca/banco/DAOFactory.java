package br.com.biblioteca.banco;

import br.com.biblioteca.dao.JDBCLivroDAO;
import br.com.biblioteca.dao.JDBCLocacaoDAO;
import br.com.biblioteca.dao.JDBCReservaDAO;
import br.com.biblioteca.dao.JDBCUsuarioDAO;
import br.com.biblioteca.dao.LivroDAO;
import br.com.biblioteca.dao.LocacaoDAO;
import br.com.biblioteca.dao.ReservaDAO;
import br.com.biblioteca.dao.UsuarioDAO;

public class DAOFactory {
	public static LivroDAO createLivroDAO(){
		return new JDBCLivroDAO();
	}
	public static UsuarioDAO createUsuarioDAO(){
		return new JDBCUsuarioDAO();
	}
	public static ReservaDAO createReservaDAO(){
		return new JDBCReservaDAO();
	}
	public static LocacaoDAO createLocacaoDAO(){
		return new JDBCLocacaoDAO();
	}

}
