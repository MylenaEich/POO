package Biblioteca;

import java.util.ArrayList;
import java.util.Collections;

import Amigo.Amigo;

public class Biblioteca {

	private String nome;
	private ArrayList<Livro> alLivros;
	private float investimento;

	// construtor cria alLivros, ArrayList que fica encapsulado na classe Biblioteca
	public Biblioteca(String nome) {
		this.nome = nome;
		this.alLivros = new ArrayList<Livro>();
		investimento = 0;
	}

	// Cadastrar livro
	public int addLivro(String titulo, String autor, float preco, Disponibilidade dispLivro) {
		int idLivro = alLivros.size() + 1;
		Livro livro = new Livro(idLivro, titulo, autor, preco, dispLivro);
		alLivros.add(livro);
		return idLivro;
	}

	public int getBibliotecaSize() {
		return alLivros.size();
	}

	// Escolhe de acordo com o ID, independendo se houve ordenamento
	public Livro getLivro(int i) {
		int j = 0;
		while (j != i) {
			j++;
		}
		return alLivros.get(j);
	}

	public ArrayList<Livro> getBiblioteca() {
		Collections.sort(alLivros);
		return alLivros;
	}

	public void setInvestimento(float investimento) {
		this.investimento = investimento;
	}
	// demais m�todos getters, setters, toString, compareTo (para ordena��o) etc
	// conforme a modelagem e encapsulamento especificados
	// mais o que estudante decidir implementar
}
