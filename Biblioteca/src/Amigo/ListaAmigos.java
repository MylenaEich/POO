package Amigo;

import java.util.ArrayList;
import java.util.Collections;

public class ListaAmigos {

	private ArrayList<Amigo> alAmigos;
	private static Amigo amigo;

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
	public int getIdAmigo(String nome){
		return amigo.getidAmigo();
	}

	public Amigo getAmigo(int i) {
		return alAmigos.get(i-1);
	}

	public ArrayList<Amigo> getListaAmigos() {
		Collections.sort(alAmigos);
		return alAmigos;
	}
	// demais m�todos getters, setters etc necess�rios
	// toString

}
