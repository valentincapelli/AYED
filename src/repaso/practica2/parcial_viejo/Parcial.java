package repaso.practica2.parcial_viejo;

import tp2.ej2.BinaryTree;

public class Parcial {
    BinaryTree<Integer> tree;
    
    public boolean resolver(int k){
        boolean ok = false;
        if (!this.tree.isEmpty())
            ok = recursion(this.tree, k, 0);
        return ok;
    }
    private boolean recursion(BinaryTree<Integer> tree, int k ,int suma){
        boolean cumple = true;
        suma += tree.getData();
        if (tree.isLeaf()){
            if (suma != k)
                cumple = false;
        }
        else{
            if (tree.hasLeftChild())
                cumple = recursion(tree.getLeftChild(), k, suma);
            if (tree.hasRightChild() && cumple)
                cumple = recursion(tree.getRightChild(), k, suma); 
        }
        return cumple;
    }
}
