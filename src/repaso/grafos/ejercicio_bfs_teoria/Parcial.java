package repaso.grafos.ejercicio_bfs_teoria;


import java.util.List;

import tp1.ej8.Queue;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class Parcial {
    
    public int calcularInfeccion(Graph<String> grafo, String compuInfectada){
        int minutos = 0;
        if (grafo != null && !grafo.isEmpty()){
            Vertex<String> origen = grafo.search(compuInfectada);
            if (origen != null){
                Queue<Vertex<String>> cola = new Queue<>();
                boolean [] visitados = new boolean [grafo.getSize()];
                cola.enqueue(origen);
                cola.enqueue(null);
                visitados[origen.getPosition()] = true;
                while (!cola.isEmpty()){
                    Vertex<String> vertice = cola.dequeue();
                    if (vertice != null){
                        List<Edge<String>> edges = grafo.getEdges(vertice);
                        for(Edge<String> edge : edges){
                            Vertex<String> dest = edge.getTarget();
                            if (!visitados[dest.getPosition()]){
                                visitados[dest.getPosition()] = true;
                                cola.enqueue(dest);
                            }
                        }
                    } else {
                        if (!cola.isEmpty()){
                            cola.enqueue(null);
                            minutos++;
                        }
                    }
                }
            }
        }
        return minutos;
    }

}
