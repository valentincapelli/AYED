package tp3.ej9;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tp3.ej5.GeneralTree;

public class ParcialArboles {
	public static boolean esDeSeleccion(GeneralTree<Integer> arbol){  //no puedo usar dos metodos con la misma firma si tienen los mismo parametros
		boolean es = false;    
		if(!arbol.isEmpty()) 
			es = metodoHelper(arbol);
		return es;    
	} 

	private static boolean metodoHelper(GeneralTree<Integer> arbol){
		if(arbol.isLeaf()) return true;
		else{
			List<GeneralTree<Integer>> child = arbol.getChildren(); //declaro lista de hijos ya que recorro con el iterador
			int min = Integer.MAX_VALUE;
			boolean ok = true;
			Iterator<GeneralTree<Integer>> iterador = child.iterator();
			while(iterador.hasNext() && ok){
				GeneralTree<Integer> a = iterador.next();
				if (a.getData() < min) min = a.getData();
				ok = metodoHelper(a);
			}
			return (ok && min == arbol.getData());
		}
	}

	public static void main(String[] args) {
		GeneralTree<Integer> a1 = new GeneralTree<Integer>(1);
		List<GeneralTree<Integer>> children2 = new LinkedList<GeneralTree<Integer>>();
		children2.add(new GeneralTree<Integer>(22));
		children2.add(new GeneralTree<Integer>(21));
		children2.add(new GeneralTree<Integer>(23));
		GeneralTree<Integer> a2 = new GeneralTree<Integer>(21, children2);
		List<GeneralTree<Integer>> children3 = new LinkedList<GeneralTree<Integer>>();
		children3.add(new GeneralTree<Integer>(31));
		children3.add(new GeneralTree<Integer>(32));
		GeneralTree<Integer> a3 = new GeneralTree<Integer>(31, children3);
		List<GeneralTree<Integer>> children = new LinkedList<GeneralTree<Integer>>();
		children.add(a1);
		children.add(a2);
		children.add(a3);
		GeneralTree<Integer> a = new GeneralTree<Integer>(1, children);
        
        System.out.println("Es de seleccion el primer arbol: " + esDeSeleccion(a));
	}    
}