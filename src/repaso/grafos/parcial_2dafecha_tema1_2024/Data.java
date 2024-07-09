package repaso.grafos.parcial_2dafecha_tema1_2024;

public class Data {
    private String nombre;
    private int distancia;

    public Data(String nombre, int distancia){
        this.nombre = nombre;
        this.distancia = distancia;
    }

    public String getNombre(){
        return this.nombre;
    }

    public int getDistancia(){
        return this.distancia;
    }
}
