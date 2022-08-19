package Amigo;

public class Amigo implements Comparable<Amigo> {

	private int idAmigo;
	private String nome;
	private String celular;

	public Amigo(int idAmigo, String nome, String celular) {
		super();
		this.idAmigo = idAmigo;
		this.nome = nome;
		this.celular = celular;
	}

	public int getidAmigo() {
		return idAmigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nomeAmigo) {
		this.nome = nomeAmigo;
	}

	public String getCelular() {
		return celular;
	}

	@Override
	public String toString() {
		return "Amigo [idAmigo =" + idAmigo + ", nome =" + nome + "]";
	}

	@Override
	public int compareTo(Amigo amigo) {
		return this.nome.toUpperCase().compareTo(amigo.getNome().toUpperCase());
	}

}
