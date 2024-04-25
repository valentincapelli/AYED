package tp3.ej4;

import java.util.List;

import tp1.ej8.Queue;
import tp3.ej3.GeneralTree;

public class AnalizadorArbol {
	// Utilizare recorrido por niveles
	public double devolverMaximoPromedio (GeneralTree<AreaEmpresa>arbol) {
		double prom;
    	double max = -1;
    	int suma = 0;
    	int cantNodos = 0;
    	GeneralTree<AreaEmpresa> tree_aux;
    	Queue<GeneralTree<AreaEmpresa>> queue = new Queue<GeneralTree<AreaEmpresa>>();
    	queue.enqueue(arbol);
    	queue.enqueue(null);
    	while (!queue.isEmpty()) {
    	     tree_aux = queue.dequeue();
    		 if (tree_aux != null) {
    		     suma = suma + tree_aux.getData().getTardanza(); 
    		     cantNodos++;
    		     List<GeneralTree<AreaEmpresa>> children = tree_aux.getChildren();
    			 for (GeneralTree<AreaEmpresa> child: children) {
    				 queue.enqueue(child);
    			  }
    		 }else {
    			 if (!queue.isEmpty()) {
    				 queue.enqueue(null);
    				 prom = (suma/cantNodos);
    				 if (prom > max) max = prom;
    				 suma = 0;
    				 cantNodos = 0;
    			 }
    		 }
    	}
    	return max;
	}
	
}
