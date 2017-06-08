package br.com.biblioteca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.biblioteca.banco.ConnectionFactory;
import sistema.Livro;

public class JDBCLivroDAO implements LivroDAO {
	
	Connection connection;
	
	public JDBCLivroDAO(){
		connection = ConnectionFactory.getConnection();
	}

	@Override
	public void inserir(Livro livro) {
		
		try {
		String SQL = "INSERT INTO TB_livro (nome,autor,tema,qtde_estoque) VALUES (?,?,?,?)";
		
			PreparedStatement ps = connection.prepareStatement(SQL);
			
			ps.setString(1, livro.getNome());
			ps.setString(2, livro.getAutor());
			ps.setString(3, livro.getTema());
			ps.setInt(4, livro.getQtde_estoque());
			
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
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

	@Override
	public List<Livro> listar() {
		
		List<Livro> livros = new ArrayList<Livro>();
		
		try {
			String SQL = "SELECT * FROM TB_livro";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Livro livro = new Livro(rs.getString("nome"),rs.getString("autor"),rs.getString("tema"),rs.getInt("qtde_estoque"));
				livros.add(livro);
				
			}
			ps.close();
			rs.close();
			return livros;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Falha ao listar livros");
		}
		
	}

	@Override
	public Livro buscar(int id) {
		
		try {
			
			String SQL = "SELECT * FROM TB_livro WHERE id_livro = ?";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			Livro livro = new Livro(rs.getString("nome"),rs.getString("autor"),rs.getString("tema"),rs.getInt("qtde_estoque"));
			livro.setId(rs.getInt("id_livro"));
			
			return livro;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Falha ao buscar livro");
		}
		
		
	}

	@Override
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
