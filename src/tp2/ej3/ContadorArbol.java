package tp2.ej3;

import java.util.ArrayList;
import tp2.ej2.BinaryTree;

public class ContadorArbol {
	BinaryTree<Integer> ab;
	
	public ArrayList<Integer> numerosPares1() {
		ArrayList<Integer> result = new ArrayList<>();
		this.inOrden(ab, result);
		return result;
	}
	
	public ArrayList<Integer> numerosPares2(){
		ArrayList<Integer> result = new ArrayList<>();
		this.postOrden(ab, result);
		return result;
	}
	
	private void inOrden(BinaryTree<Integer> ab, ArrayList<Integer> result) {
		if  (ab.hasLeftChild()) {
			inOrden(ab.getLeftChild(), result);
		}
		if (ab.getData() % 2 == 0) {
			result.add(ab.getData());
		}
		if (ab.hasRightChild()) {
			inOrden(ab.getRightChild(),result);
		}
	}
	
	private void postOrden(BinaryTree<Integer> ab, ArrayList<Integer> result) {
		if (ab.hasLeftChild()) {
			postOrden(ab.getLeftChild(),result);
		}
		if (ab.hasRightChild()) {
			postOrden(ab.getRightChild(),result);
		}
		if (ab.getData() % 2 == 0) {
			result.add(ab.getData());
		}
	}
}

