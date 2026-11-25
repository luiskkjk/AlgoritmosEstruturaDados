import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Digrafo {
	// Propriedades
	private boolean[][] matriz = null;
	
	// Método construtor cheio
	public Digrafo(int qtdVertices) {
		matriz = new boolean[qtdVertices][qtdVertices];
	}
	
	// Métodos da classe
	public void construir(boolean aleatorio) {
		boolean adjacencia = false;
		
		for(int i = 0; i < matriz.length; i++) {
			for(int j = 0; j < matriz.length; j++) {
				if (aleatorio) {
					adjacencia = (((int) (5 * Math.random())) == 0);
				} else {
					BufferedReader leitor = new BufferedReader(new InputStreamReader(System.in));
					try {
						System.out.print("Digite <S> se o vértice " + i + "for adjacente ao vértice "+ j +": ");
						adjacencia = leitor.readLine().equalsIgnoreCase("s");
					} catch(Exception e) {}
				}
				
				matriz[i][j] = adjacencia;
			}
		}
	}
	
	private void ordenarTopologicoRecursivo(boolean visitado[], int vertice) {
		visitado[vertice] = true;
		
		for(int i = 0; i < matriz.length; i++) {
			if(matriz[vertice][i]) {
				if(! visitado[i]) {
					ordenarTopologicoRecursivo(visitado, i);
				}
			}
		}
		
		System.out.println(vertice + "\t");
	}
	
	public void ordenarTopologico() {
		boolean[] visitado = new boolean[matriz.length];
		
		for(int vertice = 0; vertice < matriz.length; vertice++) {
			if(! visitado[vertice]) {
				ordenarTopologicoRecursivo(visitado, vertice);
			}
		}
		
		System.out.println();
	}
}