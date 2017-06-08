package br.com.biblioteca.teste;

import java.util.List;

import br.com.biblioteca.banco.DAOFactory;
import br.com.biblioteca.dao.LivroDAO;
import br.com.biblioteca.dao.LocacaoDAO;
import br.com.biblioteca.dao.ReservaDAO;
import br.com.biblioteca.dao.UsuarioDAO;
import sistema.Livro;
import sistema.Locacao;
import sistema.Reserva;
import sistema.Usuario;

public class Teste {
	
	public static void main(String[] args) {
		
		Livro livro = new Livro("nomeNOVO","autorNOVO","temaNOVO",15);
		LivroDAO ld = DAOFactory.createLivroDAO();
		
		Usuario usuario = new Usuario(001,"nomeTESTE","senhaTESTE",1);
		UsuarioDAO ud = DAOFactory.createUsuarioDAO();
		
		Locacao locacao = new Locacao(usuario.getRa(),1);
		LocacaoDAO lod = DAOFactory.createLocacaoDAO();
		
		Reserva reserva = new Reserva(usuario.getRa(),1);
		ReservaDAO rd = DAOFactory.createReservaDAO();
		
		/*
		ld.inserir(livro);
		ud.inserir(usuario);
		lod.inserir(locacao);
		rd.inserir(reserva);
		
		List<Locacao> locacoes = lod.listar();
		
		for(Locacao livro_da_vez : locacoes){
			System.out.println("id: "+livro_da_vez.getId()+" ra_usuario: "+livro_da_vez.getRa_usuario()+" data: "+livro_da_vez.getData_emprestimo());
		}
		
		Locacao livroTeste = lod.buscar(1);
		
		System.out.println("id do livro: "+livroTeste.getId()+" Nome do livro: "+livroTeste.getRa_usuario()+" Data:"+livroTeste.getData_emprestimo());
		*/
		
		Livro livroTeste2 = ld.buscar(1);
		livro.setId(livroTeste2.getId());
		ld.editar(livro);
		Livro livroTeste = ld.buscar(1);
		
		System.out.println("id do livro: "+livroTeste.getId()+" Nome do livro: "+livroTeste.getNome()+" tema:"+livroTeste.getTema());
	}

}
