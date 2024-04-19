package tp2.ej8;

import tp2.ej2.BinaryTree;

public class ParcialArboles {
	public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2){
		if(arbol1.getData() != arbol2.getData()) {
			return false;
		}
		boolean result = true;
		if (arbol1.hasLeftChild()) {
			if(arbol2.hasLeftChild()) {
				result = result && esPrefijo(arbol1.getLeftChild(), arbol2.getLeftChild());
			}else
				return false;
			
		}
		if (arbol1.hasRightChild()) {
			if(arbol2.hasRightChild()) {
				result = result && esPrefijo(arbol1.getRightChild(), arbol2.getRightChild());
			}else
				return false;
			
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		BinaryTree<Integer> ab1 = new BinaryTree<Integer>(1);
		BinaryTree<Integer> hijoIzquierdo = new BinaryTree<Integer>(4);
		BinaryTree<Integer> hijoDerecho = new BinaryTree<Integer>(7);
		
		hijoIzquierdo.addLeftChild(new BinaryTree<Integer>(2));
		hijoIzquierdo.addRightChild(new BinaryTree<Integer>(3));

		
		hijoDerecho.addLeftChild(new BinaryTree<Integer>(8));
		hijoDerecho.addRightChild(new BinaryTree<Integer>(9));
		
		ab1.addLeftChild(hijoIzquierdo);
		ab1.addRightChild(hijoDerecho);
		
		/////////////////////////////////////
		
		BinaryTree<Integer> ab2 = new BinaryTree<Integer>(1);
		BinaryTree<Integer> hijoIzquierdo2 = new BinaryTree<Integer>(4);
		BinaryTree<Integer> hijoDerecho2 = new BinaryTree<Integer>(7);
		
		hijoIzquierdo.addLeftChild(new BinaryTree<Integer>(2));
		hijoIzquierdo.addRightChild(new BinaryTree<Integer>(3));
		
		hijoDerecho.addLeftChild(new BinaryTree<Integer>(8));
		hijoDerecho.addRightChild(new BinaryTree<Integer>(9));
		
		ab2.addLeftChild(hijoIzquierdo);
		ab2.addRightChild(hijoDerecho);
		
		ParcialArboles PA = new ParcialArboles();
		
		System.out.println("El arbol 1 esta dentro del arbol 2 y sin iguales: " + PA.esPrefijo(ab1, ab2));
	}
}