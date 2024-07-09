package repaso.grafos.parcial_simulacro;

public class Data {
    private String ciudad;
    private int dias;

    public Data(){
        
    }

    public Data(int dias, String ciudad){
        this.ciudad = ciudad;
        this.dias = dias;
    }

    public String getCiudad(){
        return this.ciudad;
    }

    public int GetDias(){
        return this.dias;
    }

}
