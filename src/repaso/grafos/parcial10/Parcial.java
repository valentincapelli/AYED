package repaso.grafos.parcial10;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.adjList.AdjListGraph;
import tp5.ejercicio1.Edge;

public class Parcial {
    
    List<String> resolver(Graph<Data> ciudades, String origen, String destino){
        LinkedList<String> camino = new LinkedList<>();
        if (ciudades != null && !ciudades.isEmpty()){
            Vertex<Data> verticeOrigen = buscarVertice(ciudades,origen);
            Vertex<Data> verticeDestino = buscarVertice(ciudades,destino);
            if (verticeOrigen != null && verticeDestino != null)
                if (verticeOrigen.getData().getFase() != "Fase 1" && verticeDestino.getData().getFase() != "Fase 1")
                    buscarCamino(ciudades, verticeOrigen, verticeDestino, new boolean[ciudades.getSize()], camino);
        }
        return camino;
    }

    private boolean buscarCamino(Graph<Data> ciudades, Vertex<Data> origen, Vertex<Data> destino, boolean [] visitados, LinkedList<String> camino){
        boolean ok = false;
        visitados[origen.getPosition()] = true;
        camino.add(origen.getData().getCiudad());
        if (origen.getData().getCiudad().equals(destino.getData().getCiudad()))
            ok = true;
        else {
            List<Edge<Data>> edges = ciudades.getEdges(origen);
            Iterator<Edge<Data>> it = edges.iterator();
            while (it.hasNext() && !ok){
                Vertex<Data> vertice = it.next().getTarget();
                if (!visitados[vertice.getPosition()] && vertice.getData().getFase() != "Fase 1")
                    ok = buscarCamino(ciudades, vertice, destino, visitados, camino);
            }
        }
        if (!ok)
            camino.removeLast();
        visitados[origen.getPosition()] = false;
        return ok;
    }

    private Vertex<Data> buscarVertice(Graph<Data> ciudades, String vertice){
        Vertex<Data> v = null;
        Vertex<Data> aux = null;
        List<Vertex<Data>> vertices = ciudades.getVertices();
        Iterator<Vertex<Data>> it = vertices.iterator();
        while (it.hasNext() && v == null){
            aux = it.next();
            if (aux.getData().getCiudad().equals(vertice))
                v = aux;
        }
        return v;
    }

    public static void main(String args[]) {
        Graph<Data> grafo = new AdjListGraph<Data>();
        //Descarte Saladillo, Lobos y Pinamar
        Vertex<Data> v1 = grafo.createVertex(new Data("Suipacha", "Fase 5"));
        Vertex<Data> v2 = grafo.createVertex(new Data("Carlos Keen", "Fase 3"));
        Vertex<Data> v3 = grafo.createVertex(new Data("Moreno", "Fase 1"));
        Vertex<Data> v4 = grafo.createVertex(new Data("Quilmes", "Fase 1"));
        Vertex<Data> v5 = grafo.createVertex(new Data("Navarro", "Fase 4"));
        Vertex<Data> v6 = grafo.createVertex(new Data("Cañuelas", "Fase 3"));
        Vertex<Data> v7 = grafo.createVertex(new Data("Abasto", "Fase 2"));
        Vertex<Data> v8 = grafo.createVertex(new Data("La Plata", "Fase 2"));
        
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
        
        System.out.println(p.resolver(grafo, "La Plata", "Carlos Keen"));
    }

}
