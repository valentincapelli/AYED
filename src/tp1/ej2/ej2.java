package tp1.ej2;

import java.util.Scanner;

public class ej2 {

	public static int [] nuevoArregloN(int N) {
		int [] arreglo = new int [N];
		for (int i=0; i<N; i++) {
			arreglo[i] = N*(i+1);
		}
		return arreglo;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner escaner = new Scanner(System.in);
		System.out.println("Ingrese un numero N");
		int num = escaner.nextInt();
		int [] vector = nuevoArregloN(num);
		
		for (int dato : vector) {
			System.out.println(dato);
		}
		
		escaner.close();
	}

}
