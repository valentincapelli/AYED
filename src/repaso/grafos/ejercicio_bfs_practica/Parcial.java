package repaso.grafos.ejercicio_bfs_practica;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tp1.ej8.Queue;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.adjList.AdjListGraph;

public class Parcial {
    
    public List<String> buscarJubilados(Graph<Persona> grafo, String empleado, int grado){
        List<String> lista = new LinkedList<>();
        if (grafo != null && !grafo.isEmpty()){
            Vertex<Persona> origen = buscarPersona(grafo, empleado);
            if (origen != null){
                boolean [] visitados = new boolean[grafo.getSize()];
                int nivel = 0;
                Queue<Vertex<Persona>> cola = new Queue<>();
                cola.enqueue(origen);
                cola.enqueue(null);
                visitados[origen.getPosition()] = true;
                while(!cola.isEmpty() && nivel <= grado && lista.size() < 40){
                    Vertex<Persona> vertice = cola.dequeue();
                    if (vertice != null){
                        if (vertice.getData().getTipo() == "Jubilado" && !vertice.getData().getCobro())
                            lista.add(vertice.getData().getNombre());
                        List<Edge<Persona>> edges = grafo.getEdges(vertice);
                        for(Edge<Persona> edge : edges){
                            Vertex<Persona> dest = edge.getTarget();
                            if (!visitados[dest.getPosition()]){
                                visitados[dest.getPosition()] = true;
                                cola.enqueue(dest);
                            }

                        }
                    } else {
                        if(!cola.isEmpty()){
                            cola.enqueue(null);
                            nivel++;
                        }
                    }
                }
            }
        }
        return lista;
    }

    private Vertex<Persona> buscarPersona(Graph<Persona> grafo, String empleado){
        List<Vertex<Persona>> vertices = grafo.getVertices();
        Iterator<Vertex<Persona>> it  = vertices.iterator();
        Vertex<Persona> v = null;
        while (it.hasNext() && v == null){
            Vertex<Persona> aux = it.next();
            if (aux.getData().getNombre() == empleado)
                v = aux;
        }
        return v;
    }

    public static void main(String[] args) {
        Graph<Persona> grafo = new AdjListGraph<>();
        Vertex v1 = grafo.createVertex(new Persona("Empleado", "Matias", true));
        Vertex v2 = grafo.createVertex(new Persona("Jubilado", "Julian", false));
        Vertex v3 = grafo.createVertex(new Persona("Jubilado", "Francisco",  false));
        Vertex v4 = grafo.createVertex(new Persona("Empleado", "Valentin",  true));
        Vertex v5 = grafo.createVertex(new Persona("Jubilado", "Omar",  true));
        Vertex v6 = grafo.createVertex(new Persona("Empleado", "Rosana", true));
        Vertex v7 = grafo.createVertex(new Persona("Jubilado", "Maria",  false));
        Vertex v8 = grafo.createVertex(new Persona("Jubilado", "Sandra",  true));
        Vertex v9 = grafo.createVertex(new Persona("Jubilado", "Matheo",  false));
        
        grafo.connect(v1, v2);
        grafo.connect(v2, v1);
        grafo.connect(v2, v3);
        grafo.connect(v3, v2);
        
        grafo.connect(v1, v9);
        grafo.connect(v9, v1);
        grafo.connect(v9, v8);
        grafo.connect(v8, v9);
        
        grafo.connect(v1, v4);
        grafo.connect(v4, v1);
        grafo.connect(v1, v6);
        grafo.connect(v6, v1);
        grafo.connect(v4, v5);
        grafo.connect(v5, v4);
        grafo.connect(v5, v7);
        grafo.connect(v7, v5);
        
        
        Parcial p = new Parcial();

        
        //System.out.println(banco.carteraJubilados(grafo, "Matias", 1, 40));
        System.out.println(p.buscarJubilados(grafo, "Matias", 2));
        //System.out.println(banco.carteraJubilados(grafo, "Matias", 3, 40));
        
        //System.out.println(banco.carteraJubilados(grafo, "Rosana", 2, 40));
        
        //System.out.println(banco.carteraJubilados(grafo, "Matias", 2, 1));
    }

}
