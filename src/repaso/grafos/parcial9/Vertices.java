package repaso.grafos.parcial9;

import tp5.ejercicio1.Vertex;

public class Vertices {
    private Vertex<String> origen;
    private Vertex<String> destino;
    
    public Vertices(Vertex<String> origen, Vertex<String> destino) {
        this.origen = origen;
        this.destino = destino;
    }

    public Vertex<String> getOrigen() {
        return origen;
    }

    public void setOrigen(Vertex<String> origen) {
        this.origen = origen;
    }

    public Vertex<String> getDestino() {
        return destino;
    }

    public void setDestino(Vertex<String> destino) {
        this.destino = destino;
    }
    
    
}