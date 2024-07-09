package repaso.grafos;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class VisitaOslo {
    
    public List<String> paseoEnBici(Graph<String> lugares, String destino,  int maxTiempo, List<String> lugaresRestringidos){
        List<String> camino = new LinkedList<String>();
        if (!lugares.isEmpty()){
            Vertex<String> origen = lugares.search("Ayuntamiento");
            boolean visitados [] = new boolean [lugares.getSize()];
            if (origen != null)
                busquedaRecursiva(lugares, origen, destino, maxTiempo, lugaresRestringidos, visitados, camino);
        }
        return camino;
    }

    private boolean busquedaRecursiva(Graph<String> lugares, Vertex<String> origen, String destino, int maxTiempo, List<String> lugaresRestringidos, boolean [] visitados, List<String> camino){
        boolean cumple = false;
        visitados[origen.getPosition()] = true;
        camino.add(origen.getData());
        if (origen.getData().equals(destino))
            cumple = true;
        else {
            List<Edge<String>> ady = lugares.getEdges(origen);
            Iterator<Edge<String>> it = ady.iterator();
            while (it.hasNext() && !cumple){
                Edge<String> dest = it.next();
                if(!visitados[dest.getTarget().getPosition()] && (maxTiempo - dest.getWeight() >= 0) && !lugaresRestringidos.contains(dest.getTarget().getData()))
                    cumple = busquedaRecursiva(lugares, dest.getTarget(), destino, (maxTiempo - dest.getWeight()), lugaresRestringidos, visitados, camino);
            }
        }
        if (!cumple)
            camino.removeLast();
        visitados[origen.getPosition()] = false;
        return cumple;
    }    
}
