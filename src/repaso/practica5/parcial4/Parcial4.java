package repaso.practica5.parcial4;

import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.adjList.AdjListGraph;

public class Parcial4 {
    
    public List<Data> resolver(Graph<String> sitios, String origen, String destino, List<String> evitarPasarPor){
        LinkedList<Data> caminos = new LinkedList<>();
        if (sitios != null & !sitios.isEmpty()){
            Vertex<String> verticeOrigen = sitios.search(origen);
            Vertex<String> verticeDestino = sitios.search(destino);
            if (verticeOrigen != null && verticeDestino != null){
                boolean [] visitados = new boolean [sitios.getSize()];
                if (!evitarPasarPor.contains(verticeOrigen.getData()))
                    buscarCaminos(sitios, verticeOrigen, verticeDestino, visitados, evitarPasarPor, caminos, new LinkedList<String>(), 0); // lista actual y conteo de cuadras
            }
        }
        return caminos;
    }

    private void buscarCaminos(Graph<String> sitios, Vertex<String> origen, Vertex<String> destino, boolean [] visitados, List<String> evitarPasarPor, LinkedList<Data> caminos, LinkedList<String> listaActual,int cuadras){
        visitados[origen.getPosition()] = true;
        listaActual.add(origen.getData());
        if (origen.getData().equals(destino.getData()))
            caminos.add(new Data(new LinkedList<String>(listaActual), cuadras));
        else{
            List<Edge<String>> edges = sitios.getEdges(origen);
            for (Edge<String> edge : edges){
                Vertex<String> dest = edge.getTarget();
                int peso = edge.getWeight();
                if (!visitados[dest.getPosition()] && !evitarPasarPor.contains(dest.getData()))
                    buscarCaminos(sitios, dest, destino, visitados, evitarPasarPor, caminos, listaActual, (cuadras + peso));
            }
        }
        listaActual.removeLast();
        visitados[origen.getPosition()] = false;
    }

    public static void main(String args[]) {
        Graph<String> grafo = new AdjListGraph<String>();
        Vertex<String> v1 = grafo.createVertex("Estadio Diego Armando Maradona");
        Vertex<String> v2 = grafo.createVertex("Legislatura");
        Vertex<String> v3 = grafo.createVertex("Coliseo Podestá");
        Vertex<String> v4 = grafo.createVertex("MACLA");
        Vertex<String> v5 = grafo.createVertex("Catedral La Plata");
        Vertex<String> v6 = grafo.createVertex("Palacio Campodónico");
        Vertex<String> v7 = grafo.createVertex("Rectorado UNLP");
        Vertex<String> v8 = grafo.createVertex("Museo UNLP");
        
        grafo.connect(v1, v2, 25);
        grafo.connect(v2, v1, 25);
        grafo.connect(v1, v3, 20);
        grafo.connect(v3, v1, 20);
        grafo.connect(v1, v4, 35);
        grafo.connect(v4, v1, 35);
        grafo.connect(v1, v5, 40);
        grafo.connect(v5, v1, 40);
        grafo.connect(v2, v3, 25);
        grafo.connect(v3, v2, 25);
        grafo.connect(v4, v5, 8);
        grafo.connect(v5, v4, 8);
        grafo.connect(v5, v7, 5);
        grafo.connect(v7, v5, 5);
        grafo.connect(v3, v6, 10);
        grafo.connect(v6, v3, 10);
        grafo.connect(v6, v7, 30);
        grafo.connect(v7, v6, 30);
        grafo.connect(v7, v8, 15);
        grafo.connect(v8, v7, 15);
        
        List<String> evitarPasarPor = new LinkedList<String>();
        evitarPasarPor.add("Legislatura");
        evitarPasarPor.add("MACLA");
        
        Parcial4 p = new Parcial4();
        List<Data> lis = p.resolver(grafo, "Estadio Diego Armando Maradona", "Palacio Campodónico", evitarPasarPor);
        
        for(Data aux: lis) {
            System.out.println(aux);
        }
    }

}
