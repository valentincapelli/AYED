package repaso.practica5.parcial5;

public class Estadio {
    private String estadio;
    private String ciudad;

    public Estadio(String ciudad, String estadio){
        this.estadio = estadio;
        this.ciudad = ciudad;
    }
    public String getEstadio(){
        return this.estadio;
    }
    public void setEstadio(String estadio){
        this.estadio = estadio;
    }
    public String getCiudad(){
        return this.ciudad;
    }
    public void setCiudad(String ciudad){
        this.ciudad = ciudad;
    }
}
