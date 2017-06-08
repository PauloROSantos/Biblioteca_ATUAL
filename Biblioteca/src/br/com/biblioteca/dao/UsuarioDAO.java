package br.com.biblioteca.dao;

import java.util.List;

import sistema.Usuario;

public interface UsuarioDAO {
	public void inserir(Usuario usuario);
	public void remover(int id);
	public List<Usuario> listar();
	public Usuario buscar(int id);
	public void editar(Usuario livro);

}
