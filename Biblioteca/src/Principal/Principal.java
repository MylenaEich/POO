package Principal;

import java.util.ArrayList;
import java.util.Scanner;

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
		idAmigo = amigos.addAmigo("Fulano", "(41) 99876-5432");

		idAmigo = amigos.addAmigo("Ciclano", "(47) 98123-2121");

		/*
		 * for (int i =0; i < amigos.getListaAmigosSize(); i++) {
		 * Amigo amigo = amigos.getAmigo(i);
		 * System.out.println("Nome: " + amigo.getNome());
		 * System.out.println("Celular: " + amigo.getCelular());
		 * }
		 */

		int idLivros;

		idAmigo = bib.addLivro("Harry Potter I", "J.K", 30, Disponibilidade.DISPONIVEL);
		idAmigo = bib.addLivro("A hora da estrela", "Clarice Lispector", 20, Disponibilidade.DISPONIVEL);

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
			System.out.println("MENU INICIAL\n");
			System.out.println("0 - sair \n1 - cadastrar livro \n2 - cadastrar amigo \n3 - emprestar");
			System.out.println("4 - devolver \n5 - listar emprestimos atuais");
			System.out.println("6 - listar historico de emprestimos de um livro \n7 - listar toda a biblioteca");
			System.out.println("8 - alterar estado \n");

			opcao = scanner.nextInt();

			switch (opcao) {
				case 0:
					System.out.println("   Obrigado por usar o sistema!");
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
				case 7:
					listarBib();
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
	}

	private static void emprestarLivro() {

		int idLivro;
		int idAmigo;

		System.out.println("\n==> Sistema de emprestimo\n");
		scanner.nextLine();

		System.out.println("   Código do livro: ");
		idLivro = scanner.nextInt();

		listarAmigos();
		System.out.println("   Código do amigo: \n");
		idAmigo = scanner.nextInt();

		emprestimos.addEmprestimo(idAmigo, idLivro, bib);
	}

	private static void devolverLivro() {

		int idLivro;

		System.out.println("\n==> Sistema de devolução\n");
		System.out.println("   Código do livro para devolução: ");
		idLivro = scanner.nextInt();

		emprestimos.Devolver(idLivro, bib);
	}

	private static void listarBib() {

		System.out.println("\n==> Listagem de livros\n");

		ArrayList<Livro> alLivros;
		float investimento = 0;

		alLivros = bib.getBiblioteca(); // Ordena de A-Z pelo titulo

		for (Livro livro : alLivros) {
			System.out.println("   Titulo: " + livro.getTitulo());
			System.out.println("   Situacao: " + livro.getDispLivro());
			System.out.println("   Preco: " + livro.getPreco() + "\n");
			investimento = investimento + livro.getPreco();
		}

		bib.setInvestimento(investimento);
		System.out.println("   Investimento da biblioteca: " + investimento + "\n");
	}

	private static void listarAmigos() {

		ArrayList<Amigo> alAmigos;

		alAmigos = amigos.getListaAmigos();

		for (Amigo amigo : alAmigos) {
			System.out.println("   Nome: " + amigo.getNome() + "Código: " + amigo.getidAmigo());
		}

	}

}
