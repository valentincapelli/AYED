package repaso.arboles_binarios.ejercicio8;

import tp2.ej2.BinaryTree;

public class ParcialArboles {
    
    public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2){
		if(arbol1.getData() != arbol2.getData()) {
			return false;
		}
		boolean result = true;
		if (arbol1.hasLeftChild()) {
			if(arbol2.hasLeftChild()) {
				result = esPrefijo(arbol1.getLeftChild(), arbol2.getLeftChild()); // aqui se devuelve un valor
			}else
				return false;
			
		}
		if (arbol1.hasRightChild()) {
			if(arbol2.hasRightChild()) {
				result = result && esPrefijo(arbol1.getRightChild(), arbol2.getRightChild());  // aqui chequea que el valor que devolvio antes sea true
			}else
				return false;
			
		}
		return result;
	}

    public static void main(String[] args) {
		BinaryTree<Integer> ab1 = new BinaryTree<Integer>(1);
		ab1.addLeftChild(new BinaryTree<Integer>(2));
        ab1.addRightChild(new BinaryTree<Integer>(3));
		ab1.getLeftChild().addLeftChild(new BinaryTree<Integer>(4));
        ab1.getLeftChild().addRightChild(new BinaryTree<Integer>(5));
		
		//--------------------------------------------------------------------//
		
		BinaryTree<Integer> ab2 = new BinaryTree<Integer>(1);
		ab2.addLeftChild(new BinaryTree<Integer>(2));
        ab2.addRightChild(new BinaryTree<Integer>(3));
		ab2.getLeftChild().addLeftChild(new BinaryTree<Integer>(4));
        ab2.getLeftChild().addRightChild(new BinaryTree<Integer>(5));
		
		ParcialArboles PA = new ParcialArboles();
		
		System.out.println("El arbol 1 esta dentro del arbol 2 y son iguales: " + PA.esPrefijo(ab1, ab2));
	}

}
