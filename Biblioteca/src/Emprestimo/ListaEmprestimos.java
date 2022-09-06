package Emprestimo;

import java.time.LocalDate;
import java.util.ArrayList;

import Biblioteca.Biblioteca;
import Biblioteca.Disponibilidade;

public class ListaEmprestimos {

	private ArrayList<Emprestimo> alEmprestimos;
	private ArrayList<Emprestimo> alHistEmprestimos;

	// construtor cria alEmprestimos, ArrayList que fica encapsulado na classe
	// ListaEmprestimos
	public ListaEmprestimos() {
		super();
		this.alEmprestimos = new ArrayList<Emprestimo>();
	}
	public ArrayList<Emprestimo> getListaEmprestimos() {
		return alEmprestimos;
	}
	public ArrayList<Emprestimo> getHistorico() {
		return alHistEmprestimos;
	}

	public void addEmprestimo(int idAmigo, int idLivro, Biblioteca biblioteca) {
		LocalDate dataEmp = LocalDate.now();
		Emprestimo emprestimo = new Emprestimo(idAmigo, idLivro, dataEmp);
		alEmprestimos.add(emprestimo);
		biblioteca.getLivro(idLivro).setDispLivro(Disponibilidade.EMPRESTADO);

	}

	// public void Devolver(int idLivro, Biblioteca biblioteca) {
	// 	for (Emprestimo emprestimo : alEmprestimos) {
	// 		if (emprestimo.getIdLivro() == idLivro) {
	// 			emprestimo.setDataDevolução();
	// 			biblioteca.getLivro(idLivro).setDispLivro(Disponibilidade.DISPONIVEL);
	// 			alEmprestimos.remove(emprestimo);
	// 			LocalDate dataEmprestimo = emprestimo.getDataEmprestimo();
	// 			LocalDate dataDevolucao = LocalDate.now();
	// 			Emprestimo devolucao = new Emprestimo(idLivro, dataEmprestimo, dataDevolucao);
	// 			alHistEmprestimos.add(devolucao);
	// 		}
	// 	}
	// }
	public void Devolver(int idLivro, Biblioteca biblioteca) {
		for (Emprestimo emprestimo: alEmprestimos){
			biblioteca.getLivro(idLivro).setDispLivro(Disponibilidade.DISPONIVEL);
			LocalDate dataEmprestimo = emprestimo.getDataEmprestimo();
			LocalDate dataDevolucao = LocalDate.now();
			Emprestimo devolucao = new Emprestimo(idLivro, dataEmprestimo, dataDevolucao);
			alEmprestimos.add(devolucao);
		}	
		
	}



	// construtor
	// addEmprestimo
	// getters e setters
	// toString
	// etc
}
