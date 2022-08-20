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
