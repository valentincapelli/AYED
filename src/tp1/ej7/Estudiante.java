
package tp1.ej7;

public class Estudiante{
	String nombre;
	String apellido;
	
	public Estudiante(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public boolean equals(Estudiante E) {
		boolean result = false;
		if ((E!=null) && (E instanceof Estudiante)) {
			if ((E.getNombre() == this.getNombre()) && (E.getApellido() == this.getApellido())){
				result = true;
			}
		}
		return result;
	}
}
