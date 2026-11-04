public class No {
	// Propriedades
	private int numero = 0;
	private No esquerda = null;
	private No direta = null;
	private int altura = 0;
	
	// Métodos construtores
	public No(int numero, No esquerda, No direta, int altura) {
		super();
		this.numero = numero;
		this.esquerda = esquerda;
		this.direta = direta;
		this.altura = altura;
	}

	public No() {
		super();
	}

	// Métodos acesso
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public No getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(No esquerda) {
		this.esquerda = esquerda;
	}

	public No getDireta() {
		return direta;
	}

	public void setDireta(No direta) {
		this.direta = direta;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}
}
