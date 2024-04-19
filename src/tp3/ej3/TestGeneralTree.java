package tp3.ej3;

import java.util.LinkedList;
import java.util.List;

import tp1.ej8.Queue;

public class TestGeneralTree {
	
	public List<String> traversalLevel(GeneralTree<String> tree) {

    	List<String> result = new LinkedList<String>();
    	GeneralTree<String> tree_aux;
    	Queue<GeneralTree<String>> queue = new Queue<GeneralTree<String>>();
    	queue.enqueue(tree);
    	while (!queue.isEmpty()) {
    		tree_aux = queue.dequeue();
    		result.add(tree_aux.getData());
    		List<GeneralTree<String>> children = tree_aux.getChildren();
    		for (GeneralTree<String> child: children) {
    				queue.enqueue(child);
    		}
    	}
    	return result;
    }

	public static void main(String[] args) {
		GeneralTree<String> a1 = new GeneralTree<String>("1");
		List<GeneralTree<String>> children2 = new LinkedList<GeneralTree<String>>();
		children2.add(new GeneralTree<String>("21"));
		children2.add(new GeneralTree<String>("22"));
		children2.add(new GeneralTree<String>("23"));
		GeneralTree<String> a2 = new GeneralTree<String>("2", children2);
		List<GeneralTree<String>> children3 = new LinkedList<GeneralTree<String>>();
		children3.add(new GeneralTree<String>("31"));
		children3.add(new GeneralTree<String>("32"));
		GeneralTree<String> a3 = new GeneralTree<String>("3", children3);
		List<GeneralTree<String>> children = new LinkedList<GeneralTree<String>>();
		children.add(a1);
		children.add(a2);
		children.add(a3);
		GeneralTree<String> a = new GeneralTree<String>("0", children);
		System.out.println("Datos del Arbol: ");
		a.printPreOrder();
		
		System.out.println("El dato ingresado se encuentra en el nivel " +a.nivel("32"));
		}
	}

