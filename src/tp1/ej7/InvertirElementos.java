package tp1.ej7;

import java.util.ArrayList;

public class InvertirElementos {
	
	public void helper(ArrayList<Integer> lista, int posi, int posj) {
		if (posi >= posj) {
			return;
		}
		else {
			int aux = lista.get(posj);       // pongo en aux el valor de la ultima pos
			lista.set(posj, lista.get(posi));// seteo en la ultima pos el valor de la primera pos
			lista.set(posi, aux);            // seteo en la primera pos el valor de la ultima pos
			helper(lista, posi+1, posj-1);   // recursion avanzando en las posiciones del arraylist
		}
	}
	
	public void invertirArrayList(ArrayList<Integer> lista) {
		InvertirElementos inv = new InvertirElementos();
		inv.helper(lista, 0, lista.size()-1);
	}

	public static void main(String[] args) {
		InvertirElementos inv = new InvertirElementos();
		ArrayList<Integer> lista = new ArrayList<>();
		
		// lleno la lista
		for (int i=1; i<6; i++) {
		  lista.add(i);
		}
		
		System.out.println("Lista por defecto");
		for (int i: lista) {
			System.out.println(i);
		}
		
		inv.invertirArrayList(lista);
		
		System.out.println("Lista invertida");
		for (int i: lista) {
			System.out.println(i);
		}
		
	}

}