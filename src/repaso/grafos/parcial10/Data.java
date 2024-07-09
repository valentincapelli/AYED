package repaso.grafos.parcial10;

public class Data {
    private String ciudad;
    private String fase;
    
    public Data(String ciudad, String fase){
        this.ciudad = ciudad;
        this.fase = fase;
    }

    public String getCiudad(){
        return this.ciudad;
    }

    public String getFase(){
        return this.fase;
    }
}
