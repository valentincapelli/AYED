package tp2.ej5;

import tp1.ej8.Queue;
import tp2.ej2.BinaryTree;

public class ProfundidadDeArbolBinario {
	private BinaryTree<Integer> ab;
	
	public ProfundidadDeArbolBinario (BinaryTree<Integer> ab) {
		this.ab = ab;
	}
	
	public int sumaElementosProfundidad(int profundidad) {
		if (ab.isEmpty()) {
			System.out.println("El arbol esta vacio");
			return 0;
		}
		else {
			BinaryTree<Integer> aux = null;
			Queue<BinaryTree<Integer>> cola = new Queue<BinaryTree<Integer>>();
			cola.enqueue(ab);
			cola.enqueue(null);
			int Level = 0;
			int sum = 0;
			while (!cola.isEmpty() && Level <= profundidad) {
				aux = cola.dequeue();
				if (aux != null) {
					if (Level == profundidad) {
						sum = sum + aux.getData();
					}
					if (aux.hasLeftChild()) {
						cola.enqueue(aux.getLeftChild());
					}
					if (aux.hasRightChild()) {
						cola.enqueue(aux.getRightChild());
					}
				} else if (!cola.isEmpty()) {
					System.out.println();
					cola.enqueue(null);
					Level++;
				}
			}
			return sum;
		}
	}
	public static void main(String[] args) {
		BinaryTree<Integer> arbol = new BinaryTree<Integer>(41);
        BinaryTree<Integer> hijoIzquierdo = new BinaryTree<Integer>(25);
        BinaryTree<Integer> hijoDerecho = new BinaryTree<Integer>(78);
        BinaryTree<Integer> TreintaDos = new BinaryTree<Integer>(32);

        hijoIzquierdo.addLeftChild(new BinaryTree<Integer>(10));
        hijoIzquierdo.addRightChild(TreintaDos);
        TreintaDos.addRightChild(new BinaryTree <Integer>(66));

        hijoDerecho.addLeftChild(new BinaryTree<Integer>(20));
        hijoDerecho.addRightChild(new BinaryTree<Integer>(50));

        arbol.addLeftChild(hijoIzquierdo);
        arbol.addRightChild(hijoDerecho);
        
        ProfundidadDeArbolBinario prof = new ProfundidadDeArbolBinario(arbol);
        System.out.println(prof.sumaElementosProfundidad(0));
	}
}