package tp2.ej5;

import tp1.ej8.Queue;
import tp2.ej2.BinaryTree;

public class ProfundidadDeArbolBinario {
	BinaryTree<Integer> ab;
	
	public ProfundidadDeArbolBinario (BinaryTree<Integer> ab) {
		this.ab = ab;
	}
	
	public Integer sumaElementosProfundidad(int profundidad) {
		if (ab.isEmpty()) {
			System.out.println("El arbol esta vacio");
			return 0;
		}
		else {
			BinaryTree<Integer> ab = null;
			Queue<BinaryTree<Integer>> cola = new Queue<BinaryTree<Integer>>();
			int L = 0;
			int suma = 0;
			cola.enqueue(this.ab);
			cola.enqueue(null);
			while (!cola.isEmpty()) {
				ab = cola.dequeue();
				if (ab != null) {
					if (L == profundidad) {
						System.out.print(ab.getData());
						suma = suma + ab.getData();
					}
					else break;
					if (ab.hasLeftChild()) {
						cola.enqueue(ab.getLeftChild());
					}
					if (ab.hasRightChild()) {
						cola.enqueue(ab.getRightChild());
					}
				} else if (!cola.isEmpty()) {
					System.out.println();
					cola.enqueue(null);
					L++;
				}
			}
			return suma;
		}
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
        
        ProfundidadDeArbolBinario prof = new ProfundidadDeArbolBinario(ab);
        System.out.println(prof.sumaElementosProfundidad(2));
	}
}