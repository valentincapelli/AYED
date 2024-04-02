package tp1.ej7;
import java.util.ArrayList;
public class OrdenarDosListas {
	
	public ArrayList<Integer> combinarOrdenado(ArrayList<Integer> lista1, ArrayList<Integer> lista2){
		int i1 = 0;
		int i2 = 0;
		
		ArrayList<Integer> lista3 = new ArrayList<>();
		
		while (i1 < lista1.size() && i2 < lista2.size()) {
			if (lista1.get(i1) < lista2.get(i2)) {
				lista3.add(lista1.get(i1));
				i1++;
			} 
			else {
				lista3.add(lista2.get(i2));
				i2++;
			}
		}
		while (i1 < lista1.size()) {
			lista3.add(lista1.get(i1));
			i1++;
		}
		while (i2 < lista2.size()) {
			lista3.add(lista2.get(i2));
			i2++;
		}
		
		return lista3;
	}

	public static void main(String[] args) {
		ArrayList<Integer> lista1 = new ArrayList<>();
		lista1.add(1);
		lista1.add(3);
		lista1.add(5);
		lista1.add(7);
		lista1.add(9);
		
		ArrayList<Integer> lista2 = new ArrayList<>();
		lista2.add(2);
		lista2.add(4);
		lista2.add(6);
		lista2.add(8);
		lista2.add(10);
		
		ArrayList<Integer> listaCombinada;
		
		OrdenarDosListas o = new OrdenarDosListas();
		listaCombinada = o.combinarOrdenado(lista1, lista2);
		
		for (int i : listaCombinada) {
			System.out.println(i);
		}
	}

}