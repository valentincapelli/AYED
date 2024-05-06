package tp3.ej11;

import java.util.LinkedList;
import java.util.List;

import tp1.ej8.Queue;
import tp3.ej5.GeneralTree;

public class ParcialArboles {
	public static boolean resolver(GeneralTree<Integer> arbol) {
		Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
		cola.enqueue(arbol);
		cola.enqueue(null);
		int nivel = 0, cantActual = 0;
		boolean ok = true;
		while(!cola.isEmpty() && ok) {
			GeneralTree<Integer> actual = cola.dequeue();
			if(actual != null) {
				cantActual++;
				for(GeneralTree<Integer> e : actual.getChildren()) {
					cola.enqueue(e);
				}
			}else if(!cola.isEmpty()) {
				if(cantActual != nivel+1) ok = false;
				cola.enqueue(null);
				nivel ++;
				cantActual = 0;
			}
		}
		return ok;
	}
	
	public static void main(String[] args) {
		GeneralTree<Integer> a1 = new GeneralTree<Integer>(1);
		List<GeneralTree<Integer>> children2 = new LinkedList<GeneralTree<Integer>>();
		children2.add(new GeneralTree<Integer>(22));
		children2.add(new GeneralTree<Integer>(21));
		children2.add(new GeneralTree<Integer>(23));
		GeneralTree<Integer> a2 = new GeneralTree<Integer>(2, children2);
		List<GeneralTree<Integer>> children = new LinkedList<GeneralTree<Integer>>();
		children.add(a1);
		children.add(a2);
		GeneralTree<Integer> a = new GeneralTree<Integer>(0, children);
		
		System.out.println("Cumple el arbol? " + ParcialArboles.resolver(a));
	}
}