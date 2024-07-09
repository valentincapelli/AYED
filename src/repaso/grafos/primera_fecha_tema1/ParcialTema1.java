package repaso.grafos.primera_fecha_tema1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.adjList.AdjListGraph;

public class ParcialTema1 {
    
    
    public Integer resolver(Graph<Data> sitios, int tiempo){
        List<Data> result = new LinkedList<>();
        if (sitios != null && !sitios.isEmpty()){
            Vertex<Data> origen = buscar(sitios,"Entrada");
            boolean [] visitados = new boolean[sitios.getSize()];
            if (origen != null && tiempo > origen.getData().getMinutos())
                contarSitios(sitios, origen, (tiempo - origen.getData().getMinutos()), visitados, result, new LinkedList<Data>());
        }
        return result.size();
    }


    private Vertex<Data> buscar(Graph<Data> sitios, String nombre){
        List<Vertex<Data>> vertices = sitios.getVertices();
        Iterator<Vertex<Data>> it = vertices.iterator();
        Vertex<Data> dat = null;
        boolean sigo = true;
        while (it.hasNext() && sigo){
            Vertex<Data> aux = it.next();
            if (aux.getData().getNombre().equals(nombre)){
                dat = aux;
                sigo = false;
            }
        }
        return dat;
    }


    private void contarSitios(Graph<Data> sitios, Vertex<Data> origen, int tiempo, boolean [] visitados, List<Data> listaFinal, List<Data> listaActual){
        visitados[origen.getPosition()] = true;
        listaActual.add(origen.getData());
        List<Edge<Data>> edges = sitios.getEdges(origen);
        for (Edge<Data> edge : edges){
            if (!visitados[edge.getTarget().getPosition()])
                if (tiempo >= (edge.getWeight() + edge.getTarget().getData().getMinutos()))
                    contarSitios(sitios, edge.getTarget(), (tiempo - (edge.getWeight() + edge.getTarget().getData().getMinutos())), visitados, listaFinal, listaActual);
        }
        if (listaActual.size() > listaFinal.size()){
            listaFinal.clear();
            listaFinal.addAll(listaActual);
        }
        listaActual.removeLast();
        visitados[origen.getPosition()] = false;
    }

    public static void imprimirGrafoFormato(AdjListGraph<Data> graph) {
    Map<String, String> nodePositions = new HashMap<>();
    
    // Definir las posiciones relativas de los nodos en el grafo
    nodePositions.put("Entrada", "Entrada");
    nodePositions.put("Flamencos", "  Flamencos");
    nodePositions.put("Murciélagos", "    Murciélagos");
    nodePositions.put("Tigres", "    Tigres");
    nodePositions.put("Wallabies", "      Wallabies");
    nodePositions.put("Cebras", "  Cebras");
    nodePositions.put("Tortugas", "        Tortugas");
    nodePositions.put("Pumas", "          Pumas");

    // Crear una lista para mantener las conexiones que ya se imprimieron y evitar duplicados
    Set<String> conexionesImpresas = new HashSet<>();

    for (Vertex<Data> vertex : graph.getVertices()) {
        String nodoOrigen = vertex.getData().getNombre();
        if (!nodePositions.containsKey(nodoOrigen)) {
            continue;
        }

        for (Edge<Data> edge : graph.getEdges(vertex)) {
            String nodoDestino = edge.getTarget().getData().getNombre();
            String conexion = nodoOrigen + " -> " + nodoDestino;
            String conexionInversa = nodoDestino + " -> " + nodoOrigen;

            if (!conexionesImpresas.contains(conexion) && !conexionesImpresas.contains(conexionInversa)) {
                System.out.println(nodePositions.get(nodoOrigen) + " - " + edge.getWeight() + " min -> " + nodePositions.get(nodoDestino).trim());
                conexionesImpresas.add(conexion);
            }
        }
    }
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

        // Mostrar las conexiones del grafo
        // mostrarConexiones(zooGraph);
        imprimirGrafoFormato(zooGraph);
        ParcialTema1 p = new ParcialTema1();
        System.out.println(p.resolver(zooGraph, 100));
    }

    public static void mostrarConexiones(AdjListGraph<Data> graph) {
        for (Vertex<Data> vertex : graph.getVertices()) {
            System.out.println("Desde " + vertex.getData().getNombre() + " (" + vertex.getData().getMinutos() + " min):");
            for (Edge<Data> edge : graph.getEdges(vertex)) {
                System.out.println("  -> " + edge.getTarget().getData().getNombre() + " (" + edge.getTarget().getData().getMinutos() + " min) (Peso: " + edge.getWeight() + ")");
            }
        }
    }

}
