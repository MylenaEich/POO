package Emprestimo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import Amigo.Amigo;
import Biblioteca.Disponibilidade;
import Biblioteca.Livro;

public class Emprestimo {

	private int idAmigo;
	private int idLivro;
	private LocalDate dataEmprestimo;
	private LocalDate dataDevolucao;

	// para a equipe PENSAR nesta repeti��o de informa��o, pois pode-se obter os
	// objetos pelo IDs
	// caso mantenha a base do ArrayList organizada fisicamente, pode usar o Id como
	// chave de acesso
	// caso contr�rio, ou como op��o extra para acesso, pode manter a refer�ncia ao
	// objeto
	private Livro livro;
	private Amigo amigo;

	// construtor
	public Emprestimo(int idAmigo, int idLivro, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
		super();
		this.idAmigo = idAmigo;
		this.idLivro = idAmigo;
		this.dataDevolucao = dataDevolucao;
		this.dataEmprestimo = dataEmprestimo;
	}

	public Emprestimo(int idAmigo, int idLivro, LocalDate dataEmprestimo) {
		super();
		this.idAmigo = idAmigo;
		this.idLivro = idAmigo;
		this.dataEmprestimo = dataEmprestimo;
	}
	// getters e setters

	public int getIdAmigo() {
		return this.idAmigo;
	}

	public int getIdLivro() {
		return this.idLivro;
	}

	// demais m�todos
	// toString

}
