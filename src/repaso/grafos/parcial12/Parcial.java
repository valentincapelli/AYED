package repaso.grafos.parcial12;

import java.util.Iterator;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.adjList.AdjListGraph;

public class Parcial {
    
    public int resolver(Graph<Ciudad> ciudades, String origen, String destino, int maxControles){
        int max = 0;
        if (ciudades != null && !ciudades.isEmpty()){
            Vertex<Ciudad> verticeOrigen = buscarVertice(ciudades, origen);
            Vertex<Ciudad> verticeDestino = buscarVertice(ciudades, destino);
            if (verticeOrigen != null && verticeDestino != null)
                max = buscarMaximo(ciudades, verticeOrigen, verticeDestino, new boolean[ciudades.getSize()], maxControles, verticeOrigen.getData().getTiempo(), 0);
        }
        return max;
    }

    private int buscarMaximo(Graph<Ciudad> ciudades, Vertex<Ciudad> origen, Vertex<Ciudad> destino, boolean [] visitados, int maxControles, int total, int max){
        visitados[origen.getPosition()] = true;
        if (origen.getData().getCiudad().equals(destino.getData().getCiudad())){
            if (total > max)
                max = total;
        }
        else {
            List<Edge<Ciudad>> edges = ciudades.getEdges(origen);
            for(Edge<Ciudad> edge : edges){
                Vertex<Ciudad> vertice = edge.getTarget();
                if (!visitados[vertice.getPosition()] && edge.getWeight() <= maxControles)
                    max = buscarMaximo(ciudades, vertice, destino, visitados, maxControles, total + vertice.getData().getTiempo(), max);
            }
        }
        visitados[origen.getPosition()] = false;
        return max;
    }

    private Vertex<Ciudad> buscarVertice(Graph<Ciudad> ciudades, String vertice){
        List<Vertex<Ciudad>> vertices = ciudades.getVertices();
        Vertex<Ciudad> v = null;
        Iterator<Vertex<Ciudad>> it = vertices.iterator();
        while (it.hasNext() && v == null){
            Vertex<Ciudad> aux = it.next();
            if (aux.getData().getCiudad().equals(vertice))
                v = aux;
        }
        return v;
    }

    public static void main(String args[]) {
        Graph<Ciudad> grafo = new AdjListGraph<Ciudad>();
        //Descarte Saladillo, Lobos y Pinamar
        Vertex<Ciudad> v1 = grafo.createVertex(new Ciudad("Suipacha", 3));
        Vertex<Ciudad> v2 = grafo.createVertex(new Ciudad("Carlos Keen", 2));
        Vertex<Ciudad> v3 = grafo.createVertex(new Ciudad("Moreno", 2));
        Vertex<Ciudad> v4 = grafo.createVertex(new Ciudad("Quilmes", 3));
        Vertex<Ciudad> v5 = grafo.createVertex(new Ciudad("Navarro", 1));
        Vertex<Ciudad> v6 = grafo.createVertex(new Ciudad("Cañuelas", 2));
        Vertex<Ciudad> v7 = grafo.createVertex(new Ciudad("Abasto", 3));
        Vertex<Ciudad> v8 = grafo.createVertex(new Ciudad("La Plata", 1));
        
        grafo.connect(v1, v2, 2);
        grafo.connect(v2, v1, 2);
        grafo.connect(v2, v3, 2);
        grafo.connect(v3, v2, 2);
        grafo.connect(v3, v4, 2);
        grafo.connect(v4, v3, 2);
        grafo.connect(v1, v5, 2);
        grafo.connect(v5, v1, 2);
        grafo.connect(v5, v6, 2);
        grafo.connect(v6, v5, 2);
        grafo.connect(v6, v7, 2);
        grafo.connect(v7, v6, 2);
        grafo.connect(v7, v3, 3);
        grafo.connect(v3, v7, 3);
        grafo.connect(v7, v8, 2);
        grafo.connect(v8, v7, 2);
        grafo.connect(v8, v4, 2);
        grafo.connect(v4, v8, 2);
        
        Parcial p = new Parcial();
        
        System.out.println(p.resolver(grafo, "La Plata", "Suipacha", 2));
        //System.out.println(p.resolver(grafo, "La Plata", "Carlos Keen", 2));
    }

}
