import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Grafo {
	// Propriedades da csse
	boolean[][] matriz = null;
	
	// Método construtor cheio da classe
	public Grafo(int qtdVertices) {
		matriz = new boolean[qtdVertices][qtdVertices];
	}

	// Métodos da classe
	public void construir(boolean aleatorio) {
		boolean adjacencia = false;
		
		for (int i = 0; i < (matriz.length - 1); i++) {
			for (int j = (i + 1); j < matriz.length; j++) {
				if(aleatorio) { /* 20% chance de ter adjacência*/
					adjacencia = (((int) (4 * Math.random())) == 0);
				} else {
					try {
						System.out.print("Digite <S> se " + i + " for adjacente a " + j + ": " );
						adjacencia = new BufferedReader(new InputStreamReader(System.in)).readLine().equalsIgnoreCase("s");
					} catch (Exception e) {}
				}
				matriz[i][j] = adjacencia;
				matriz[j][i] = adjacencia;
			}
		}
	}
	private boolean procurarPercursoRecursivo(boolean visitado[], int inicio, int fim ) {
		if(inicio == fim) {
			return true;
		}
		
		visitado[inicio] = true;
		for (int vizinho = 0; vizinho < matriz.length; vizinho++) {
			if((matriz[inicio][vizinho]) && (! visitado[vizinho])) {
				if(procurarPercursoRecursivo(visitado, vizinho, fim)) {
					System.out.print(vizinho + "<- ");
					return true;
				}
			}
		}
		return false;
	}
	
	public void procurarPercurso(int inicio, int fim) {
		boolean encontrei = procurarPercursoRecursivo(new boolean[matriz.length], inicio, fim);
		if (encontrei) {
			System.out.println(inicio);
		} else {
			System.out.println("Não há caminho entre esses dois vértices");
		}
	}
}