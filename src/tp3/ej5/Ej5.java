package tp3.ej5;

import java.util.LinkedList;
import java.util.List;

public class Ej5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		System.out.println(a.esAncestro("2", "32"));
	}

}
