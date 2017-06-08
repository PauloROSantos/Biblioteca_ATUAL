package sistema;

import java.util.ArrayList;

public class Usuario {
	
	//--------------------- Variaveis ------------------//
	
	
	int nivel;
	String nome;
	int ra;
	String senha;
	
	ArrayList<Locacao> locacoes = new ArrayList<Locacao>();
	ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	
	//--------------------- Get / set ------------------//

	
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getRa() {
		return ra;
	}
	public void setRa(int ra) {
		this.ra = ra;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	//--------------------- Metodos ------------------//

	public ArrayList<Reserva> show_reservas(){
		
		ArrayList<Reserva> reservas2 = new ArrayList<Reserva>();
		
		for (Reserva reservas_da_vez : reservas ){
			reservas2.add(reservas_da_vez);
		}
		
		return reservas2;
	}
	
	public ArrayList<Locacao> show_locacoes(){
		
		ArrayList<Locacao> locacoes2 = new ArrayList<Locacao>();
		
		for (Locacao locacoes_da_vez : locacoes ){
			locacoes2.add(locacoes_da_vez);
		}
		
		return locacoes2;
	}
	
	//--------------------- Construtor ------------------//
	
	public Usuario( int ra, String nome, String senha,int nivel) {
		super();
		this.nivel = nivel;
		this.nome = nome;
		this.ra = ra;
		this.senha = senha;
	}
	

}
