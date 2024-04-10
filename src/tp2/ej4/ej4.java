package tp2.ej4;
import tp2.ej2.BinaryTree;
public class ej4 {

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
        
	}

}
