package Amigo;

import java.util.ArrayList;
import java.util.Collections;

public class ListaAmigos {

	private ArrayList<Amigo> alAmigos;

	// construtor cria alAmigos, ArrayList que fica encapsulado na classe
	// ListaAmigos
	public ListaAmigos() {
		super();
		this.alAmigos = new ArrayList<Amigo>();
	}

	// Cadastrar amigo
	public int addAmigo(String nome, String celular) {
		int idAmigo = alAmigos.size() + 1;
		Amigo amigo = new Amigo(idAmigo, nome, celular);
		alAmigos.add(amigo);
		return idAmigo;
	}

	public int getListaAmigosSize() {
		return alAmigos.size();
	}

	public Amigo getAmigo(int i) {
		int j = 0;
		while (j != i) {
			j++;
		}
		return alAmigos.get(j);
	}

	public ArrayList<Amigo> getListaAmigos() {
		Collections.sort(alAmigos);
		return alAmigos;
	}
	// demais m�todos getters, setters etc necess�rios
	// toString

}
