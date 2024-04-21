package tp2.ej9;

import tp2.ej2.BinaryTree;

public class ParcialArboles {

    public BinaryTree<Data> sumAndDif(BinaryTree<Integer> arbol){
        BinaryTree<Data> arbolData = new BinaryTree<Data>();
        if (!arbol.isEmpty()) 
            recorridoAux(arbol,arbolData, 0,0);
        return arbolData;
    }

    private void recorridoAux(BinaryTree<Integer> arbol, BinaryTree<Data> arbolData,int suma, int padre){
        Data data = new Data(suma + arbol.getData(),arbol.getData()-padre);
        arbolData.setData(data);

        if (arbol.hasLeftChild()) {
            arbolData.addLeftChild(new BinaryTree<Data>());
            recorridoAux(arbol.getLeftChild(),arbolData.getLeftChild(),suma + arbol.getData(),arbol.getData());
        }
        if (arbol.hasRightChild()) {
            arbolData.addRightChild(new BinaryTree<Data>());
            recorridoAux(arbol.getRightChild(),arbolData.getRightChild(),suma + arbol.getData(),arbol.getData());
        }
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

        ParcialArboles PA = new ParcialArboles();
        BinaryTree<Data> arbolData = PA.sumAndDif(ab1);
        arbolData.printLevelTraversal();

    }

}