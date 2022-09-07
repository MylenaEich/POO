package Emprestimo;

import java.time.LocalDate;

import Amigo.*;
import Biblioteca.*;

public class Emprestimo {

	private static Amigo amigo;
	private static Livro livro;

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
		this. dataDevolucao = null;
	}

	// getters e setters

	public int getIdAmigo() {
		return this.idAmigo;
	}

	public int getIdLivro() {
		return this.idLivro;
	}
	public String getTitulo(){
		return livro.getTitulo();
	}

	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}
	public void setDataEmprestimo() {
		this.dataEmprestimo = LocalDate.now();
	}
	public LocalDate getDataDevolucao(){
		return dataDevolucao;
	}
	public void setDataDevolução() {
		this.dataDevolucao = LocalDate.now();
	}
	
	// demais m�todos
	// toString

}
