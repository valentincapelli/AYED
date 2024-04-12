package tp2.ej4;

import tp2.ej2.BinaryTree;

public class RedBinariaLlena {
	BinaryTree<Integer> ab;
	
	public RedBinariaLlena(BinaryTree<Integer> ab) {
		this.ab = ab;
	}
	
	public int retardoReenvio() {
		if (ab == null | ab.isEmpty()) {
			return 0;
		} else 
			return recorridoAuxiliar(ab);
	}
	
	private int recorridoAuxiliar(BinaryTree<Integer> arbol) {
		if (arbol.isLeaf()) 
			return arbol.getData();
		else {
			int izq = 0;
			int der = 0;
			//if (arbol.hasLeftChild())
			izq = recorridoAuxiliar(arbol.getLeftChild());
			//if (arbol.hasRightChild())
			der = recorridoAuxiliar(arbol.getRightChild());
			
			return Math.max(izq, der) + arbol.getData();
		}
	}
	
	public static void main(String[] args) {
		BinaryTree<Integer> ab = new BinaryTree<Integer>(5);
        BinaryTree<Integer> hijoIzquierdo = new BinaryTree<Integer>(2);
        BinaryTree<Integer> hijoDerecho = new BinaryTree<Integer>(10);

        hijoIzquierdo.addLeftChild(new BinaryTree<Integer>(1));
        hijoIzquierdo.addRightChild(new BinaryTree<Integer>(4));
        hijoDerecho.addLeftChild(new BinaryTree<Integer>(8));
        hijoDerecho.addRightChild(new BinaryTree<Integer>(12));

        ab.addLeftChild(hijoIzquierdo);
        ab.addRightChild(hijoDerecho);
        
        RedBinariaLlena rb = new RedBinariaLlena(ab);
        
        System.out.println(rb.retardoReenvio());
	}
}
