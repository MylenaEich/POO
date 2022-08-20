package Emprestimo;

import java.time.LocalDate;

import java.util.ArrayList;

import Biblioteca.Biblioteca;
import Biblioteca.Disponibilidade;

public class ListaEmprestimos {

	private ArrayList<Emprestimo> alEmprestimos;

	// construtor cria alEmprestimos, ArrayList que fica encapsulado na classe
	// ListaEmprestimos
	public ListaEmprestimos() {
		super();
		this.alEmprestimos = new ArrayList<Emprestimo>();
	}

	public void addEmprestimo(int idAmigo, int idLivro, Biblioteca biblioteca) {
		Emprestimo emprestimo = new Emprestimo(idAmigo, idLivro, LocalDate.now());
		alEmprestimos.add(emprestimo);
		biblioteca.getLivro(idLivro).setDispLivro(Disponibilidade.EMPRESTADO);

	}

	public void Devolver(int idLivro, Biblioteca biblioteca) {
		for (Emprestimo emprestimo : alEmprestimos) {
			if (emprestimo.getIdLivro() == idLivro) {
				emprestimo.setDataDevolução();
				biblioteca.getLivro(idLivro).setDispLivro(Disponibilidade.DISPONIVEL);
			}
		}
	}

	// construtor
	// addEmprestimo
	// getters e setters
	// toString
	// etc
}
