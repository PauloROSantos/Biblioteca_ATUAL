package sistema;

import java.sql.Date;

public class Locacao {
	
	//--------------------- Variaveis ------------------//
	
	Date data_devolucao;
	int id;
	String status;
	int ra_usuario;
	Date data_emprestimo;
	int id_livro;
	
	//--------------------- Get / set ------------------//
	
	public Date getData_devolucao() {
		return data_devolucao;
	}

	public void setData_devolucao(Date data_devolucao) {
		this.data_devolucao = data_devolucao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getRa_usuario() {
		return ra_usuario;
	}

	public void setRa_usuario(int ra_usuario) {
		this.ra_usuario = ra_usuario;
	}

	public Date getData_emprestimo() {
		return data_emprestimo;
	}

	public void setData_emprestimo(Date data_emprestimo) {
		this.data_emprestimo = data_emprestimo;
	}

	public int getId_livro() {
		return id_livro;
	}

	public void setId_livro(int id_livro) {
		this.id_livro = id_livro;
	}

	
	//--------------------- Construtor ------------------//
	
	public Locacao(int ra_usuario, int id_livro) {
		super();
		
		this.status = "locado";
		this.ra_usuario = ra_usuario;
		this.id_livro = id_livro;
		java.util.Date dataUtil = new java.util.Date();
		Date date = new java.sql.Date(dataUtil.getTime());
		this.data_emprestimo = date;
	}
	
	
	//--------------------- Metodos --------------------//

}
