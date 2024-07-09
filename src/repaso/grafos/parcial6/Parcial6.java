package repaso.grafos.parcial6;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.adjList.AdjListGraph;

public class Parcial6 {
    
    public List<String> caminoConPresupuesto(Graph<String> ciudades, String origen, String destino, int montoMaximo){
        List<String> camino = new LinkedList<>();
        if (ciudades != null && !ciudades.isEmpty()){
            boolean [] visitados = new boolean [ciudades.getSize()];
            Vertex<String> verticeOrigen = ciudades.search(origen);
            Vertex<String> verticeDestino = ciudades.search(destino);
            if (origen != null && destino != null)
                buscarCamino(ciudades, verticeOrigen, verticeDestino, visitados, montoMaximo, camino);
        }
        return camino;
    }

    private boolean buscarCamino(Graph<String> ciudades, Vertex<String> origen, Vertex<String> destino, boolean [] visitados, int montoMaximo, List<String> camino){
        boolean ok = false;
        visitados[origen.getPosition()] = true;
        camino.add(origen.getData());
        if (origen.getData().equals(destino.getData()))
            ok = true;
        if (!ok){
            List<Edge<String>> ady = ciudades.getEdges(origen);
            Iterator<Edge<String>> it = ady.iterator();
            while (it.hasNext() && !ok){
                Edge<String> arista = it.next();
                Vertex<String> dest = arista.getTarget();
                if (!visitados[dest.getPosition()] && montoMaximo >= arista.getWeight())
                    ok = buscarCamino(ciudades, dest, destino, visitados, (montoMaximo - arista.getWeight()), camino);
            }
        }
        if (!ok)
            camino.removeLast();
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
        
        Parcial6 p = new Parcial6();
        
        System.out.println(p.caminoConPresupuesto(grafo, "Lincoln", "Berisso", 200));
    }

}
