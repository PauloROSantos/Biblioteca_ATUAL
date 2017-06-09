package br.com.biblioteca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.biblioteca.banco.ConnectionFactory;
import sistema.Livro;
import sistema.Locacao;
import sistema.Reserva;

public class JDBCLocacaoDAO  {
	
	Connection connection;
	
	public JDBCLocacaoDAO(){
		try {
			connection = ConnectionFactory.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public boolean inserir(Locacao locacao) {
		try {
			String SQL = "INSERT INTO TB_locacao (id_livro,ra_usuario,data_emprestimo,data_devolucao,status) VALUES (?,?,?,?,?)";
			
				PreparedStatement ps = connection.prepareStatement(SQL);
				
				ps.setInt(1, locacao.getId_livro());
				ps.setInt(2, locacao.getRa_usuario());
				ps.setDate(3, locacao.getData_emprestimo());
				ps.setDate(4, null);
				ps.setString(5, locacao.getStatus());
				
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
			String SQL = "DELETE FROM TB_locacao WHERE id_locacao = ?";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao deletar locacao");
		}
		
	}

	
	public List<Locacao> listar(int ra) {
		
		List<Locacao> locacoes = new ArrayList<Locacao>();
		
		try {
			String SQL = "SELECT * FROM TB_locacao WHERE ra_usuario = ?";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setInt(1, ra);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Locacao locacao = new Locacao();
				locacao.setRa_usuario(rs.getInt("ra_usuario"));
				locacao.setId_livro(rs.getInt("id_livro"));
				locacao.setId(rs.getInt("id_locacao"));
				locacao.setData_emprestimo(rs.getDate("data_emprestimo"));
				locacao.setStatus(rs.getString("status"));
				
				JDBCLivroDAO buscar_nome_livro = new JDBCLivroDAO();
				Livro livro = buscar_nome_livro.buscar_id(rs.getInt("id_livro"));
				
				locacao.setNome_livro(livro.getNome());
				locacoes.add(locacao);
				
			}
			ps.close();
			rs.close();
			return locacoes;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Falha ao listar livros");
		}
	}

	
	public Locacao buscar(int id) {
		try {
			
			String SQL = "SELECT * FROM TB_locacao WHERE id_locacao = ?";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			Locacao locacao = new Locacao();
			locacao.setRa_usuario(rs.getInt("ra_usuario"));
			locacao.setId_livro(rs.getInt("id_livro"));
			locacao.setId(rs.getInt("id_locacao"));
			locacao.setData_emprestimo(rs.getDate("data_emprestimo"));
			locacao.setStatus(rs.getString("status"));
			
			
			return locacao;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Falha ao buscar reserva");
		}
	}

	
	public void editar(Locacao locacao) {
		try {
			String SQL = "UPDATE TB_locacao SET id_livro=?,ra_usuario=?,data_reserva=? WHERE id_locacao =?";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setInt(1, locacao.getId_livro());
			ps.setInt(2, locacao.getRa_usuario());
			ps.setDate(3, locacao.getData_emprestimo());
			ps.setInt(4, locacao.getId());
			
			
			ps.executeUpdate();
			ps.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
