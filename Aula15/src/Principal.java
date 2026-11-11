
public class Principal {
	public static void main(String[] args) {
		Grafo objGrafo = new Grafo(5);
		
		objGrafo.construir(false);
		objGrafo.imprimir();
		objGrafo.descobrirMaiorGrau();
	}
}
