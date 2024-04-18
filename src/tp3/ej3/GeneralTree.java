package tp3.ej3;

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


}
