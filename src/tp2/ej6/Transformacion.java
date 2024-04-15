package tp2.ej6;

import tp2.ej2.BinaryTree;

public class Transformacion {
	BinaryTree<Integer> arbol;
	
	public BinaryTree<Integer> suma(){
		if (arbol != null && !arbol.isEmpty()) {
			return recorridoAux(arbol);
		} else
			return null;
	}
	
	private BinaryTree<Integer> recorridoAux(BinaryTree<Integer> arbol){
		if (arbol.isLeaf()) return new BinaryTree<>(0);
		else {
			BinaryTree<Integer> izq = null;
			BinaryTree<Integer> der = null;
			int suma = 0;
			if(arbol.hasLeftChild() && !arbol.getLeftChild().isEmpty()) {
				izq = recorridoAux(arbol.getLeftChild());
			    suma += izq.getData();
			    suma += arbol.getLeftChild().getData();
			}
			if(arbol.hasRightChild() && !arbol.getRightChild().isEmpty()) {
				der = recorridoAux(arbol.getRightChild());
				suma += der.getData();
				suma += arbol.getRightChild().getData();
			}
			BinaryTree<Integer> arbolSuma = new BinaryTree<Integer>(suma);
			arbolSuma.addLeftChild(izq);
			arbolSuma.addRightChild(der);
			return arbolSuma;
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
        
        Transformacion tr = new Transformacion();
        
        tr.arbol = ab;
        tr.suma().printLevelTraversal();
	}
}
