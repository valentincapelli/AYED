package repaso.practica3.ejercicio9;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tp3.ej1.GeneralTree;

public class ParcialArboles {

    public static boolean esDeSeleccion (GeneralTree<Integer> arbol){
        boolean result = false;
        if (!arbol.isEmpty())
            result = recorrerArbol(arbol);
        return result;
    }

    private static boolean recorrerArbol(GeneralTree<Integer> arbol){
        Integer min = 9999;
        if (!arbol.isLeaf()){
            List<GeneralTree<Integer>> children = arbol.getChildren();
            Iterator <GeneralTree<Integer>> it = children.iterator();
            boolean result = true;
            while (it.hasNext() && result){
                GeneralTree<Integer> child = it.next();
                result = recorrerArbol(child);
                if (child.getData() < min)
                    min = child.getData();
            }
            return (result && min == arbol.getData());
        } 
        else {
            return true;
        }
    }
    public static void main(String[] args) {
		
		GeneralTree<Integer> a1 = new GeneralTree<Integer>(1);
		List<GeneralTree<Integer>> children2 = new LinkedList<GeneralTree<Integer>>();
		children2.add(new GeneralTree<Integer>(21));
		children2.add(new GeneralTree<Integer>(23));
		children2.add(new GeneralTree<Integer>(25));
		GeneralTree<Integer> a2 = new GeneralTree<Integer>(21, children2);
		List<GeneralTree<Integer>> children3 = new LinkedList<GeneralTree<Integer>>();
		children3.add(new GeneralTree<Integer>(31));
		children3.add(new GeneralTree<Integer>(33));
		GeneralTree<Integer> a3 = new GeneralTree<Integer>(31, children3);
		List<GeneralTree<Integer>> children = new LinkedList<GeneralTree<Integer>>();
		children.add(a1);
		children.add(a2);
		children.add(a3);
		GeneralTree<Integer> a = new GeneralTree<Integer>(1, children);

        System.out.println(esDeSeleccion(a));
    }
}
