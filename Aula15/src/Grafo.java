import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Grafo {
	// Propriedades
	private boolean[][] matrizAdjacencia = null;
	
	// Método construtor
	public Grafo(int qtdVertices) {
		matrizAdjacencia = new boolean[qtdVertices][qtdVertices];
	}
	
	// Métodos da classe
	public void construir(boolean aleatorio) {
		BufferedReader leitor = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			for (int i = 0; i < (matrizAdjacencia.length - 1) ; i++) {
				for (int j = (i+1) ; j < matrizAdjacencia.length ; j++) {
					
					boolean adjacencia = false;
					
					if (aleatorio) {
						adjacencia =((int) (2 * Math.random()) == 0);
					} else {
						System.out.print("Digite <S> se o vértice " + i + " for adjacente ao vértice " + j + ": ");
						adjacencia = leitor.readLine().equalsIgnoreCase("S");
					}
					matrizAdjacencia[i][j] = adjacencia;
					matrizAdjacencia[j][i] = adjacencia;
				}
			}
		} catch(Exception e) {}
	}
	
	public void imprimir() {
		System.out.println("Vértice \t Vizinhança");
		for(int i = 0; i < matrizAdjacencia.length ; i++) {
			System.out.print(i + "\t\t");
			for(int j = 0; j < matrizAdjacencia.length; j++) {
				if(matrizAdjacencia[i][j]) {
					System.out.print(j + ", ");
				}
			}
			System.out.println();
		}
	}
	
	public void descobrirMaiorGrau() {
		int verticeMaiorGrau = 0;
		int valorMaiorGrau = 0;
		
		for(int i = 0; i < matrizAdjacencia.length; i++) {
			int contadorAmigos = 0;
			for(int j = 0; j < matrizAdjacencia.length; j++) {
				if(matrizAdjacencia[i][j]) {
					contadorAmigos++;
				}
			}
			if(contadorAmigos > valorMaiorGrau) {
				valorMaiorGrau = contadorAmigos;
				verticeMaiorGrau = i;
			}
		}
		System.out.println("O vértice mais popular é o "+ verticeMaiorGrau +" e o tamanho de sua vizinhança é " + valorMaiorGrau);
		
	}
}