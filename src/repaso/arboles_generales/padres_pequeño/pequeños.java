package repaso.arboles_generales.padres_pequeño;

import java.util.LinkedList;
import java.util.List;

import tp3.ej1.GeneralTree;


public class pequeños {
	GeneralTree<Integer> arbol;

	public pequeños(GeneralTree<Integer> arbol){
        this.arbol = arbol;
    }

    public List<GeneralTree<Integer>> arboles_pequeños(){
        List<GeneralTree<Integer>> listaArboles = new LinkedList<GeneralTree<Integer>>();
        if (!this.arbol.isEmpty()){
            devolverLista(this.arbol, listaArboles);
        }
        return listaArboles;
    }

    private void devolverLista(GeneralTree<Integer> arbol, List<GeneralTree<Integer>> listaArboles){
        int padre = arbol.getData();
        int suma = 0;
        List<GeneralTree<Integer>> children = arbol.getChildren();
        for(GeneralTree<Integer> child : children){
            suma += child.getData();
            devolverLista(child, listaArboles);
        }
        if (padre < suma){
            listaArboles.add(arbol);
        }
    }


	public static void main(String[] args) {
		
		GeneralTree<Integer> a1 = new GeneralTree<Integer>(1);
		List<GeneralTree<Integer>> children2 = new LinkedList<GeneralTree<Integer>>();
		children2.add(new GeneralTree<Integer>(21));
		children2.add(new GeneralTree<Integer>(23));
		children2.add(new GeneralTree<Integer>(25));
		GeneralTree<Integer> a2 = new GeneralTree<Integer>(2, children2);
		List<GeneralTree<Integer>> children3 = new LinkedList<GeneralTree<Integer>>();
		children3.add(new GeneralTree<Integer>(31));
		children3.add(new GeneralTree<Integer>(33));
		GeneralTree<Integer> a3 = new GeneralTree<Integer>(3, children3);
		List<GeneralTree<Integer>> children = new LinkedList<GeneralTree<Integer>>();
		children.add(a1);
		children.add(a2);
		children.add(a3);
		GeneralTree<Integer> a = new GeneralTree<Integer>(0, children);
		
		pequeños p = new pequeños(a);
        List<GeneralTree<Integer>> list = p.arboles_pequeños();
        for (GeneralTree<Integer> i : list){
            System.out.println(i.getData());
        }

    }
}
