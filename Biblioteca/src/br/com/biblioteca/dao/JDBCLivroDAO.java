package br.com.biblioteca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.biblioteca.banco.ConnectionFactory;
import sistema.Livro;

public class JDBCLivroDAO{
	
	Connection connection;
	
	public JDBCLivroDAO(){
		try {
			connection = ConnectionFactory.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public boolean inserir(Livro livro) {
		
		try {
		String SQL = "INSERT INTO TB_livro (nome,autor,tema,qtde_estoque) VALUES (?,?,?,?)";
		
			PreparedStatement ps = connection.prepareStatement(SQL);
			
			ps.setString(1, livro.getNome());
			ps.setString(2, livro.getAutor());
			ps.setString(3, livro.getTema());
			ps.setInt(4, livro.getQtde_estoque());
			
			ps.executeUpdate();
			ps.close();
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	
	public void remover(int id) {
		
		try {
			String SQL = "DELETE FROM TB_livro WHERE id_livro = ?";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao deletar livro");
		}
		
	}

	
	public List<Livro> listar() {
		
		List<Livro> livros = new ArrayList<Livro>();
		
		try {
			String SQL = "SELECT * FROM TB_livro";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Livro livro = new Livro();
				livro.setNome(rs.getString("nome"));
				livro.setId(rs.getInt("id_livro"));
				livro.setAutor(rs.getString("autor"));
				livro.setTema(rs.getString("tema"));
				livro.setQtde_estoque(rs.getInt("qtde_estoque"));
				livros.add(livro);
				
			}
			ps.close();
			rs.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Falha ao listar livros");
		}
		return livros;
		
	}

	
	public Livro buscar(String nome) {
		Livro livro_teste = new Livro();
		try {
			
			String SQL = "SELECT * FROM TB_livro WHERE nome = ?";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setString(1, nome);
			ResultSet rs = ps.executeQuery();
			rs.next();
			Livro livro = new Livro();
			livro.setNome(rs.getString("nome"));
			livro.setId(rs.getInt("id_livro"));
			livro.setAutor(rs.getString("autor"));
			livro.setTema(rs.getString("tema"));
			livro.setQtde_estoque(rs.getInt("qtde_estoque"));
			
			return livro;
		} catch (SQLException e) {
			/*
			e.printStackTrace();
			throw new RuntimeException("Falha ao buscar livro");
			*/
			return livro_teste;
		}
		
		
	}
	public Livro buscar_id(int id) {
		Livro livro_teste = new Livro();
		try {
			
			String SQL = "SELECT * FROM TB_livro WHERE id_livro = ?";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			Livro livro = new Livro();
			livro.setNome(rs.getString("nome"));
			livro.setId(rs.getInt("id_livro"));
			livro.setAutor(rs.getString("autor"));
			livro.setTema(rs.getString("tema"));
			livro.setQtde_estoque(rs.getInt("qtde_estoque"));
			
			return livro;
		} catch (SQLException e) {
			/*
			e.printStackTrace();
			throw new RuntimeException("Falha ao buscar livro");
			*/
			return livro_teste;
		}
		
		
	}

	
	public void editar(Livro livro) {
		
		try {
			String SQL = "UPDATE TB_livro SET nome=?,autor=?,tema=?,qtde_estoque=? WHERE id_livro =?";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setString(1, livro.getNome());
			ps.setString(2, livro.getAutor());
			ps.setString(3, livro.getTema());
			ps.setInt(4, livro.getQtde_estoque());
			ps.setInt(5, livro.getId());
			
			ps.executeUpdate();
			ps.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
