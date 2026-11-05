public class Arvore {
	// Propriedades
	private No raiz = null;
	
	// Método construtor cheio
	public Arvore(int tamanhoDoNo) {
		raiz = new No(tamanhoDoNo);
	}
	
	public void inserir(int numero) {
		RetornoRecursao retorno = inserir(raiz, numero, null);
		if (retorno != null) {
			No novaRaiz = new No(raiz.getChaves().length);
			novaRaiz.setFolha(false);
			novaRaiz.setQtdChaves(1);
			novaRaiz.setChave(0, retorno.getChaveDoMeio());
			novaRaiz.setFilho(0, raiz);
			novaRaiz.setFilho(1, retorno.getFilhoDoMeio());
			raiz = novaRaiz;
		}
	}
	
	private RetornoRecursao inserir(No raiz, int numero, No filho) {
		// Caso difícil: não é uma folha, tem de procurar a folha certa para inserir
		if ((! raiz.isFolha()) && (filho == null)) {
			int indiceFilho = 0;
			boolean encontrei = false;
			for (int i = 0 ; i < raiz.getQtdChaves() ; i++) {
				if (raiz.getChave(i) > numero) {
				indiceFilho = i;
				encontrei = true;
				break;
				}
			}
			
			if (! encontrei) {
				indiceFilho = raiz.getQtdChaves();
			}
			RetornoRecursao retorno = inserir(raiz.getFilho(indiceFilho), numero, filho);
			
			if (retorno != null) {
				retorno = inserir(raiz, retorno.getChaveDoMeio(), retorno.getFilhoDoMeio());
			}
			return retorno;
		}
	
		// Caso fácil: é folha e não esta cheia
		if (! raiz.isCheia()) {
			raiz.inserir(numero, filho);
			return null;
		}
		
		// Caso difícil: é folha e esta cheia
		int indiceDoMeio = (raiz.getQtdChaves() / 2);
		int chaveDoMeio = raiz.getChave(indiceDoMeio);
		
		No novoNo = new No(raiz.getChaves().length);
		novoNo.setFolha(raiz.isFolha());
		
		int novoIndice = 0;
		for (int i = (indiceDoMeio + 1) ; i < raiz.getQtdChaves() ; i++) { // Movimentação das chaves e dos filhos para o novo nó
			novoNo.setChave(novoIndice, raiz.getChave(i));
			novoNo.setFilho(novoIndice, raiz.getFilho(i));
			raiz.setChave(i, 0);
			raiz.setFilho(i, null);
			novoIndice++;
		}
		
		novoNo.setFilho(novoIndice, raiz.getFilho(raiz.getQtdChaves()));
		raiz.setFilho(raiz.getQtdChaves(), null);
		
		raiz.setChave(indiceDoMeio, 0);
		
		novoNo.setQtdChaves(indiceDoMeio - ((raiz.getQtdChaves() % 2) == 0 ? 1 : 0));
		raiz.setQtdChaves(indiceDoMeio);
		
		if (numero < chaveDoMeio) {
			raiz.inserir(numero, filho);
		} else {
			novoNo.inserir(numero, filho);
		}
		
		return new RetornoRecursao(chaveDoMeio, novoNo);
	}
	
	public void imprimir() {
		imprimir(raiz, "");
	}
	
	private void imprimir(No raiz, String indentacao) {
		if(raiz == null) return;
		
		System.out.println(indentacao + raiz.imprimirChaves());
		
		for(No objNo : raiz.getFilhos()) {
			imprimir(objNo, indentacao + "---");
		}
	}
}