package repaso.grafos.parcial_2dafecha_tema1_2024;

import java.util.LinkedList;
import java.util.List;

import tp1.ej8.Queue;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class Parcial {
    
    public List<Data> invitacionMasterClass(Graph<String> red, String usuario, int distancia, int limite){
        List<Data> lista = new LinkedList<>();
        if (red != null && !red.isEmpty()){
            Vertex<String> origen = red.search(usuario);
            if (origen != null){
                boolean [] visitados = new boolean [red.getSize()];
                Queue<Vertex<String>> cola = new Queue<>();
                int dist = 0;
                cola.enqueue(origen);
                cola.enqueue(null);
                visitados[origen.getPosition()] = true;
                while (!cola.isEmpty() && dist <= distancia && lista.size() < limite){
                    Vertex<String> v = cola.dequeue();
                    if (v != null){
                        //visitados[v.getPosition()] = true; INCORRECTO
                        if (v.getData() != usuario)
                            lista.add(new Data(v.getData(), dist));
                        List<Edge<String>> edges = red.getEdges(v);
                        for (Edge<String> edge : edges){
                            if (!visitados[edge.getTarget().getPosition()]){
                                cola.enqueue(edge.getTarget());
                                visitados[edge.getTarget().getPosition()] = true;
                            }
                        }
                    } else {
                        if (!cola.isEmpty()){
                            cola.enqueue(null);
                            dist++;
                        }
                    }
                }
            }
        }
        return lista;
    }

}