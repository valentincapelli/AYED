package tp3.ej5;

import java.util.LinkedList;
import java.util.List;

import tp1.ej8.Queue;

public class GeneralTree<T> {
	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>();
	
	public GeneralTree() {
		
	}
	
	public GeneralTree(T data) {
		this.data = data;
	}
	
	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data); // llama al primer constructor general
		this.children = children;
	}
	
	public T getData() {
		return data;
	}
	
	public List<GeneralTree<T>> getChildren(){
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null) {
			this.children = children;
		}
	}
	
	public void addChild(GeneralTree<T> child) {
		getChildren().add(child);
	}
	
	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return children!= null && !children.isEmpty();
	}
	
	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren()) {
			getChildren().remove(child);
		}
	}
	
	public boolean isEmpty() {
		return data==null && !this.hasChildren();
	}
	
	public void printPreOrder() {
		System.out.println(getData());
		List<GeneralTree<T>> children = this.getChildren();
		for (GeneralTree<T> child: children) {
		    child.printPreOrder();
		}
	}
	
	public List<T> preOrder() {
		 List<T> L = new LinkedList<T>();
		 this.preOrder(L);
		 return L;
	}
    private void preOrder(List<T> L) {
		 L.add(this.getData());
		 List<GeneralTree<T>> children = this.getChildren();
		 for (GeneralTree<T> child: children) {
			 child.preOrder(L);
		 }
	}
    public int altura() {
    	if (this.isLeaf()) {
    		return 0;
    	}
    	int height,maxHeight = 0;
    	List<GeneralTree<T>> children = this.getChildren();
    	for (GeneralTree<T> child: children) {
    		height = child.altura()+1;
    		maxHeight = Math.max(maxHeight, height);
    	}
    	return maxHeight;
    }
    
    public int nivel(T dato) {
    	int Level = 0;
    	int result = -1;
    	boolean encontre = false;
    	GeneralTree<T> tree_aux;
    	Queue<GeneralTree<T>> queue = new Queue<GeneralTree<T>>();
    	queue.enqueue(this);
    	queue.enqueue(null);
    	while (!queue.isEmpty() && !encontre) {
    	     tree_aux = queue.dequeue();
    		 if (tree_aux != null) {
    			 if (tree_aux.getData() == dato) {
    				 result = Level;
    				 encontre = true;
    			 } else {
    				 List<GeneralTree<T>> children = tree_aux.getChildren();
    				 for (GeneralTree<T> child: children) {
    					 queue.enqueue(child);
    				 }
        		 }
    		 }else {
    			 if (!queue.isEmpty()) {
    				 queue.enqueue(null);
    				 Level++;
    			 }
    		 }
    	}
    	System.out.println("El dato no se encuentra en el arbol");
    	return result;
    }
    public int ancho() {
    	GeneralTree<T> tree_aux;
    	Queue<GeneralTree<T>> queue = new Queue<GeneralTree<T>>();
    	queue.enqueue(this);
    	queue.enqueue(null);
    	int cant = 0;
    	int max = 0;
    	while (!queue.isEmpty()) {
    	     tree_aux = queue.dequeue();
    		 if (tree_aux != null) {
    			 cant = cant + tree_aux.getChildren().size();
    		      List<GeneralTree<T>> children = tree_aux.getChildren();
    			  for (GeneralTree<T> child: children) {
    				  queue.enqueue(child);
    			  }
    		 }else {
    			 if (!queue.isEmpty()) {
    				 queue.enqueue(null);
    				 if (cant > max) max = cant;
    				 cant = 0;
    			 }
    		 }
    	}
    	return max;
    }
    
    public boolean esAncestro(T a, T b) {
    	GeneralTree<T> subArbol = buscarNodo(this,a);
    	boolean result = false;
    	if (subArbol != null) 
    		result = (buscarNodo(subArbol,b) != null);
    	return result;
    }
    
    private GeneralTree<T> buscarNodo(GeneralTree<T> arbol , T dato) { 
    	GeneralTree<T> subArbol = null;
    	if (arbol.getData().equals(dato)) {
    		subArbol = arbol;
    	}else {
    		if (!arbol.isLeaf()) {
    			List<GeneralTree<T>> children = arbol.getChildren();
    			for (GeneralTree<T> child: children) {
    				subArbol = buscarNodo(child,dato);
    				if (subArbol != null) return subArbol; // break;
    			}
    		}
    	}
    	return subArbol;
    		    		
    }
    
    	/* ppublic int altura(T dato) { FORMA DE HACER ALTURA POR NIVELES
    	int Level = 0;
    	int result;
    	GeneralTree<T> tree_aux;
    	Queue<GeneralTree<T>> queue = new Queue<GeneralTree<T>>();
    	queue.enqueue(this);
    	queue.enqueue(null);
    	while (!queue.isEmpty()) {
    		 tree_aux = queue.dequeue();
    		 if (tree_aux != null) {
    			 for (GeneralTree<T> child: tree_aux.getChildren()) {
        			 queue.enqueue(child);
        		 }
    		 } else {
    			 if (!queue.isEmpty()) {
    				 queue.enqueue(null);
    				 Level++;
    			 }
    		 }
    		 return Level;
    	}
    }
    	  
    	  ejercicio 5
    	   primero buscar el ancestro, una vez que lo encontre busco si se encuentra el dato dentro del subarbol del ancestro
    	   un metodo que haga la busqueda que recibe un arbol y un dato, retorna dato si lo encuentra y si no devuelve null
    	 */	
    
}