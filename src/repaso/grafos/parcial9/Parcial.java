package repaso.grafos.parcial9;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.adjList.AdjListGraph;

public class Parcial {
    
    List<String> resolver(Graph<String> ciudades, String origen, String destino, List<String> pasandoPor){
        LinkedList<String> camino = new LinkedList<>();
        if (ciudades != null && !ciudades.isEmpty()){
            Vertex<String> verticeOrigen = ciudades.search(origen);
            Vertex<String> verticeDestino = ciudades.search(destino);
            boolean [] visitados = new boolean [ciudades.getSize()];
            if (verticeOrigen != null && verticeDestino != null)
                buscarCamino(ciudades, verticeOrigen, verticeDestino, pasandoPor, visitados, camino);
        }
        return camino;
    }

    private boolean buscarCamino(Graph<String> ciudades, Vertex<String> origen, Vertex<String> destino, List<String> pasandoPor, boolean [] visitados,List<String> camino){
        boolean ok = false;
        visitados[origen.getPosition()] = true;
        camino.add(origen.getData());
        if (origen.getData().equals(destino.getData())){
            if (camino.containsAll(pasandoPor))
                ok = true;
        } else {
            List<Edge<String>> edges = ciudades.getEdges(origen);
            Iterator<Edge<String>> it = edges.iterator();
            while (it.hasNext() && !ok){
                Edge<String> arista = it.next();
                Vertex<String> dest = arista.getTarget();
                if (!visitados[dest.getPosition()])
                    ok = buscarCamino(ciudades, dest, destino, pasandoPor, visitados, camino);
            }
        }
        if (!ok)
            camino.removeLast();
        visitados[origen.getPosition()] = false;
        return ok;
    }

    public static void main(String args[]) {
        Graph<String> grafo = new AdjListGraph<String>();
        //Descarte Saladillo, Lobos y Pinamar
        Vertex<String> v1 = grafo.createVertex("Suipacha");
        Vertex<String> v2 = grafo.createVertex("Carlos Keen");
        Vertex<String> v3 = grafo.createVertex("Moreno");
        Vertex<String> v4 = grafo.createVertex("Quilmes");
        Vertex<String> v5 = grafo.createVertex("Navarro");
        Vertex<String> v6 = grafo.createVertex("Cañuelas");
        Vertex<String> v7 = grafo.createVertex("Abasto");
        Vertex<String> v8 = grafo.createVertex("La Plata");
        
        grafo.connect(v1, v2);
        grafo.connect(v2, v1);
        grafo.connect(v2, v3);
        grafo.connect(v3, v2);
        grafo.connect(v3, v4);
        grafo.connect(v4, v3);
        grafo.connect(v1, v5);
        grafo.connect(v5, v1);
        grafo.connect(v5, v6);
        grafo.connect(v6, v5);
        grafo.connect(v6, v7);
        grafo.connect(v7, v6);
        grafo.connect(v7, v3);
        grafo.connect(v3, v7);
        grafo.connect(v7, v8);
        grafo.connect(v8, v7);
        grafo.connect(v8, v4);
        grafo.connect(v4, v8);
        
        Parcial p = new Parcial();
        
        List<String> pasandoPor = new LinkedList<String>();
        
        pasandoPor.add("Quilmes");
        //pasandoPor.add("Abasto");
        pasandoPor.add("Carlos Keen");
        
        System.out.println(p.resolver(grafo, "La Plata", "Suipacha", pasandoPor));
    }

}
