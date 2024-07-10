package repaso.grafos.ejercicio_bfs_practica;

public class Persona {
	private String nombre;
	private String tipo;
	private boolean cobro;
	
	public Persona(String tipo, String nombre, boolean cobro) {
		this.tipo = tipo;
		this.nombre = nombre;
		this.cobro = cobro;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean getCobro() {
		return cobro;
	}

	public void setCobro(boolean cobro) {
		this.cobro = cobro;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", tipo=" + tipo + ", cobro=" + cobro + "]";
	}
}
