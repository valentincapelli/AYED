package repaso.grafos.parcial8;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.adjList.AdjListGraph;



public class BuscadorDeCamino {
    
    List<String> caminoConPresupuesto(Graph<String> ciudades, String origen, String destino, int montoMinimo){
        LinkedList<String> lista = new LinkedList<>();
        if (ciudades != null && !ciudades.isEmpty()){
            Vertex<String> verticeOrigen = ciudades.search(origen);
            Vertex<String> verticeDestino = ciudades.search(destino);
            if (verticeOrigen != null && verticeDestino != null)
                buscarCamino(ciudades, verticeOrigen, verticeDestino, new boolean[ciudades.getSize()], montoMinimo, 0,lista);
        }
        return lista;
    }

    public boolean buscarCamino(Graph<String> ciudades, Vertex<String> origen, Vertex<String> destino, boolean [] visitados, int montoMinimo, int montoActual, LinkedList<String> lista){
        boolean ok = false;
        System.out.println(montoActual);
        visitados[origen.getPosition()] = true;
        lista.add(origen.getData());
        if (origen.getData() == destino.getData() && montoActual >= montoMinimo)
            ok = true;
        List<Edge<String>> edges = ciudades.getEdges(origen);
        Iterator<Edge<String>> it = edges.iterator();
        while (it.hasNext() && !ok){
            Edge<String> e = it.next();
            Vertex<String> v = e.getTarget();
            if (!visitados[v.getPosition()])
                ok = buscarCamino(ciudades, v, destino, visitados, montoMinimo, (montoActual + e.getWeight()) , lista);
        }
        if (!ok)
            lista.removeLast();
        visitados[origen.getPosition()] = false;
        return ok;
    }

    public static void main(String args[]) {
        Graph<String> grafo = new AdjListGraph<String>();
        Vertex<String> v1 = grafo.createVertex("Lincoln");
        Vertex<String> v2 = grafo.createVertex("Chascomús");
        Vertex<String> v3 = grafo.createVertex("Cañuelas");
        Vertex<String> v4 = grafo.createVertex("Dolores");
        Vertex<String> v5 = grafo.createVertex("Verónica");
        Vertex<String> v6 = grafo.createVertex("Villa Urquiza");
        Vertex<String> v7 = grafo.createVertex("Ranchos");
        Vertex<String> v8 = grafo.createVertex("Berisso");
        
        grafo.connect(v1, v2, 70);
        grafo.connect(v2, v1, 70);
        grafo.connect(v1, v3, 50);
        grafo.connect(v3, v1, 50);
        grafo.connect(v1, v4, 90);
        grafo.connect(v4, v1, 90);
        grafo.connect(v2, v5, 80);
        grafo.connect(v5, v2, 80);
        grafo.connect(v2, v6, 60);
        grafo.connect(v6, v2, 60);
        grafo.connect(v3, v5, 85);
        grafo.connect(v5, v3, 85);
        grafo.connect(v3, v7, 90);
        grafo.connect(v7, v3, 90);
        grafo.connect(v4, v6, 70);
        grafo.connect(v6, v4, 70);
        grafo.connect(v4, v7, 70);
        grafo.connect(v7, v4, 70);
        grafo.connect(v5, v8, 60);
        grafo.connect(v8, v5, 60);
        grafo.connect(v6, v8, 90);
        grafo.connect(v8, v6, 90);
        grafo.connect(v7, v8, 75);
        grafo.connect(v8, v7, 75);
        
        BuscadorDeCamino p = new BuscadorDeCamino();
        
        System.out.println(p.caminoConPresupuesto(grafo, "Lincoln", "Berisso", 450));
    }

}
