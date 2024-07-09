package repaso.grafos;

import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class BuscadorDeCaminos {
    Graph<String> bosque;

    public List<List<String>> recorridosMasSeguro(){
        List<List<String>> caminos = new LinkedList<>();
        if (bosque != null && !bosque.isEmpty()){
            Vertex<String> origen = bosque.search("Casa Caperucita");
            if (origen != null){
                boolean visitados[] = new boolean[bosque.getSize()];
                buscarCaminos(origen, visitados, caminos, new LinkedList<String>());
            }
        }
        return caminos;
    }

    private void buscarCaminos(Vertex<String> origen, boolean visitados[], List<List<String>> caminos, LinkedList<String> caminoActual){
        visitados[origen.getPosition()] = true;
        caminoActual.add(origen.getData());
        if(origen.getData().equals("Casa Abuelita"))
            caminos.add(new LinkedList<String>(caminoActual));
        else{
            List<Edge<String>> edges = this.bosque.getEdges(origen);
            for (Edge<String> ady : edges){
                if (!visitados[ady.getTarget().getPosition()] && ady.getWeight() < 5 )
                    buscarCaminos(ady.getTarget(), visitados, caminos, caminoActual);
            }
        }
        visitados[origen.getPosition()] = false;
        caminoActual.removeLast();
    }
}
