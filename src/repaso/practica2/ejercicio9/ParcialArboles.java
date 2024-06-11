package repaso.practica2.ejercicio9;

import tp2.ej2.BinaryTree;

public class ParcialArboles {

    /*  El método recibe un árbol binario de enteros y devuelve un nuevo árbol que contenga en cada
    nodo dos tipos de información: 
    ● La suma de los números a lo largo del camino desde la raíz hasta el nodo actual.
    ● La diferencia entre el número almacenado en el nodo original y el número almacenado en el
    nodo padre */

    public BinaryTree<Data> sumAndDif(BinaryTree<Integer> arbol){
        BinaryTree<Data> tree = new BinaryTree<Data>();
        if (!arbol.isEmpty())
            crearArbolData(tree,arbol,0,0);
        return tree;
    }

    private void crearArbolData(BinaryTree<Data> tree, BinaryTree<Integer> arbol, int sum, int father){
        Data d = new Data(sum + arbol.getData(),arbol.getData() - father);
        tree.setData(d);
        if (arbol.hasLeftChild()){
            tree.addLeftChild(new BinaryTree<Data>());
            crearArbolData(tree.getLeftChild(), arbol.getLeftChild(), d.getSum(), arbol.getData());
        }
        if (arbol.hasRightChild()){
            tree.addRightChild(new BinaryTree<Data>());
            crearArbolData(tree.getRightChild(), arbol.getRightChild(), d.getSum(), arbol.getData());
        }
    }

    public static void main(String[] args) {
        BinaryTree<Integer> ab1 = new BinaryTree<Integer>(1);
		ab1.addLeftChild(new BinaryTree<Integer>(2));
        ab1.addRightChild(new BinaryTree<Integer>(3));
		ab1.getLeftChild().addLeftChild(new BinaryTree<Integer>(4));
        ab1.getLeftChild().addRightChild(new BinaryTree<Integer>(5));

        ParcialArboles PA = new ParcialArboles();
        BinaryTree<Data> arbolData = PA.sumAndDif(ab1);
        arbolData.printLevelTraversal();

    }
}
