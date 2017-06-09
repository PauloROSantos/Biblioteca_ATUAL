package br.com.biblioteca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.biblioteca.banco.ConnectionFactory;
import sistema.Livro;
import sistema.Reserva;

public class JDBCReservaDAO{
	
	Connection connection;
	
	public JDBCReservaDAO(){
		try {
			connection = ConnectionFactory.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void inserir(Reserva reserva) {
		
		try {
			String SQL = "INSERT INTO TB_reserva (id_livro,ra_usuario,data_reserva,data_limite) VALUES (?,?,?,?)";
			
				PreparedStatement ps = connection.prepareStatement(SQL);
				
				ps.setInt(1, reserva.getId_livro());
				ps.setInt(2, reserva.getRa_usuario());
				ps.setDate(3, reserva.getData_reserva());
				ps.setDate(4, null);
				
				ps.executeUpdate();
				ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}

	
	public void remover(int id) {
		try {
			String SQL = "DELETE FROM TB_reserva WHERE id_reserva = ?";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao deletar reserva");
		}
		
	}

	
	public List<Reserva> listar(int ra) {
		
		List<Reserva> reservas = new ArrayList<Reserva>();
		
		try {
			String SQL = "SELECT * FROM TB_reserva WHERE ra_usuario = ?";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setInt(1, ra);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Reserva reserva = new Reserva(rs.getInt("id_livro"),rs.getInt("ra_usuario"));
				reserva.setId(rs.getInt("id_reserva"));
				reserva.setData_reserva(rs.getDate("data_reserva"));
				
				JDBCLivroDAO buscar_nome_livro = new JDBCLivroDAO();
				Livro livro = buscar_nome_livro.buscar_id(rs.getInt("id_livro"));
				
				reserva.setNome_livro(livro.getNome());
				reservas.add(reserva);
				
			}
			ps.close();
			rs.close();
			return reservas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Falha ao listar reservas");
		}
	}

	
	public Reserva buscar(int id) {
		try {
			
			String SQL = "SELECT * FROM TB_reserva WHERE id_reserva = ?";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			Reserva reserva = new Reserva(rs.getInt("id_livro"),rs.getInt("ra_usuario"));
			reserva.setId(rs.getInt("id_reserva"));
			reserva.setData_reserva(rs.getDate("data_reserva"));
			
			
			return reserva;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Falha ao buscar reserva");
		}
	}

	
	public void editar(Reserva reserva) {
		try {
			String SQL = "UPDATE TB_reserva SET id_livro=?,ra_usuario=?,data_reserva=? WHERE id_reserva =?";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setInt(1, reserva.getId_livro());
			ps.setInt(2, reserva.getRa_usuario());
			ps.setDate(3, reserva.getData_reserva());
			ps.setInt(4, reserva.getId());
			
			
			ps.executeUpdate();
			ps.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
