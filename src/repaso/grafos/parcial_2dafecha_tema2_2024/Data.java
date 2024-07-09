package repaso.grafos.parcial_2dafecha_tema2_2024;

public class Data {
    private int cant;
    private boolean cumple;

    public Data(int cant, boolean cumple){
        this.cant = cant;
        this.cumple = cumple;
    }

    public int getCant(){
        return this.cant;
    }

    public boolean getCumple(){
        return this.cumple;
    }
}
