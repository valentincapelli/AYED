package tp1.ej5;

public class Calculadora {
	
	public static info calcularValores (int[] datos) {
		
		info inf = new info();
		int sumaDeNumeros = 0;
		for (int i = 0; i < datos.length; i++) {
			if (datos[i] > inf.getMaximo()) {
				inf.setMaximo(datos[i]);
			}
			if (datos[i] < inf.getMinimo()) {
				inf.setMinimo(datos[i]);
			}
			sumaDeNumeros = sumaDeNumeros + datos[i];
		}
		inf.setPromedio(sumaDeNumeros/datos.length);
		
		return inf;
	}
	
	public static info calcularValoresConParametro (int[] datos, info inf) {
		int sumaDeNumeros = 0;
		for (int i = 0; i < datos.length; i++) {
			if (datos[i] > inf.getMaximo()) {
				inf.setMaximo(datos[i]);
			}
			if (datos[i] < inf.getMinimo()) {
				inf.setMinimo(datos[i]);
			}
			sumaDeNumeros = sumaDeNumeros + datos[i];
		}
		inf.setPromedio(sumaDeNumeros/datos.length);
		
		return inf;
	}
public static void calcularValoresSinParametros (int[] datos) {
		
		info inf = new info();
		int sumaDeNumeros = 0;
		for (int i = 0; i < datos.length; i++) {
			if (datos[i] > inf.getMaximo()) {
				inf.setMaximo(datos[i]);
			}
			if (datos[i] < inf.getMinimo()) {
				inf.setMinimo(datos[i]);
			}
			sumaDeNumeros = sumaDeNumeros + datos[i];
		}
		inf.setPromedio(sumaDeNumeros/datos.length);
		
		System.out.println("Maximo: "+inf.getMaximo()+" Minimo: "+inf.getMinimo()+" Promedio "+inf.Promedio);
	}
}