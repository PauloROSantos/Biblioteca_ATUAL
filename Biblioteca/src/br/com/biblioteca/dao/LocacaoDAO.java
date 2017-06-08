package br.com.biblioteca.dao;

import java.util.List;

import sistema.Locacao;

public interface LocacaoDAO {
	public void inserir(Locacao locacao);
	public void remover(int id);
	public List<Locacao> listar();
	public Locacao buscar(int id);
	public void editar(Locacao locacao);

}
