package tp3.ej2;

import java.util.LinkedList;
import java.util.List;

import tp3.ej1.GeneralTree;

public class TestRecorridosAG {

	public static void main(String[] args) {
		
		GeneralTree<Integer> a1 = new GeneralTree<Integer>(1);
		List<GeneralTree<Integer>> children2 = new LinkedList<GeneralTree<Integer>>();
		children2.add(new GeneralTree<Integer>(21));
		children2.add(new GeneralTree<Integer>(23));
		children2.add(new GeneralTree<Integer>(25));
		GeneralTree<Integer> a2 = new GeneralTree<Integer>(2, children2);
		List<GeneralTree<Integer>> children3 = new LinkedList<GeneralTree<Integer>>();
		children3.add(new GeneralTree<Integer>(31));
		children3.add(new GeneralTree<Integer>(33));
		GeneralTree<Integer> a3 = new GeneralTree<Integer>(3, children3);
		List<GeneralTree<Integer>> children = new LinkedList<GeneralTree<Integer>>();
		children.add(a1);
		children.add(a2);
		children.add(a3);
		GeneralTree<Integer> a = new GeneralTree<Integer>(0, children);
		
		RecorridosAG rec = new RecorridosAG();
		System.out.println(rec.numerosImparesMayoresQuePreOrden(a, 3));
		
		System.out.println(rec.numerosImparesMayoresQuePorNiveles(a, 3));
	}

}
