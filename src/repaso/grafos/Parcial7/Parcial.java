package repaso.grafos.Parcial7;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class Parcial {
    
    public  List<String> recorrido(Graph<String> grafo, int cantLocalidades, int cantNafta, List<String> localidadesExceptuadas){
        LinkedList<String> camino = new LinkedList<>();
        if (grafo != null && !grafo.isEmpty()){
            Vertex<String> origen = grafo.search("Mendoza");
            if (origen != null)
                buscarCamino(grafo, origen, cantLocalidades, cantNafta, localidadesExceptuadas, new boolean [grafo.getSize()], camino);
        }
        return camino;
    }

    private boolean buscarCamino(Graph<String> grafo, Vertex<String> origen, int cantLocalidades, int cantNafta, List<String> localidadesExceptuadas, boolean [] visitados, LinkedList<String> camino){
        boolean ok = false;
        visitados[origen.getPosition()] = true;
        camino.add(origen.getData());
        cantLocalidades--;
        if (cantLocalidades == 0)
            ok = true;
        else{
            List<Edge<String>> aristas = grafo.getEdges(origen);
            Iterator<Edge<String>> it =  aristas.iterator();
            while (it.hasNext() && !ok){
                Edge<String> e = it.next();
                Vertex<String> v = e.getTarget(); 
                if (!visitados[v.getPosition()] && cantNafta > e.getWeight() && !localidadesExceptuadas.contains(v.getData())) 
                    ok = buscarCamino(grafo, v, cantLocalidades, (cantNafta - e.getWeight()), localidadesExceptuadas, visitados, camino);
            }
        }
        if (!ok)
            camino.removeLast();
        return ok;
    }

}
