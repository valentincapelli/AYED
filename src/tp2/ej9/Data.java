package tp2.ej9;

public class Data {
	private int suma;
	private int diferencia;
	
	public Data(int suma, int diferencia) {
		this.suma = suma;
		this.diferencia = diferencia;
	}
	
	public int getSuma() {
		return suma;
	}
	
	public void setSuma(int suma) {
		this.suma = suma;
	}
	
	public int getDiferencia() {
		return diferencia;
	}
	
	public void setDiferencia(int diferencia) {
		this.diferencia = diferencia;
	}
	
	@Override
    public String toString() {
        return "Sum=" + suma + " Dif=" + diferencia; 
    }
}