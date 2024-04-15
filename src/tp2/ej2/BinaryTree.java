package tp2.ej2;
import tp1.ej8.Queue;
public class BinaryTree <T> {
	
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	
	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	@Override
	public String toString() {
		return this.getData().toString();
	}

	public  int contarHojas() {
		if (this.isEmpty()){
			return 0;
		}
		if (this.isLeaf()){
			return 1;
		}
		else { 
			int hojas = 0;
			if (this.hasLeftChild()) {
				hojas += this.getLeftChild().contarHojas();
			}
			if (this.hasRightChild()) {
				hojas += this.getRightChild().contarHojas();
			}
			return hojas;
		}
	}
    	 
    public BinaryTree<T> espejo(){
    	if (this.isEmpty()) {
    		return null;
    	} else {
    		BinaryTree<T> espejin = new BinaryTree<T>(this.data);
    		
    		if (this.hasLeftChild()) {
    			espejin.addRightChild(this.getLeftChild().espejo());
    		}
    		if (this.hasRightChild()) {
                espejin.addLeftChild(this.getRightChild().espejo());
            }
    		return espejin;
    	}
    }
    
    public void printLevelTraversal() {
    	 BinaryTree<T> ab = null;
    	 Queue<BinaryTree<T>> cola = new Queue<BinaryTree<T>>();
    	 cola.enqueue(this);
    	 cola.enqueue(null);
    	 while (!cola.isEmpty()) {
    		 ab = cola.dequeue();
    		 if (ab != null) {
    			 System.out.print(ab.getData() + " ");
    			 if (ab.hasLeftChild()) {
    				 cola.enqueue(ab.getLeftChild());
    			 }
    			 if (ab.hasRightChild()) {
    				 cola.enqueue(ab.getRightChild());
    			 }
    		 } else if (!cola.isEmpty()) {
    			 System.out.println();
    			 cola.enqueue(null);
    		 }
    	 }
    	 System.out.println();
    }


	public void entreNiveles(int n, int m){
		if (this.isEmpty()) {
			System.out.println("El arbol esta vacio");
		}
		else {
			BinaryTree<T> ab = null;
			Queue<BinaryTree<T>> cola = new Queue<BinaryTree<T>>();
			int L = 0;
			cola.enqueue(this);
			cola.enqueue(null);
			while (!cola.isEmpty()) {
				ab = cola.dequeue();
				if (ab != null) {
					if (L >= n && L <= m) {
						System.out.print(ab.getData());
					}
					else break;
					if (ab.hasLeftChild()) {
						cola.enqueue(ab.getLeftChild());
					}
					if (ab.hasRightChild()) {
						cola.enqueue(ab.getRightChild());
					}
				} else if (!cola.isEmpty()) {
					System.out.println();
					cola.enqueue(null);
					L++;
				}
			}
		}
   }
		
}

