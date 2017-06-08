package br.com.biblioteca.dao;

import java.util.List;

import sistema.Livro;

public interface LivroDAO {
	public void inserir(Livro livro);
	public void remover(int id);
	public List<Livro> listar();
	public Livro buscar(int id);
	public void editar(Livro livro);

}
