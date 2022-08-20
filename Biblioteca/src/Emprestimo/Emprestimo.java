package Emprestimo;

import java.time.LocalDate;

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

	public void setDataDevolução() {
		this.dataDevolucao = LocalDate.now();
	}
	// demais m�todos
	// toString

}
