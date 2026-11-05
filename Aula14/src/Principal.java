public class Principal {
	public static void main(String[] args) {
		Arvore objArvore = new Arvore(5);
		
		for(int i = 0; i < 30; i++) {
			objArvore.inserir((int) (20*Math.random()));
		}
		
		objArvore.imprimir();
	}
}
