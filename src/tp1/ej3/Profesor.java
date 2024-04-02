package tp1.ej3;

public class Profesor extends Persona{
	String catedra;
	String facultad;
	
	public Profesor (String nombre, String apellido, String email, String catedra, String facultad) {
		super.nombre = nombre;
		super.apellido = apellido;
		super.email = email;
		this.catedra = catedra;
		this.facultad = facultad;
	}
	public String getCatedra() {
		return catedra;
	}
	public void setCatedra(String catedra) {
		this.catedra = catedra;
	}
	public String getFacultad() {
		return facultad;
	}
	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}
	public  String tusDatos() {
        String str = super.tusDatos() + " Catedra: " + this.getCatedra() + " Facultad: " + this.getFacultad();
        return str;
    }
}
