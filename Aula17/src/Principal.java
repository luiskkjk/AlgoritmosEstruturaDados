public class Principal {
	public static void main(String[] args) {
		Digrafo objDigrafo = new Digrafo(1000);
		
		objDigrafo.construir(false);
		
		objDigrafo.ordenarTopologico();
	}
}
