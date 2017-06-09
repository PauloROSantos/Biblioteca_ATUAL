package sistema;


import java.sql.Date;

public class Reserva {
	
	//--------------------- variaveis ------------------//

	Date data_reserva;
	Date data_limite;
	int id;
	int id_livro;
	int ra_usuario;
	String nome_livro;
	
	//--------------------- Get / set ------------------//
	
	public String getNome_livro() {
		return nome_livro;
	}
	public void setNome_livro(String nome_livro) {
		this.nome_livro = nome_livro;
	}
	public void setId_livro(int id_livro) {
		this.id_livro = id_livro;
	}
	public Date getData_reserva() {
		return data_reserva;
	}
	public void setData_reserva(Date data_reserva) {
		this.data_reserva = data_reserva;
	}
	public Date getData_limite() {
		return data_limite;
	}
	public void setData_limite(Date data_limite) {
		this.data_limite = data_limite;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_livro() {
		return id_livro;
	}
	public void setLivro(int id_livro) {
		this.id_livro = id_livro;
	}
	public int getRa_usuario() {
		return ra_usuario;
	}
	public void setRa_usuario(int ra_usuario) {
		this.ra_usuario = ra_usuario;
	}
	

	
	//--------------------- Metodos ------------------//
	
	
	
	//--------------------- Construtor ------------------//

	public Reserva(int id_livro,int ra_usuario) {
		super();

		java.util.Date dataUtil = new java.util.Date();
		Date date = new java.sql.Date(dataUtil.getTime());
		this.data_reserva = date;
		this.id_livro = id_livro;
		this.ra_usuario = ra_usuario;
	}


	

}
