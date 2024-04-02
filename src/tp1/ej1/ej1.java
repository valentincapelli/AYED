package tp1.ej1;

public class ej1 {

	public static void imprimirConFor(int num1, int num2) {
		int i;
		for (i=num1; i<=num2;i++){
			System.out.println(i);
		}
	}
		
	public static void imprimirConWhile(int num1, int num2) {
		while (num1 <= num2) {
			System.out.println(num1);
			num1++;
		}
	}
	
	public static void imprimirSinIteracion(int num1, int num2) {
		if (num1 <= num2) {
			System.out.println(num1);
			num1++;
			imprimirSinIteracion(num1,num2);
		}
	}
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		imprimirConFor(2,6);
		System.out.println("------------------------");
		imprimirConWhile(2,6);
		System.out.println("------------------------");
		imprimirSinIteracion(2,10);
		
	}

}
