package repaso.grafos.primera_fecha_tema1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.adjList.AdjListGraph;

public class ParcialTema1_repaso {
    
    public int resolver(Graph<Data> sitios, int tiempo){
        LinkedList<String> lista = new LinkedList<>();
        if (sitios != null & !sitios.isEmpty()){
            Vertex<Data> origen = buscarVertice(sitios, "Entrada");
            if (origen != null){
                if (tiempo >= origen.getData().getMinutos()){
                    contarSitios(sitios, origen, (tiempo - origen.getData().getMinutos()), new boolean [sitios.getSize()], lista, new LinkedList<String>());
                }
            }
        }
        System.out.println(lista);
        return lista.size();
    }

    private void contarSitios(Graph<Data> sitios, Vertex<Data> origen, int tiempo, boolean [] visitados, LinkedList<String> lista, LinkedList<String> listaActual){
        visitados[origen.getPosition()] = true;
        listaActual.add(origen.getData().getNombre());
        List<Edge<Data>> edges = sitios.getEdges(origen);
        for(Edge<Data> edge : edges){
            Vertex<Data> v = edge.getTarget();
            if (!visitados[v.getPosition()] && (tiempo > edge.getWeight() + v.getData().getMinutos()))
                contarSitios(sitios, v, (tiempo - edge.getWeight() - v.getData().getMinutos()), visitados, lista, listaActual);
        }
        if (listaActual.size() > lista.size()){
            lista.clear();
            lista.addAll(listaActual);
        }
        listaActual.removeLast();
        visitados[origen.getPosition()] = false;
    }

    private Vertex<Data> buscarVertice(Graph<Data> sitios, String vertice){
        List<Vertex<Data>> vertices = sitios.getVertices();
        Vertex<Data> v = null;
        Iterator<Vertex<Data>> it = vertices.iterator();
        while (it.hasNext() && v == null){
            Vertex<Data> aux = it.next();
            if (aux.getData().getNombre().equals(vertice))
                v = aux;
        }
        return v;
    }

    public static void main(String[] args) {
        AdjListGraph<Data> zooGraph = new AdjListGraph<>();

        // Creación de los vértices con instancias de la clase Data
        Vertex<Data> entrada = zooGraph.createVertex(new Data("Entrada", 15));
        Vertex<Data> flamencos = zooGraph.createVertex(new Data("Flamencos", 10));
        Vertex<Data> tigres = zooGraph.createVertex(new Data("Tigres", 10));
        Vertex<Data> cebras = zooGraph.createVertex(new Data("Cebras", 10));
        Vertex<Data> tortugas = zooGraph.createVertex(new Data("Tortugas", 10));
        Vertex<Data> pumas = zooGraph.createVertex(new Data("Pumas", 10));
        Vertex<Data> murcielagos = zooGraph.createVertex(new Data("Murciélagos", 20));
        Vertex<Data> wallabies = zooGraph.createVertex(new Data("Wallabies", 30));

        // Conexiones desde Entrada
        zooGraph.connect(entrada, flamencos, 25);
        zooGraph.connect(entrada, tigres, 15);
        zooGraph.connect(entrada, cebras, 10);
        zooGraph.connect(entrada, murcielagos, 20);

        // Conexiones desde Flamencos
        zooGraph.connect(flamencos, murcielagos, 25);
        zooGraph.connect(flamencos, entrada, 20);

        // Conexiones desde Tigres
        zooGraph.connect(tigres, cebras, 8);
        zooGraph.connect(tigres, entrada, 15);

        // Conexiones desde Cebras
        zooGraph.connect(cebras, tortugas, 5);
        zooGraph.connect(cebras, tigres, 8);
        zooGraph.connect(cebras, entrada, 10);

        // Conexiones desde Tortugas
        zooGraph.connect(tortugas, pumas, 15);
        zooGraph.connect(tortugas, wallabies, 10);
        zooGraph.connect(tortugas, cebras, 5);

        // Conexiones desde Pumas
        zooGraph.connect(pumas, tortugas, 15);

        // Conexiones desde Wallabies
        zooGraph.connect(wallabies, tortugas, 10);
        zooGraph.connect(wallabies, murcielagos, 10);

        // Conexiones desde Murcielagos
        zooGraph.connect(murcielagos, wallabies, 10);
        zooGraph.connect(murcielagos, entrada, 20);
        zooGraph.connect(murcielagos, flamencos, 25);

        ParcialTema1_repaso p = new ParcialTema1_repaso();
        System.out.println(p.resolver(zooGraph, 1200));
    }

}
