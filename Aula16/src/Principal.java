import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		Grafo objGrafo = new Grafo(5);
		
		objGrafo.construir(false);
		
		int inicio = 0;
		int fim = 0;
		do {
			System.out.print("Digite o vértice inicial");
			inicio = leitor.nextInt();
			
			System.out.print("Digite o vértice final: ");
			fim = leitor.nextInt();
			
			objGrafo.procurarPercurso(inicio, fim);
		} while (inicio != fim);
		
		leitor.close();
	}
}