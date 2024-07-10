package repaso.grafos.parcial5;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.adjList.AdjListGraph;

public class Parcial5_repaso {
    
    public List<String> estadios(Graph<Estadio> mapaEstadios, String estadioOrigen, int cantKm){
        List<String> lista = new LinkedList<>();
        if (mapaEstadios != null & !mapaEstadios.isEmpty()){
            Vertex<Estadio> origen = buscarEstadio(mapaEstadios, estadioOrigen);
            if (origen != null){
                boolean [] visitados = new boolean[mapaEstadios.getSize()];
                buscarCamino(mapaEstadios, origen, cantKm, visitados, lista, new LinkedList<String>());
            }
        }
        return lista;
    }

    private void buscarCamino(Graph<Estadio> mapaEstadios, Vertex<Estadio> origen, int cantKm, boolean [] visitados, List<String> camino, List<String> caminoActual){
        visitados[origen.getPosition()] = true;
        caminoActual.add(origen.getData().getEstadio());
        List<Edge<Estadio>> edges = mapaEstadios.getEdges(origen);
        for(Edge<Estadio> edge : edges){
            Vertex<Estadio> v = edge.getTarget();
            if(!visitados[v.getPosition()] && cantKm >= edge.getWeight()){
                buscarCamino(mapaEstadios, v, (cantKm - edge.getWeight()), visitados, camino, caminoActual);
            }
        if (caminoActual.size() > camino.size()){
            camino.clear();
            camino.addAll(caminoActual);
        }
        visitados[origen.getPosition()] = false;
        if (caminoActual.size() > 0)
            caminoActual.removeLast();
        }
    }

    private Vertex<Estadio> buscarEstadio(Graph<Estadio> mapaEstadios, String estadio){
        Vertex<Estadio> v = null;
        List<Vertex<Estadio>> vertices = mapaEstadios.getVertices();
        Iterator<Vertex<Estadio>> it = vertices.iterator();
        while (it.hasNext() && v == null){
            Vertex<Estadio> aux = it.next();
            if (aux.getData().getEstadio().equals(estadio))
                v = aux;
        }
        return v;
    }

    public static void main(String args[]) {
        Graph<Estadio> grafo = new AdjListGraph<>();
        Vertex<Estadio> v1 = grafo.createVertex(new Estadio("Jor", "AI BAYT STADIUM"));
        Vertex<Estadio> v2 = grafo.createVertex(new Estadio("Lusail", "LUSAIL STADIUM"));
        Vertex<Estadio> v3 = grafo.createVertex(new Estadio("Rayán", "EDUCATION CITY STADIUM"));
        Vertex<Estadio> v4 = grafo.createVertex(new Estadio("Rayán", "AL RAYYAN STADIUM"));
        Vertex<Estadio> v5 = grafo.createVertex(new Estadio("Doha", "STADIUM 947"));
        Vertex<Estadio> v6 = grafo.createVertex(new Estadio("Doha", "KHALIFA INTERNATIONAL STADIUM"));
        Vertex<Estadio> v7 = grafo.createVertex(new Estadio("Doha", "AL THUMAMA STADIUM"));
        Vertex<Estadio> v8 = grafo.createVertex(new Estadio("Wakrah", "AL JANOUB STADIUM"));
        
        grafo.connect(v1, v2, 42);
        grafo.connect(v2, v1, 42);
        grafo.connect(v2, v3, 24);
        grafo.connect(v3, v2, 24);
        grafo.connect(v2, v5, 52);
        grafo.connect(v5, v2, 52);
        grafo.connect(v3, v4, 11);
        grafo.connect(v4, v3, 11);
        grafo.connect(v4, v6, 8);
        grafo.connect(v6, v4, 8);
        grafo.connect(v6, v7, 12);
        grafo.connect(v7, v6, 12);
        grafo.connect(v7, v8, 12);
        grafo.connect(v8, v7, 12);
        grafo.connect(v8, v5, 19);
        grafo.connect(v5, v8, 19);
        
        Parcial5_repaso p = new Parcial5_repaso();
        
        System.out.println(p.estadios(grafo, "AI BAYT STADIUM", 100));
    }

}
