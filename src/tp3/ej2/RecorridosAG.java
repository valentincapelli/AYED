package tp3.ej2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tp1.ej8.Queue;
import tp3.ej1.*;

public class RecorridosAG {
	public List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree <Integer> a,Integer n){
		List<Integer> L = new LinkedList<Integer>();
		if ((a != null) && (!a.isEmpty())) {
			this.recorridoAux(a,n,L);
		}
		return L;
	}
	
	private void recorridoAux(GeneralTree <Integer> a,Integer n, List<Integer> L ){
		if ((a.getData() %2 != 0) && (a.getData() > n)){
			L.add(a.getData());
		}
		List<GeneralTree<Integer>> children = a.getChildren();
		for (GeneralTree<Integer> child: children) {
			 recorridoAux(child,n,L);
		}
	}
	
	public List<Integer> numerosImparesMayoresQuePosOrden (GeneralTree <Integer> a,Integer n){
		List<Integer> L = new LinkedList<Integer>();
		if ((a != null) && (!a.isEmpty())) {
			this.recorridoAuxPos(a,n,L);
		}
		return L;
	}
	
	private void recorridoAuxPos(GeneralTree <Integer> a,Integer n, List<Integer> L ){
		List<GeneralTree<Integer>> children = a.getChildren();
		for (GeneralTree<Integer> child: children) {
			 recorridoAuxPos(child,n,L);
		}
		if ((a.getData() %2 != 0) && (a.getData() > n)){
			L.add(a.getData());
		}
	}
	
	public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a,Integer n){
		List<Integer> L = new LinkedList<Integer>();
		if ((a != null) && (!a.isEmpty())) {
			this.recorridoAuxIn(a,n,L);
		}
		return L;
	}
	
	private void recorridoAuxIn(GeneralTree <Integer> a,Integer n, List<Integer> L ){
		List<GeneralTree<Integer>> children = a.getChildren();
		if (a.hasChildren()) {
			recorridoAuxIn(children.get(0),n,L);
		}
		if ((a.getData() %2 != 0) && (a.getData() > n)){
			L.add(a.getData());
		}
		for (int i=1;i<children.size();i++) {
			 recorridoAuxIn(children.get(i),n,L);
		}
	}
	
	public List<Integer> numerosImparesMayoresQuePorNiveles (GeneralTree <Integer> a,Integer n){
		List<Integer> L = new LinkedList();
		if (a != null && !a.isEmpty()) {
			GeneralTree<Integer> tree_aux;
			Queue<GeneralTree<Integer>> queue = new Queue<GeneralTree<Integer>>();
			queue.enqueue(a);
			while (!queue.isEmpty()) {
				tree_aux = queue.dequeue();
				if ((tree_aux.getData() % 2 != 0) && (tree_aux.getData() > n)) {
					L.add(tree_aux.getData());
				}
				List<GeneralTree<Integer>> children = tree_aux.getChildren();
				for (GeneralTree<Integer> child: children) {
					queue.enqueue(child);
				}
			}
		}
		return L;
	}
}
