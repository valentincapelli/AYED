package tp1.ej7;
import java.util.LinkedList;
public class SumaElementosDeArrayList {
	
	public int calcularSuma(LinkedList<Integer> lista, int suma, int indice) {
		if (indice == lista.size()-1) {
			return suma + lista.get(indice);
		}
		else {
			suma = lista.get(indice) + calcularSuma(lista,suma,indice+1);
		}
		return suma;
	}
	
	public int sumarLinkedList(LinkedList<Integer> lista) {
		int indice = 0;
		return calcularSuma(lista,0,indice);
	}

	public static void main(String[] args) {
		LinkedList<Integer> lista = new LinkedList<>();
		
		// lleno la lista
		for (int i=1; i<6; i++) {
			lista.add(i);
		}
		
		SumaElementosDeArrayList s = new SumaElementosDeArrayList();
		System.out.println("La suma de la LinkedList es "+s.sumarLinkedList(lista));

	}

}