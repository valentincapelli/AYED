package tp2.ej4;

import tp2.ej2.BinaryTree;

public class RedBinariaLlena {
	BinaryTree<Integer> ab;
	
	public RedBinariaLlena(BinaryTree<Integer> ab) {
		this.ab = ab;
	}
	
	public int retardoReenvio() {
		int max = 0;
		int sumaActual = 0;
		return this.calcularRetardo1(ab, max, sumaActual);
	}
	
	private int calcularRetardo1(BinaryTree<Integer> ab, int max, int sumaActual) {
		if (ab.isLeaf()) {
			if (sumaActual > max) {
				max = sumaActual;
			}
		}
		if (ab.hasLeftChild()) {
			this.calcularRetardo1(ab.getLeftChild(),max, sumaActual+ ab.getData());
		}
		if (ab.hasRightChild()) {
			this.calcularRetardo1(ab.getRightChild(),max, sumaActual+ ab.getData());
		}
		return max;	
	}
	
	public static void main(String[] args) {
		BinaryTree<Integer> ab = new BinaryTree<Integer>(40);
        BinaryTree<Integer> hijoIzquierdo = new BinaryTree<Integer>(25);
        BinaryTree<Integer> hijoDerecho = new BinaryTree<Integer>(78);
        BinaryTree<Integer> TreintaDos = new BinaryTree<Integer>(32);

        hijoIzquierdo.addLeftChild(new BinaryTree<Integer>(10));
        hijoIzquierdo.addRightChild(TreintaDos);
        TreintaDos.addRightChild(new BinaryTree <Integer>(66));

        hijoDerecho.addLeftChild(new BinaryTree<Integer>(20));
        hijoDerecho.addRightChild(new BinaryTree<Integer>(50));

        ab.addLeftChild(hijoIzquierdo);
        ab.addRightChild(hijoDerecho);
        
        RedBinariaLlena rb = new RedBinariaLlena(ab);
        
        System.out.println(rb.retardoReenvio());
	}
}
