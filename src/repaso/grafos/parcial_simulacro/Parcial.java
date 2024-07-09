package repaso.grafos.parcial_simulacro;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.adjList.AdjListGraph;

public class Parcial {
    
    public List<String> resolver(Graph<Data> mapa, String ciudad, int cantDiasVaca){
        List<String> camino = new LinkedList<>();
        if (mapa != null && !mapa.isEmpty()){
            Vertex<Data> origen = buscarVertice(mapa, ciudad);
            if (origen != null){
                if (origen.getData().GetDias() <= cantDiasVaca)
                    buscarCamino(mapa, origen, (cantDiasVaca - origen.getData().GetDias()), new boolean [mapa.getSize()], camino, new LinkedList<String>());
            }
        }
        return camino;
    }

    private void buscarCamino(Graph<Data> mapa, Vertex<Data> origen, int cantDiasVaca, boolean [] visitados, List<String> camino, List<String> listaActual){
        visitados[origen.getPosition()] = true;
        listaActual.add(origen.getData().getCiudad());
        List<Edge<Data>> edges = mapa.getEdges(origen);
        for (Edge<Data> edge : edges){
            Vertex<Data> dest = edge.getTarget();
            if (!visitados[dest.getPosition()] && cantDiasVaca >= dest.getData().GetDias())
                buscarCamino(mapa, dest, (cantDiasVaca - dest.getData().GetDias()), visitados, camino, listaActual);
        }
        if (listaActual.size() > camino.size()){
            camino.clear();
            camino.addAll(listaActual);
        }
        listaActual.removeLast();
        visitados[origen.getPosition()] = false;
    }

    private Vertex<Data> buscarVertice(Graph<Data> mapa, String ciudad){
        List<Vertex<Data>> vertices = mapa.getVertices();
        Iterator<Vertex<Data>> it = vertices.iterator();
        Vertex<Data> aux = null;
        while (it.hasNext() && aux == null){
            Vertex<Data> v = it.next();
            if (v.getData().getCiudad().equals(ciudad))
                aux = v;
        }
        return aux;
    }

    public static void main(String args[]) {
        Graph<Data> mapa = new AdjListGraph<Data>();
        Vertex<Data> MarDelPlata = mapa.createVertex(new Data(7, "Mar Del Plata"));
        Vertex<Data> Pila = mapa.createVertex(new Data(1, "Pila"));
        Vertex<Data> Dolores = mapa.createVertex(new Data(1, "Dolores"));
        Vertex<Data> Chascomus = mapa.createVertex(new Data(1, "Chascomús"));
        Vertex<Data> MarAzul = mapa.createVertex(new Data(3, "Mar Azul"));
        Vertex<Data> Pinamar = mapa.createVertex(new Data(4, "Pinamar"));
        Vertex<Data> Madariaga = mapa.createVertex(new Data(1, "Madariaga"));
        Vertex<Data> LaPlata = mapa.createVertex(new Data(5, "La Plata"));
        Vertex<Data> LasGaviotas = mapa.createVertex(new Data(1, "Las Gaviotas"));
        Vertex<Data> Querandi = mapa.createVertex(new Data(1, "Querandi"));
        Vertex<Data> Hudson = mapa.createVertex(new Data(1, "Hudson"));
        
        mapa.connect(MarDelPlata, Pila);
        mapa.connect(Pila, MarDelPlata);
        mapa.connect(Pila, Dolores);
        mapa.connect(Dolores, Pila);
        mapa.connect(Dolores, Chascomus);
        mapa.connect(Chascomus, Dolores);
        
        mapa.connect(MarDelPlata, MarAzul);
        mapa.connect(MarAzul, MarDelPlata);
        mapa.connect(MarAzul, Pinamar);
        mapa.connect(Pinamar, MarAzul);
        mapa.connect(Pinamar, Madariaga);
        mapa.connect(Madariaga, Pinamar);
        mapa.connect(Dolores, Madariaga);
        mapa.connect(Madariaga, Dolores);
        mapa.connect(Madariaga, LaPlata);
        mapa.connect(LaPlata, Madariaga);
        mapa.connect(Chascomus, LaPlata);
        mapa.connect(LaPlata, Chascomus);
        
        mapa.connect(MarAzul, LasGaviotas);
        mapa.connect(LasGaviotas, MarAzul);
        mapa.connect(MarAzul, Querandi);
        mapa.connect(Querandi, MarAzul);
        mapa.connect(LaPlata, Hudson);
        mapa.connect(Hudson, LaPlata);
        
        Parcial p = new Parcial();
        System.out.println(p.resolver(mapa, "Mar Del Plata", 15));
    }

}
