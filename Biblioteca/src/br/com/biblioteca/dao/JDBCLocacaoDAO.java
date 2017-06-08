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

public class JDBCLocacaoDAO implements LocacaoDAO {
	
	Connection connection;
	
	public JDBCLocacaoDAO(){
		connection = ConnectionFactory.getConnection();
	}

	@Override
	public void inserir(Locacao locacao) {
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
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}

	@Override
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

	@Override
	public List<Locacao> listar() {
		
		List<Locacao> locacoes = new ArrayList<Locacao>();
		
		try {
			String SQL = "SELECT * FROM TB_locacao";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Locacao locacao = new Locacao(rs.getInt("ra_usuario"),rs.getInt("id_livro"));
				locacao.setId(rs.getInt("id_locacao"));
				locacao.setData_emprestimo(rs.getDate("data_emprestimo"));
				locacao.setStatus(rs.getString("status"));
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

	@Override
	public Locacao buscar(int id) {
		try {
			
			String SQL = "SELECT * FROM TB_locacao WHERE id_locacao = ?";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			Locacao locacao = new Locacao(rs.getInt("ra_usuario"),rs.getInt("id_livro"));
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

	@Override
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
