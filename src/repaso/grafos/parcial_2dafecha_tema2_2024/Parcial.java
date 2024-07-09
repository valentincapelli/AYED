package repaso.grafos.parcial_2dafecha_tema2_2024;

import java.util.List;

import tp1.ej8.Queue;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class Parcial {
    
    public Data nivelPopularidad(Graph<String> red, String usuario, int distancia, int umbral){
        Data d = null;
        if (red != null && !red.isEmpty()){
            Vertex<String> origen = red.search(usuario);
            if (origen != null){
                boolean [] visitados = new boolean [red.getSize()];
                Queue<Vertex<String>> cola = new Queue<>();
                int cant = 0;
                int dist = 0;
                cola.enqueue(origen);
                cola.enqueue(null);
                visitados[origen.getPosition()] = true;
                while (!cola.isEmpty() && dist <= distancia){
                    Vertex<String> v = cola.dequeue();
                    if (v != null){
                        //visitados[v.getPosition()] = true; INCORRECTO
                        if (dist == distancia)
                            cant++;
                        List<Edge<String>> edges = red.getEdges(v);
                        for (Edge<String> edge : edges){
                            if (!visitados[edge.getTarget().getPosition()])
                                visitados[edge.getTarget().getPosition()] = true;
                                cola.enqueue(edge.getTarget());
                        }
                    } else {
                        if (!cola.isEmpty()){
                            cola.enqueue(null);
                            dist++;
                        }
                    }
                }
                d = new Data(cant, (cant >= umbral));
            }
        }
        return d;
    }

}