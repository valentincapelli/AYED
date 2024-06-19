package tp5.ej6;

import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.adjList.AdjListGraph;

public class BuscadorDeCaminos {
    private Graph<String> grafo;  // seria el bosque
    
    public BuscadorDeCaminos(Graph<String> grafo) {
        this.setBosque(grafo);
    }

    public Graph<String> getBosque() {
        return grafo;
    }

    public void setBosque(Graph<String> grafo) {
        this.grafo = grafo;
    }

    public List <List <String>> recorridosMasSeguro(){
        List <List<String>> caminos = new LinkedList<>(); // creamos la lista de caminos a devolver
        if (!this.grafo.isEmpty()){                       // si no esta vacio el arbol, analizamos
            List<String> aux = new LinkedList<>();        // creamos la lista auxiliar para ir haciendo los caminos
            boolean [] visitados = new boolean[grafo.getSize()];   // creamos el vector de booleanos con los vertices visitados
            Vertex<String> origen = this.grafo.search("Casa Caperucita");  // buscamos la casa de caperucita
            if (origen != null)                             // si se encuentra la casa de caperucita
                recursividad(origen, visitados, aux, caminos);  // buscamos los caminos en el grafo recursivamente
        }                                                       // pasamos por parametro el vertice origen, el vector de booleanos y las dos listas
        return caminos;
    }

    private void recursividad(Vertex<String> origen, boolean [] visitados, List<String> aux, List<List<String>> caminos){
        visitados[origen.getPosition()] = true;     // ponemos como visitado el vertice actual
        aux.add(origen.getData());                  // agregamos a la lista actual el nombre del vertice
        if (origen.getData().equals("Casa Abuelita"))   //  si se encuentra en el vertice "casa abuelita"
            caminos.add(new LinkedList<String>(aux));           // agrega la lista actual a la lista de caminos
        else{                                                   // sino
            for (Edge<String> ady : this.grafo.getEdges(origen)){   // para cada arista de la lista de aristas / lista de adyacencias
                Vertex<String> dest = ady.getTarget();              // asigna a dest lo que apunta la arista
                if(!visitados[dest.getPosition()] && ady.getWeight() < 5)  // si el vertice destino no fue visitado y la arista tiene un peso menor a 5
                    recursividad(dest, visitados, aux, caminos);        // seguimos la recursividad por el vertice destino
            }
        }
        visitados[origen.getPosition()] = false;   // se desmarca en el vector siempre, con origen
        aux.remove(aux.size()-1);   // se elimina de la lista actual siempre, con origen
    }
    public static void main (String[] args) {
		Graph<String> bosque = new AdjListGraph<String>();
        Vertex<String> v1 = bosque.createVertex("Casa Caperucita");
        Vertex<String> v2 = bosque.createVertex("Claro 3");
        Vertex<String> v3 = bosque.createVertex("Claro 1");
        Vertex<String> v4 = bosque.createVertex("Claro 2");
        Vertex<String> v5 = bosque.createVertex("Claro 5");
        Vertex<String> v6 = bosque.createVertex("Claro 4");
        Vertex<String> v7 = bosque.createVertex("Casa Abuelita");
        bosque.connect(v1, v2, 4);
        bosque.connect(v2, v1, 4);
        bosque.connect(v1, v3, 3);
        bosque.connect(v3, v1, 3);
        bosque.connect(v1, v4, 4);
        bosque.connect(v4, v1, 4);
        bosque.connect(v2, v5, 15);
        bosque.connect(v5, v2, 15);
        bosque.connect(v3, v5, 3);
        bosque.connect(v5, v3, 3);
        bosque.connect(v4, v3, 4);
        bosque.connect(v3, v4, 4);
        bosque.connect(v4, v5, 11);
        bosque.connect(v5, v4, 11);
        bosque.connect(v4, v6, 10);
        bosque.connect(v6, v4, 10);
        bosque.connect(v4, v3, 4);
        bosque.connect(v3, v4, 4);
        bosque.connect(v5, v7, 4);
        bosque.connect(v7, v5, 4);
        bosque.connect(v6, v7, 9);
        bosque.connect(v7, v6, 9);
        BuscadorDeCaminos bos = new BuscadorDeCaminos(bosque);
        List<List<String>> lis = bos.recorridosMasSeguro();
        for(List<String> l: lis) {
            System.out.println(l);
        }
    }
}
