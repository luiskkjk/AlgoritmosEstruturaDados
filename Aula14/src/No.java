public class No {
	// Propriedades
	private int chaves[] = null;
	private No filhos[] = null;
	private boolean folha = true;
	private int  qtdChaves = 0;
	
	// Métodos construtor cheio da classe
	public No(int tamanhoDoNo) {
		chaves = new int[tamanhoDoNo];
		filhos = new No[tamanhoDoNo + 1];
	}

	// Métodos acesso
	public int[] getChaves() {
		return chaves;
	}

	public void setChaves(int[] chaves) {
		this.chaves = chaves;
	}

	public No[] getFilhos() {
		return filhos;
	}

	public void setFilhos(No[] filhos) {
		this.filhos = filhos;
	}

	public boolean isFolha() {
		return folha;
	}

	public void setFolha(boolean folha) {
		this.folha = folha;
	}

	public int getQtdChaves() {
		return qtdChaves;
	}

	public void setQtdChaves(int qtdChaves) {
		this.qtdChaves = qtdChaves;
	}	
	
	// Métodos da classe
	public int getChave(int indice) {
		return chaves[indice];
	}
	
	public void setChave(int indice, int valor) {
		chaves[indice] = valor;
	}
	
	public No getFilho(int indice) {
		return filhos[indice];
	}
	
	public void setFilho(int indice, No valor) {
		filhos[indice] = valor;
	}
	
	public boolean isCheia() {
		return (getQtdChaves() == chaves.length);
	}
	
	public void inserir(int numero, No filho) {
		int lugarCerto = 0;
		boolean encontrei = false;
		
		 for(int i = 0; i < getQtdChaves() ; i++) {	// Procurando lugar certo de inserir o número no nó
			 if(chaves[i] > numero) {
				 lugarCerto = i;
				 encontrei = true;
				 break;
			 }
		 }
		 
		 if(! encontrei) {	// Serve para quando a folha for completamente vazia
			 lugarCerto = qtdChaves;	// Serve para quando o número que quero inserir é o maior da folha
		 }
		 
		 // Laço invertido de trás para frente empurrando as chaves
		 for(int i = (qtdChaves - 1) ; i >= lugarCerto ; i--) {
			 chaves[i+1] = chaves[i];
			 filhos[i+2] = filhos[i+1]; 
		 }
		 
		 chaves[lugarCerto] = numero;
		 filhos[lugarCerto + 1] = filho;
		 
		 qtdChaves++;
	} 
	
	public String imprimirChaves() {
		String retorno = "";
		
		for(int i = 0; i < qtdChaves ; i++) {
			retorno += (", " + chaves[i]);
		}
		if(retorno.length() > 0) retorno = retorno.substring(2);
		
		return retorno;
	}
}