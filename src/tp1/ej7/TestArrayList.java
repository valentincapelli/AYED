package tp1.ej7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestArrayList {
	
	public static void metodo() {   // d.
		
		List<Estudiante> studentsList = new ArrayList<Estudiante>();
		
		studentsList.add(new Estudiante("Jorge","Carrascal"));
		studentsList.add(new Estudiante("Pity","Martinez"));
		studentsList.add(new Estudiante("La araña","Que Pica"));
		
		// Creo y la inicializo a la lista copiada con el constructor usando el parametro.
		List<Estudiante> copiedList = new ArrayList<Estudiante>(studentsList);
		
		// Creo una nueva lista y agrego todos los elemento de la otra usando addAll().
		// ArrayList<Estudiante> copiedList = new ArrayList<>();
		// copiedList.addAll(studentsList);
		
		// Clonar la lista usando el metodo clone().
		// ArrayList<Estudiante> copiedList = (ArrayList<Estudiante>)studentsList.clone();
		// El uso del clone() no se recomienda ya que se debe castear.
		
		System.out.println("Contenido lista original");
		for (Estudiante e : studentsList) {
			System.out.println(e.getNombre()+" "+e.getApellido());
		}
		System.out.println("Contenido lista copiada");
		for (Estudiante e : copiedList) {
			System.out.println(e.getNombre()+" "+e.getApellido());
		}
		// Modifico un dato de un estudiante
		Estudiante E = new Estudiante("El colibri","Borja");
		studentsList.set(1, E);
		
		System.out.println("Contenido lista original");
		for (Estudiante e : studentsList) {
			System.out.println(e.getNombre()+" "+e.getApellido());
		}
		System.out.println("Contenido lista copiada");
		for (Estudiante e : copiedList) {
			System.out.println(e.getNombre()+" "+e.getApellido());
		}
		// Las conclusiones que saco es que una vez que se copia una lista, si la original se modifica, la lista copiada
		// no se vera modificada tambien, ya que son dos listas distintas pero que tenian los mismos elementos.
		
		// e. Verifica si se repite el estudiante
		E = new Estudiante("El Diablito","Echeverri");
		boolean repeated = false;
		for (Estudiante i : studentsList) {
			if (i.equals(E)) {
				repeated = true;
			}
		}
		// Si no esta repetido agrega un nuevo estudiante
		if (!repeated) {
			studentsList.add(E);
			System.out.println("Se agrego un nuevo estudiante");
		}
		else {
			System.out.println("No se pudo agregar un nuevo estudiante");
		}
		// Imprimo la lista para verificar si se agrego
		System.out.println("Contenido lista original");
		for (Estudiante e : studentsList) {
			System.out.println(e.getNombre()+" "+e.getApellido());
		}
    }
	// f. CONSULTAR SI SE PUEDE PONER COMO STATIC!!!
	public static boolean esCapicua (ArrayList<Integer> lista) {
		boolean result = true;
		
		// Creo dos vectores con el tamaño de la lista
		int[] v1 = new int[lista.size()]; 
		int[] v2 = new int[lista.size()]; 
		
		// Voy armando los dos vectores en orden invertido
		int indice = 0;
		for (Integer i : lista) {
			v1[indice] = i;
			v2[lista.size()-indice-1] = i;
			indice++;
		}
		// Comparo las posiciones de los vectores y si son todas igual retorno true, sino false
		for (int i=0; i < v1.length; i++) {
			if (v1[i] != v2[i]) {
				result = false;
				break;
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		//b. Si en lugar de usar un ArrayList en el inciso anterior hubiera usado un LinkedList ¿Qué
		// diferencia encuentra respecto de la implementación? Justifique
		// En cuanto a la implementación del código presentado, tanto si se utiliza un ArrayList como
		// si se utiliza un LinkedList, la estructura y la lógica del programa serían prácticamente idénticas. La diferencia
		// principal residiría en el tipo de lista que se instancia al principio del programa.
		// Si despues tuvieramos que acceder a muchos elemento conviene usar arraylist, en cambio si tenemos que eliminar o
		// agregar muchos elementos mejor una linkedlist.
		
		// c. ¿Existen otras alternativas para recorrer los elementos de la lista del punto 7a.?
		// Si tambien se puede hacer uso del Iterator que permite el recorrido secuencial
		// por una estructura de datos, ya sea un arraylist o linkeslist. Una colección es iterable si dispone del método iterator()
		// para iterar la colección -debe implementar la interface java.util.Iterable-.
		
		// a. Crear una instancia de Scanner para leer desde el teclado
        Scanner scanner = new Scanner(System.in);
        
        // Crear una lista de tipo ArrayList para almacenar los números
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        
        System.out.println("Ingrese una lista de numeros que finalice con 0");
        Integer sca = scanner.nextInt();
        while (sca != 0) {
        	numbers.add(sca);
        	sca = scanner.nextInt();
        }
        
        scanner.close();
        
        System.out.println("Contenido de la lista:");
        for (int i : numbers) {
            System.out.println(i);
        }
        //metodo	();  // d.
        
        if (esCapicua(numbers)) {
        	System.out.println("Es capicua");
        }
        else
        	System.out.println("No es capicua");
	}

}