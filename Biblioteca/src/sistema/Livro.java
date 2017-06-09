package sistema;



public class Livro {
	
	//--------------------- Variaveis ------------------//

	String autor;
	int id;
	String nome;
	int qtde_estoque;
	String tema;
	String status;
	
	//--------------------- Get / set ------------------//

	
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQtde_estoque() {
		return qtde_estoque;
	}
	public void setQtde_estoque(int qtde_estoque) {
		this.qtde_estoque = qtde_estoque;
	}
	public String getTema() {
		return tema;
	}
	public void setTema(String tema) {
		this.tema = tema;
	}
	
	//--------------------- Construtor ------------------//

	
	public Livro() {
		
	}
	
	
	//--------------------- Metodos ------------------//

	
	public boolean locar(Usuario usuario){
		int ra_usuario = usuario.getRa();
		Locacao nova_locacao = new Locacao();
		return true;
	}
	
	public boolean reservar(Usuario usuario){
		int ra_usuario = usuario.getRa();
		Reserva nova_reserva = new Reserva(id,ra_usuario);
		return true;
	}
	public String getStatus() {
		if(qtde_estoque > 0){
			status = "disponivel";
		}else{
			status = "Não disponivel";
		}
		return status;
	}
	

}
