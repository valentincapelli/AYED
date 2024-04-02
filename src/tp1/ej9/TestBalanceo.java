package tp1.ej9;

public class TestBalanceo {
	
	public void balancearCadena(String cadena) {
		Stack<Character> stack = new Stack<Character>();
		
		for (int i = 0; i < cadena.length(); i++) {
			char car = cadena.charAt(i);
			if (car )
		}
	}
	
	public static void main(String[] args) {
		String cadena = "([})]{";
		
		TestBalanceo b = new TestBalanceo();
		b.balancearCadena(cadena);
		
	}
}