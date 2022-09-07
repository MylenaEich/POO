package Principal;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

import Amigo.*;
import Emprestimo.*;
import Biblioteca.*;

public class Principal {

	private static Biblioteca bib = new Biblioteca("Biblioteca Pessoal");
	private static ListaEmprestimos emprestimos = new ListaEmprestimos();
	private static ListaAmigos amigos = new ListaAmigos();

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int opcao;
		int idAmigo;
		idAmigo = amigos.addAmigo("Maria", "(41) 99876-5432");

		idAmigo = amigos.addAmigo("Jose", "(47) 98123-2121");

		/*
		 * for (int i =0; i < amigos.getListaAmigosSize(); i++) {
		 * Amigo amigo = amigos.getAmigo(i);
		 * System.out.println("Nome: " + amigo.getNome());
		 * System.out.println("Celular: " + amigo.getCelular());
		 * }
		 */

		int idLivros;

		idLivros = bib.addLivro("Harry Potter", "J.K", 30, Disponibilidade.DISPONIVEL);
		idLivros = bib.addLivro("A hora da estrela", "Clarice Lispector", 20, Disponibilidade.DISPONIVEL);

		/*
		 * for (int i =0; i < bib.getBibliotecaSize(); i++) {
		 * Livro livro = bib.getLivro(i);
		 * System.out.println("Titulo: " + livro.getTitulo());
		 * System.out.println("Autor: " + livro.getAutor());
		 * System.out.println("Preco: " + livro.getPreco());
		 * System.out.println("Disponibilidade: " + livro.getDispLivro());
		 * }
		 */

		do {
			System.out.println("\nMENU INICIAL\n");
			System.out.println("0 - sair \n1 - cadastrar livro \n2 - cadastrar amigo \n3 - emprestar");
			System.out.println("4 - devolver \n5 - listar emprestimos atuais");
			System.out.println("6 - listar historico de emprestimos de um livro \n7 - listar toda a biblioteca");
			System.out.println("8 - alterar estado \n");

			opcao = scanner.nextInt();

			switch (opcao) {
				case 0:
					System.out.println("\n   Obrigado por usar o sistema!");
					break;
				case 1:
					cadastrarLivro();
					break;
				case 2:
					cadastrarAmigo();
					break;

				case 3:
					emprestarLivro();
					break;
				case 4:
					devolverLivro();
					break;
				case 5:
					ListarEmprestimos();
					break;
				case 6:
					ListarHistorico();
					break;
				case 7:
					listarBib();
					break;
				case 8:
					alteraEstado();
					break;
			}
		} while (opcao != 0);

	}

	private static void cadastrarLivro() {

		System.out.println("\n==> Cadastro de livro\n");
		scanner.nextLine();

		String titulo, autor;
		float preco;

		System.out.print("   Titulo: ");
		titulo = scanner.nextLine();

		System.out.print("   Autor: ");
		autor = scanner.nextLine();

		System.out.print("   preco: ");
		preco = scanner.nextFloat();
		bib.addLivro(titulo, autor, preco, Disponibilidade.DISPONIVEL);
		System.out.println("\n" + titulo + " cadastrado!\n");
	}

	private static void cadastrarAmigo() {

		System.out.println("\n==> Cadastro de amigo\n");
		scanner.nextLine();

		String nome;
		String celular;

		System.out.print("   Nome: ");
		nome = scanner.nextLine();

		System.out.print("   Celular: ");
		celular = scanner.nextLine();

		amigos.addAmigo(nome, celular);
		System.out.println("\n" + nome + " cadastrado(a)!\n");
	}

	private static void emprestarLivro() {

		int idLivro;
		int idAmigo;
		String nomeAmigo;
		Disponibilidade dispLivro = Disponibilidade.CONSULTALOCAL;

		System.out.println("\n==> Sistema de emprestimo\n");
		scanner.nextLine();

		listarBib();
		System.out.println("Selecione o ID do livro:\n");
		idLivro = scanner.nextInt();
		Livro livro = bib.getLivro(idLivro);
		dispLivro = bib.getLivro(idLivro).getDispLivro();
		while(dispLivro != Disponibilidade.DISPONIVEL){
			System.out.println(" \n Este livro não está disponível! \n");
			idLivro = scanner.nextInt();
			dispLivro = bib.getLivro(idLivro).getDispLivro();
		}
		listarAmigos();
		System.out.println("\n   Selecione o amigo: \n");
		idAmigo = scanner.nextInt();
		nomeAmigo = amigos.getAmigo(idAmigo).getNome();
		emprestimos.addEmprestimo(idAmigo, idLivro, bib);
		System.out.println("\n Livro " + livro.getTitulo() + " emprestado para" + nomeAmigo + "\n");
	}

	private static void devolverLivro() {

		int idLivro;
		Disponibilidade dispLivro = Disponibilidade.CONSULTALOCAL;

		System.out.println("\n==> Sistema de devolução\n");
		System.out.println("   Código do livro para devolução: \n");
		idLivro = scanner.nextInt();
		Livro livro = bib.getLivro(idLivro);
		dispLivro = bib.getLivro(idLivro).getDispLivro();
		while(dispLivro != Disponibilidade.EMPRESTADO){
			System.out.println("Esse Livro não foi emprestado!");
			idLivro = scanner.nextInt();
			dispLivro = bib.getLivro(idLivro).getDispLivro();
		}
		emprestimos.Devolver(idLivro, bib); /// -> como isso?
		System.out.println("\n Livro " + livro.getTitulo() + " emprestado! \n");
	}
	private static void ListarEmprestimos(){
		System.out.println("\n==> Emprestimos atuais\n");
		ArrayList<Emprestimo> alEmprestimos;
		alEmprestimos = emprestimos.getListaEmprestimos();
		if(alEmprestimos.size() == 0){
			System.out.println("\n Nenhum emprestimo foi realizado! \n");
		}
		for(Emprestimo emprestimo : alEmprestimos){
			Livro livro = bib.getLivro(emprestimo.getIdLivro());
			System.out.println(" Livro: " + livro.getTitulo());
			Amigo amigo = amigos.getAmigo(emprestimo.getIdAmigo());
			System.out.println(" Amigo: " + amigo.getNome());
			System.out.println(" Data Emprestimo: " + emprestimo.getDataEmprestimo());
			if(emprestimo.getDataDevolucao() != null){
				System.out.println(" Data Devolução: " + emprestimo.getDataDevolucao() + "\n");
			}
		}
	}
	private static void ListarHistorico(){
		System.out.println("\n ==> Listar Historico por Livro \n");
		int idLivro;
		System.out.println("Selecione um Livro\n");
		listarBib();
		idLivro = scanner.nextInt();
		ArrayList<Emprestimo> alEmprestimos;
		alEmprestimos = emprestimos.getListaEmprestimos();
		for(Emprestimo emprestimo : alEmprestimos){
			if(emprestimo.getIdLivro() == idLivro){
				if(alEmprestimos.size() == 0){
					System.out.println("\n Este livro ainda não foi emprestado! \n");
				}
				Livro livro = bib.getLivro(emprestimo.getIdLivro());
				System.out.println(" Livro: " + livro.getTitulo());
				Amigo amigo = amigos.getAmigo(emprestimo.getIdAmigo());
				System.out.println(" Amigo: " + amigo.getNome());
				System.out.println(" Data Emprestimo: " + emprestimo.getDataEmprestimo());
				if(emprestimo.getDataDevolucao() != null){
					System.out.println(" Data Devolução: " + emprestimo.getDataDevolucao() + "\n");
				}
			}
		}
	}
	private static void listarBib() {

		System.out.println("\n==> Livros da Biblioteca");

		ArrayList<Livro> alLivros, aux;
		float investimento = 0;

		aux = bib.getBiblioteca(); // Ordena de A-Z pelo titulo
		alLivros = (ArrayList<Livro>) aux.clone();
		Collections.sort(alLivros);

		for (Livro livro : alLivros) {
			System.out.println("   ID: " + livro.getIdLivro());
			System.out.println("   Titulo: " + livro.getTitulo());
			System.out.println("   Situacao: " + livro.getDispLivro());
			System.out.println("   Preco: " + livro.getPreco() + "\n");
			investimento = investimento + livro.getPreco();
		}

		bib.setInvestimento(investimento);
		System.out.println("   Investimento da biblioteca: " + investimento + "\n");
	}

	private static void listarAmigos() {

		ArrayList<Amigo> alAmigos, aux;
		aux = amigos.getListaAmigos(); // Ordena de A-Z pelo titulo
		alAmigos = (ArrayList<Amigo>) aux.clone();
		alAmigos = amigos.getListaAmigos();
		Collections.sort(alAmigos);

		for (Amigo amigo : alAmigos) {
			System.out.println("\n ID: " + amigo.getidAmigo() + "\n Nome: " + amigo.getNome() + "\n");
		}

	}
	private static void alteraEstado(){
		int idLivro, op;
		Disponibilidade dispLivro;
		System.out.println("\n==> Alterar Estado\n");
		listarBib();
		System.out.println("Selecione um livro: \n");
		idLivro = scanner.nextInt();
		System.out.println("Qual estado deseja selecionar?\n");
		System.out.println("1: CONSULTA LOCAL\n2: DANIFICADO\n3: ESTRAVIADO\n");
		Livro livro = bib.getLivro(idLivro);
		op = scanner.nextInt();
		switch (op) {
			case 1:
				dispLivro = bib.getLivro(idLivro).getDispLivro();
				if(dispLivro == Disponibilidade.EMPRESTADO){
					System.out.println("\n Não é possível mudar para o estado CONSULTA LOCAL, pois o livro está emprestado!\n");
				}
				bib.getLivro(idLivro).setDispLivro(Disponibilidade.CONSULTALOCAL);
				System.out.println("Estado de " + livro.getTitulo() + " alterado para CONSULTA LOCAL");
				break;
			case 2:
				bib.getLivro(idLivro).setDispLivro(Disponibilidade.DANIFICADO);
				System.out.println("Estado de " + livro.getTitulo() + " alterado para DANIFICADO");
				break;
			case 3:
				bib.getLivro(idLivro).setDispLivro(Disponibilidade.EXTRAVIADO);
				System.out.println("Estado de " + livro.getTitulo() + " alterado para EXTRAVIADO");
				break;
		}
	}
	private static void verificaEstado(int idLivro){
		Disponibilidade dispLivro;
		dispLivro = bib.getLivro(idLivro).getDispLivro();
		switch (dispLivro){
			case DISPONIVEL:
				System.out.println("\nEste livro está disponivel\n" );
				break;
			case EMPRESTADO:
				System.out.println("\nEste livro está emprestado\n" );
				break;
			case CONSULTALOCAL:
				System.out.println("\nConsultar estado do livro\n" );
				break;
			case DANIFICADO:
				System.out.println("\nEste livro esta Danificado\n" );
				break;
			case EXTRAVIADO:
				System.out.println("\nEste livro esta Extraviado\n");
				break;
		}

	}
}
