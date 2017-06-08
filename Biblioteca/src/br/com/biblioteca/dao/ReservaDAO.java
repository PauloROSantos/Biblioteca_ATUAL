package br.com.biblioteca.dao;

import java.util.List;

import sistema.Reserva;

public interface ReservaDAO {
	public void inserir(Reserva reserva);
	public void remover(int id);
	public List<Reserva> listar();
	public Reserva buscar(int id);
	public void editar(Reserva reserva);

}
