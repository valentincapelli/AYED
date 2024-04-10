package tp2.ej2;

public class ej2 {

	public static void main(String[] args) {
		BinaryTree<Integer> ab = new BinaryTree<Integer>(40);
		
		BinaryTree<Integer> hijoIzquierdo = new BinaryTree<Integer>(25);
		hijoIzquierdo.addLeftChild(new BinaryTree<Integer>(10));
		hijoIzquierdo.addRightChild(new BinaryTree<Integer>(32));
		
		BinaryTree<Integer> hijoDerecho= new BinaryTree<Integer>(78);
		ab.addLeftChild(hijoIzquierdo);
		ab.addRightChild(hijoDerecho);
		
		hijoDerecho.addLeftChild(new BinaryTree<Integer>(12));
		hijoDerecho.addRightChild(new BinaryTree<Integer>(30));
		
		
		int hojas = ab.contarHojas();
		System.out.println("La cantidad de hojas del arbol son " + hojas);
		
		System.out.println("Arbol antes de invertirse en espejo");
		ab.printLevelTraversal();
		ab.espejo();
		System.out.println("Arbol despues de invertirse en espejo");
		ab.printLevelTraversal();
		
		System.out.println("Imprimir entre niveles");
        ab.entreNiveles(0, 3);
	}

}
