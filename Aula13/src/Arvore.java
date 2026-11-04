<<<<<<< HEAD
public class Arvore {
	// Propriedades
	private No raiz = null;
	
	// Métodos da classe
	private int getAlturaDoNo(No raiz) {
		if (raiz == null) return 0;
		return raiz.getAltura();
	}
	
	private int getMaximoEntreDoisNumeros(int a, int b) {
		return (a > b) ? a : b;
	}
	
	int getBalanco(No raiz) {
		if(raiz == null) return 0;
		return (getAlturaDoNo(raiz.getEsquerda()) - getAlturaDoNo(raiz.getDireta()));
	}
	
	private No rotacionarEsquerda(No raiz) {
		// Correção ponteiros
		No novaRaiz = raiz.getDireta();
		No temp = novaRaiz.getEsquerda();
		novaRaiz.setEsquerda(raiz);
		raiz.setDireta(temp);
		
		// Correção alturas
		raiz.setAltura(getMaximoEntreDoisNumeros(getAlturaDoNo(raiz.getEsquerda()), getAlturaDoNo(raiz.getDireta())) + 1);
		novaRaiz.setAltura(getMaximoEntreDoisNumeros(getAlturaDoNo(novaRaiz.getEsquerda()), getAlturaDoNo(novaRaiz.getDireta())) + 1);
		
		// Retorno da nova raíz
		return novaRaiz;
	}
	
	private No rotacionarDireita(No raiz) {
		// Correção ponteiros
		No novaRaiz = raiz.getEsquerda();
		No temp = novaRaiz.getDireta();
		novaRaiz.setDireta(raiz);
		raiz.setDireta(temp);
		
		// Correção alturas
		raiz.setAltura(getMaximoEntreDoisNumeros(getAlturaDoNo(raiz.getEsquerda()), getAlturaDoNo(raiz.getDireta())) + 1);
		novaRaiz.setAltura(getMaximoEntreDoisNumeros(getAlturaDoNo(novaRaiz.getEsquerda()), getAlturaDoNo(novaRaiz.getDireta())) + 1);
		
		// Retorno da nova raíz
		return novaRaiz;
	}
	
	public void inserir(int numero) {
		raiz = inserir(raiz, numero);
	}
	
	private No inserir(No raiz, int numero) {
		// Caso fácil: árvore vazia
		if (raiz == null){
			return new No(numero, null, null, 1);
		}
		
		// Caso difícil: árvore não vazia
		if (numero < raiz.getNumero()) {
			raiz.setEsquerda(inserir(raiz.getEsquerda(), numero));
		} else {
			raiz.setDireta(inserir(raiz.getDireta(), numero));
		}
		
		// Correções de balanceamento
		raiz.setAltura(1 + getMaximoEntreDoisNumeros(getAlturaDoNo(raiz.getEsquerda()), getAlturaDoNo(raiz.getDireta())));
		int balanco = getBalanco(raiz);
		
		// Inclinação à esquerda, número menor do que a esquerda
		if((balanco > 1) && (numero < raiz.getEsquerda().getNumero())) {
			raiz = rotacionarDireita(raiz);
		}
		
		// Inclinação à direta, número maior do que a direita
		if((balanco < -1) && (numero < raiz.getDireta().getNumero())) {
			raiz = rotacionarEsquerda(raiz);
		}
		
		// Inclinação à esquerda, número maior que a esquerda
		if((balanco > 1) && (numero > raiz.getEsquerda().getNumero())) {
			raiz.setEsquerda(rotacionarEsquerda(raiz.getEsquerda()));
			raiz = rotacionarDireita(raiz);
		}
		
		// Inclinação à direita, número menor que a direita
		if((balanco < -1) && (numero < raiz.getDireta().getNumero())) {
			raiz.setDireta(rotacionarDireita(raiz.getDireta()));
			raiz = rotacionarEsquerda(raiz);
		}
		
		return raiz;
	}
	
	public void imprimir() {
		imprimir(raiz, "");
	}
	
	private void imprimir(No raiz, String indentacao) {
		if(raiz == null) return;
		
		System.out.println(indentacao + raiz.getNumero());
		imprimir(raiz.getEsquerda(), indentacao + "---");
		imprimir(raiz.getDireta(), indentacao + "---");
	}
}
