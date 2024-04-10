package tp2.ej5;

import tp1.ej8.Queue;
import tp2.ej2.BinaryTree;

public class ProfundidadDeArbolBinario2 {
private BinaryTree <Integer> arbol;
    
    public ProfundidadDeArbolBinario2 (BinaryTree <Integer> arbol){
    this.arbol = arbol;
    }

    public BinaryTree<Integer> getArbol() {
        return arbol;
    }

    public void setArbol(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }
    

    public int SumaElementosArbolBinario (int p){
        int suma = 0;
        int pro = 0;
        BinaryTree <Integer> aux = new BinaryTree <Integer> ();
        Queue <BinaryTree<Integer>> cola = new Queue <BinaryTree<Integer>> ();
        System.out.println("PARADA 5");
        cola.enqueue(this.getArbol());
        System.out.println("PARADA 6");
        cola.enqueue(null);
        System.out.println("PARADA 7");
        while ((!cola.isEmpty()) && (pro < p)){
            pro++;
            aux = cola.dequeue();
            System.out.println("PARADA 8");
            while ((!cola.isEmpty()) && (aux != null)){
                if (aux.hasLeftChild())
                    cola.enqueue(aux.getLeftChild());
                if (aux.hasRightChild())
                    cola.enqueue(aux.getRightChild()); 
                aux = cola.dequeue();
                System.out.println("PARADA 9");
            }
            cola.enqueue(null);
        }
        aux = cola.dequeue();
        suma = suma + aux.getData();
        System.out.println("PARADA 10");
        while ((aux != null)){
            System.out.println("PARADA 11");
            aux = cola.dequeue();
            suma = suma + aux.getData();
        }
        System.out.println("PARADA 12");
        return suma;
    }

	

	public static void main(String[] args) {
		BinaryTree<Integer> arbol = new BinaryTree<Integer>(40);
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
        System.out.println(prof.sumaElementosProfundidad(3));
	}
}
