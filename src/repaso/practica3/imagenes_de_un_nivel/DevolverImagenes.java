package repaso.practica3.imagenes_de_un_nivel;

import java.util.LinkedList;
import java.util.List;

import tp1.ej8.Queue;
import tp3.ej1.GeneralTree;

public class DevolverImagenes {

    public LinkedList<Recurso> DevolverImagenesEnNivel(GeneralTree<Recurso> tree, int nivel){
        LinkedList<Recurso> lista = new LinkedList<>();
        int Level = 0;
    	GeneralTree<Recurso> tree_aux;
    	Queue<GeneralTree<Recurso>> queue = new Queue<GeneralTree<Recurso>>();
    	queue.enqueue(tree);
    	queue.enqueue(null);
    	while (!queue.isEmpty() && Level <= nivel) {
    		tree_aux = queue.dequeue();
    		if (tree_aux != null && Level == nivel) {
                if (tree_aux.getData().esImagen())
    			    lista.add(tree_aux.getData());
                if (tree_aux.hasChildren() && nivel < nivel){
    			    List<GeneralTree<Recurso>> children = tree_aux.getChildren();
    	    	    for (GeneralTree<Recurso> child: children) {
    	    		    queue.enqueue(child);
    	    	    }
    		    }
            }
            else {
    			if (!queue.isEmpty()) {
    				  queue.enqueue(null);
    				  Level++;
    			}
    		}
    	}
        return lista;
    }
}
