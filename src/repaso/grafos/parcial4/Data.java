package repaso.grafos.parcial4;

import java.util.List;

public class Data {
    private List<String> camino;
    private int cuadras;

    public Data() {
    
    }

    public Data(List<String> camino, int cuadras){
        this.camino = camino;
        this.cuadras = cuadras;
    }

    @Override
    public String toString() {
        return this.camino + " TOTAL=" + cuadras;
    }
}
