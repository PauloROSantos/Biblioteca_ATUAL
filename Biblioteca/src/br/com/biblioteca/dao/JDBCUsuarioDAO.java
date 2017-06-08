package br.com.biblioteca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.biblioteca.banco.ConnectionFactory;
import sistema.Usuario;

public class JDBCUsuarioDAO implements UsuarioDAO {
	
	Connection connection;
	
	public JDBCUsuarioDAO(){
		connection = ConnectionFactory.getConnection();
	}

	@Override
	public void inserir(Usuario usuario) {
		
		try {
			String SQL = "INSERT INTO TB_usuario (ra_usuario,nome,senha,nivel) VALUES (?,?,?,?)";
			
				PreparedStatement ps = connection.prepareStatement(SQL);
				
				ps.setInt(1, usuario.getRa());
				ps.setString(2, usuario.getNome());
				ps.setString(3, usuario.getSenha());
				ps.setInt(4, usuario.getNivel());
				
				ps.executeUpdate();
				ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}

	@Override
	public void remover(int id) {
		
		try {
			String SQL = "DELETE FROM TB_usuario WHERE id_usuario = ?";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao deletar usuario");
		}
		
	}

	@Override
	public List<Usuario> listar() {
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		try {
			String SQL = "SELECT * FROM TB_usuario";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Usuario usuario = new Usuario(rs.getInt("ra_usuario"),rs.getString("nome"),rs.getString("senha"),rs.getInt("nivel"));
				usuarios.add(usuario);
				
			}
			ps.close();
			rs.close();
			return usuarios;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Falha ao listar usuarios");
		}
	}

	@Override
	public Usuario buscar(int id) {
		try {
			
			String SQL = "SELECT * FROM TB_usuario WHERE ra_usuario = ?";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			Usuario usuario = new Usuario(rs.getInt("ra_usuario"),rs.getString("nome"),rs.getString("senha"),rs.getInt("nivel"));
			
			
			return usuario;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Falha ao buscar usuario");
		}
	}

	@Override
	public void editar(Usuario usuario) {
		try {
			String SQL = "UPDATE TB_usuario SET nome=?,senha=?,nivel=? WHERE ra_usuario =?";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getSenha());
			ps.setInt(3, usuario.getNivel());
			ps.setInt(4, usuario.getRa());
			
			
			ps.executeUpdate();
			ps.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
