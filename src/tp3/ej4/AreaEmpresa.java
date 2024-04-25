package tp3.ej4;

public class AreaEmpresa {
	String area;
	int tardanza;
	
	public AreaEmpresa(String area, int tardanza) {
		this.area = area;
		this.tardanza = tardanza;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public int getTardanza() {
		return tardanza;
	}
	public void setTardanza(int tardanza) {
		this.tardanza = tardanza;
	}
	@Override
	public String toString() {
		return "AreaEmpresa [area=" + area + ", tardanza=" + tardanza + "]";
	}
	
}
