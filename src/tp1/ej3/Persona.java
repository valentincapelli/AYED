package tp1.ej3;

public abstract class Persona {
	String nombre;
	String apellido;
	String email;
	
//	public Persona(String nombre, String apellido, String email) {
//		this.nombre = nombre;
//		this.apellido = apellido;
//		this.email = email;
//	}
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String tusDatos() {
		String str = "Nombre: "+this.getNombre()+" Apellido: "+this.getApellido()+ " Email: " + this.getEmail();
		return str;
	}
}
