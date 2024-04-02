package tp1.ej5;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] datos = {1, 2, 3, 4, 5 };
		info inf = Calculadora.calcularValores(datos);
		System.out.println("Maximo: "+inf.getMaximo()+" Minimo: "+inf.getMinimo()+" Promedio "+inf.Promedio);
		
		info inf2 = new info();
		int [] datos2 = {2, 4, 6, 8, 10};
		inf2 = Calculadora.calcularValoresConParametro(datos2, inf2);
		System.out.println("Maximo: "+inf2.getMaximo()+" Minimo: "+inf2.getMinimo()+" Promedio "+inf2.Promedio);
		
		int [] datos3 = {3, 6, 9, 12, 15};
		Calculadora.calcularValoresSinParametros(datos3);
	}

}