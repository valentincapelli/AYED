package tp1.ej3;

public class Estudiante extends Persona{
	String comision;
	String direccion;
	
	public Estudiante(String nombre, String apellido, String email, String comision, String direccion) {
		super.nombre = nombre;
		super.apellido = apellido;
		super.email = email;
		this.comision = comision;
		this.direccion = direccion;
	}
	
	public String getComision() {
		return comision;
	}
	public void setComision(String comision) {
		this.comision = comision;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public  String tusDatos() {
        String str = super.tusDatos() + " Comision: " + this.getComision() + " Direccion: " + this.getDireccion();
        return str;
    }
}
