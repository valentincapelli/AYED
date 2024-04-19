package tp2.ej7;

import tp2.ej2.BinaryTree;

public class ParcialArboles {
    BinaryTree<Integer> ab;
    
    public ParcialArboles (BinaryTree <Integer> ab) {
		this.ab = ab;
	}
    
    public boolean isLeftTree (int num) {
    	boolean encontre = false;
    	if (ab != null) {
    		BinaryTree<Integer> subArbol = buscarArbol(ab,num);
    		if (subArbol != null) {
    			encontre = procesarSubArbol(subArbol);
    		}
    	}
    	return encontre;
    	
    }
    private BinaryTree<Integer> buscarArbol(BinaryTree<Integer> ab, int num) {
    	 if (ab.getData() == num) 
    		 return ab;
    	 
    	 BinaryTree<Integer> ret = null;
    	 if (ab.hasLeftChild())
    		 ret = buscarArbol(ab.getLeftChild(),num);
    	 if (ab.hasRightChild() && ret == null) 
    		 ret = buscarArbol(ab.getRightChild(),num);
    	 
    	 return ret;

    }
    
	 private boolean procesarSubArbol(BinaryTree<Integer> ab) {
		 int izq,der;
		 if (ab.hasLeftChild())
			 izq = contarHijosUnicos(ab.getLeftChild());
	     else
	    	 izq = -1;
	     if (ab.hasRightChild())
	         der = contarHijosUnicos(ab.getRightChild());
	     else
	         der = -1;
	     System.out.println("izquierda " + izq + " derecha " + der);
	     
	     return izq > der;
	 }
	 
	 private int contarHijosUnicos(BinaryTree<Integer> ab) {
		 int cantHijos = 0;
		 
		 if (ab.hasLeftChild()) cantHijos += contarHijosUnicos(ab.getLeftChild());
		 
	     if (ab.hasRightChild()) cantHijos += contarHijosUnicos(ab.getRightChild());

	     if ((ab.hasLeftChild() && !ab.hasRightChild()) || (!ab.hasLeftChild() && ab.hasRightChild()))
	    	 cantHijos++;
	     
	     return cantHijos;
	  }
	
	public static void main(String[] args) {
		BinaryTree<Integer> ab = new BinaryTree<Integer>(1);
		BinaryTree<Integer> hijoIzquierdo = new BinaryTree<Integer>(4);
		BinaryTree<Integer> hijoDerecho = new BinaryTree<Integer>(7);
		BinaryTree<Integer> TreintaDos = new BinaryTree<Integer>(10);
		
		hijoIzquierdo.addLeftChild(new BinaryTree<Integer>(2));
		hijoIzquierdo.addRightChild(TreintaDos);
		TreintaDos.addRightChild(new BinaryTree <Integer>(9));
		
		hijoDerecho.addLeftChild(new BinaryTree<Integer>(8));
		hijoDerecho.addRightChild(new BinaryTree<Integer>(12));
		
		ab.addLeftChild(hijoIzquierdo);
		ab.addRightChild(hijoDerecho);
		
		ParcialArboles arbol = new ParcialArboles(ab);
		
		BinaryTree<Integer> nuevoArbol = arbol.buscarArbol(ab, 10);
		
		nuevoArbol.printLevelTraversal();
		
		System.out.println("----------------------");
		
		System.out.println(arbol.isLeftTree(7));
	}
}