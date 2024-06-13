package tp5.ej6;

import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class BuscadorDeCaminos {
    Graph<String> grafo;

    public List <List <String>> recorridosMasSeguro(){
        List <List<String>> caminos = new LinkedList<>();
        if (!this.grafo.isEmpty()){
            List<String> aux = new LinkedList<>();
            boolean [] visitados = new boolean[grafo.getSize()];
            Vertex<String> origen = this.grafo.search("Casa caperucita");
            if (origen != null)
                recursividad(origen, visitados, aux, caminos); 
        }
    }

    private void recursividad(Vertex<String> origen, boolean [] visitados, LinkedList<String> aux, LinkedList<LinkedList<String>> caminos){
        visitados[origen.getPosition()] = true;
        aux.add(origen.getData());
        if (origen.getData().equals("Casa abuelita"))
            caminos.add(new LinkedList<String>(aux));
        else{
            for (Edge<String> ady : this.grafo.getEdges(origen)){
                Vertex<String> dest = ady.getTarget();
                if(!visitados[dest.getPosition()] && ady.getWeight() < 5)
                    recursividad(dest, visitados, aux, caminos);
            }
        }
        visitados[origen.getPosition()] = false;
        aux.remove(aux.size()-1);
    }
    
}
