package repaso.arboles_generales.ejercicio11;

import java.util.LinkedList;
import java.util.List;

import tp1.ej8.Queue;
import tp3.ej3.GeneralTree;

public class ParcialArboles {
// version vieja, version vieja en la practica 3 ejercicio11
    public static boolean resolver(GeneralTree<Integer> arbol){ //que devuelve true si el árbol es creciente, falso sino lo es
        boolean result = true;
        Queue <GeneralTree<Integer>> queue = new Queue<GeneralTree<Integer>>();
        int cant = 0;
        int nivel = 0;
        queue.enqueue(arbol);
        queue.enqueue(null);
        GeneralTree<Integer> tree_aux = new GeneralTree<Integer>();
        while (!queue.isEmpty() && result){
            tree_aux = queue.dequeue();
            if (tree_aux != null){
                cant++;
                List<GeneralTree<Integer>> children =  tree_aux.getChildren();
                for (GeneralTree<Integer> child : children){
                    queue.enqueue(child);
                }
            } else {
                if (!queue.isEmpty()){
                    if (cant != nivel+1){
                        result = false;
                    }
                    nivel++;
                    cant = 0;
                    queue.enqueue(null);
                }
            }
        }
        return result; 
    }

    public static void main(String[] args) {
		GeneralTree<Integer> a1 = new GeneralTree<Integer>(1);
		List<GeneralTree<Integer>> children2 = new LinkedList<GeneralTree<Integer>>();
		children2.add(new GeneralTree<Integer>(22));
		//children2.add(new GeneralTree<Integer>(21));
		//children2.add(new GeneralTree<Integer>(23));
		GeneralTree<Integer> a2 = new GeneralTree<Integer>(2, children2);
		List<GeneralTree<Integer>> children = new LinkedList<GeneralTree<Integer>>();
		children.add(a1);
		children.add(a2);
		GeneralTree<Integer> a = new GeneralTree<Integer>(0, children);

        a.printPreOrder();
		
		System.out.println("Cumple el arbol? " + ParcialArboles.resolver(a));
	}
}
