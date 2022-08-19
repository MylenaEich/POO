package Emprestimo;

import java.time.LocalDate;

import java.util.ArrayList;

import Biblioteca.Biblioteca;
import Biblioteca.Disponibilidade;
import Biblioteca.Livro;

public class ListaEmprestimos {

	private ArrayList<Emprestimo> alEmprestimos;

	// construtor cria alEmprestimos, ArrayList que fica encapsulado na classe
	// ListaEmprestimos
	public ListaEmprestimos() {
		super();
		this.alEmprestimos = new ArrayList<Emprestimo>();
	}

	public void addEmprestimo(int idAmigo, int idLivro, LocalDate dataEmprestimo, Biblioteca biblioteca) {
		Emprestimo emprestimo = new Emprestimo(idAmigo, idLivro, dataEmprestimo);
		alEmprestimos.add(emprestimo);
		biblioteca.getLivro(idLivro).setDispLivro(Disponibilidade.EMPRESTADO);

	}

	// construtor
	// addEmprestimo
	// getters e setters
	// toString
	// etc
}
