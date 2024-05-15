package tp4.ej5;

import java.util.Arrays;
import java.util.Random;

public class EjercicioPermutaciones {
    
    private static Random rand = new Random();
    
    public static int[] randomUno(int n) { //no queda en loop infinito 
        int i, x = 0, k;
        int[] a = new int[n];
        for (i = 0; i < n; i++) {
            boolean seguirBuscando = true;
            while (seguirBuscando) {
                x = ran_int(0, n - 1); // x = valor random
                seguirBuscando = false;
                for (k = 0; k < i && !seguirBuscando; k++) { // si x esta en el vector corta
                    if (x == a[k]) {
                        seguirBuscando = true;
                    }
                }
            }
            a[i] = x; // agrega el valor random al vector
        }
        return a;
    }
    
    public static int[] randomDos(int n) { // anda
        int i, x;
        int[] a = new int[n];
        boolean[] used = new boolean[n];
        for (i = 0; i < n; i++) { // Inicializa vector de booleanos
            used[i] = false;
        }
        for (i = 0; i < n; i++) {
            x = ran_int(0, n - 1); // Genera num random 
            while (used[x]) {
                x = ran_int(0, n - 1);
            }
            a[i] = x;
            used[x] = true;
        }
        return a;
    }
    
    public static int[] randomTres(int n) {
        int i;
        int[] a = new int[n];
        for (i = 0; i < n; i++) {
            a[i] = i;
        }
        for (i = 1; i < n; i++) {
            swap(a, i, ran_int(0, i - 1));
        }
        return a;
    }
    
    private static void swap(int[] a, int i, int j) {
        int aux;
        aux = a[i];
        a[i] = a[j];
        a[j] = aux;
    }
    
    /**
     * Genera en tiempo constante, enteros entre i y j con igual probabilidad.
     */
    private static int ran_int(int a, int b) {
        if (b < a || a < 0 || b < 0) {
            throw new IllegalArgumentException("Parametros invalidos");
        }
        return a + (rand.nextInt(b - a + 1));
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(randomUno(1000)));
        System.out.println(Arrays.toString(randomDos(1000)));
        System.out.println(Arrays.toString(randomTres(1000)));
    }
}