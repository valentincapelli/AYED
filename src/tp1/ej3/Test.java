package tp1.ej3;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Estudiante [] studentsArray = new Estudiante [2];
		
		Profesor [] professorArray = new Profesor [3];
		
		for (int i=0; i<2; i++) {
			Estudiante E = new Estudiante("Valentin","Capelli","@@@", "1b", "385");
			studentsArray[i] = E;
		}
		for (int i=0; i<3; i++) {
			Profesor P = new Profesor ("severus","snape","@@@", "cateprofe", "facupro");
			professorArray[i] = P;
		}
		
		for (Estudiante est : studentsArray) {
			System.out.println(est.tusDatos());
		}
		
		for (Profesor pro : professorArray) {
			System.out.println(pro.tusDatos());
		}
	}

}
