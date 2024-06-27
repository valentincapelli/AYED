package tp5.ej5;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tp1.ej8.Queue;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.adjList.AdjListGraph;

public class BancoItau {
	
	public List<Persona> devolverJubilados(Graph<Persona> grafo, Persona empleado, int grado){
		List<Persona> jubilados = new LinkedList<Persona>();
		if (!grafo.isEmpty()){
			Vertex<Persona> verticeEmpleado = buscarEmpleado(grafo, empleado);
			if (empleado != null){
				Queue<Vertex<Persona>> cola = new Queue<Vertex<Persona>>();
				boolean [] visitados = new boolean[grafo.getSize()];

				cola.enqueue(verticeEmpleado);
				cola.enqueue(null);
				
				int nivel = 0;
				visitados[verticeEmpleado.getPosition()] = true;
				while(!cola.isEmpty() && nivel <= grado && jubilados.size() <= 40){
					Vertex<Persona> vertice = cola.dequeue();
					if (vertice != null){
						//visitados[vertice.getPosition()] = true;
						if (nivel <= grado && vertice.getData().getTipo() == "Jubilado" && !vertice.getData().isCobro() && jubilados.size() <= 40){
							jubilados.add(vertice.getData());
						}
						List<Edge<Persona>> edges = grafo.getEdges(vertice);
						for (Edge<Persona> arista : edges){
							Vertex<Persona> destino = arista.getTarget();
							if (!visitados[destino.getPosition()]){
								visitados[destino.getPosition()] = true;
								cola.enqueue(destino);
							}
						}
					}else{
						if (!cola.isEmpty()){
							nivel++;
							cola.enqueue(null);
						}
					}
				}
			}
			
		}
		return jubilados;
	}

	private Vertex<Persona> buscarEmpleado(Graph<Persona> grafo, Persona empleado){
		boolean ok = false;
		Vertex<Persona> vertice = null;

		List<Vertex<Persona>> vertices = grafo.getVertices();
		Iterator<Vertex<Persona>> iter = vertices.iterator();

		while (iter.hasNext() && !ok){
			Vertex<Persona> v = iter.next();
			if (v.getData().getNombre().equals(empleado.getNombre())){
				ok = true;
				vertice = v;
			}
		}
		return vertice;
	}

	public static void main(String[] args) {
        Graph<Persona> grafo = new AdjListGraph<>();
        Vertex<Persona> v1 = grafo.createVertex(new Persona("Empleado", "Matias", true));
        Vertex<Persona> v2 = grafo.createVertex(new Persona("Jubilado", "Julian", false));
        Vertex<Persona> v3 = grafo.createVertex(new Persona("Jubilado", "Francisco", false));
        Vertex<Persona> v4 = grafo.createVertex(new Persona("Empleado", "Valentin", true));
        Vertex<Persona> v5 = grafo.createVertex(new Persona("Jubilado", "Omar", true));
        Vertex<Persona> v6 = grafo.createVertex(new Persona("Empleado", "Rosana", true));
        Vertex<Persona> v7 = grafo.createVertex(new Persona("Jubilado", "Maria", false));
        Vertex<Persona> v8 = grafo.createVertex(new Persona("Jubilado", "Sandra", true));
        Vertex<Persona> v9 = grafo.createVertex(new Persona("Jubilado", "Matheo", false));
        
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
        
        
        BancoItau banco = new BancoItau();
        
		Persona cabrilla = new Persona("Empleado", "Matias", true);

        //System.out.println(banco.carteraJubilados(grafo, "Matias", 1, 40));
        System.out.println(banco.devolverJubilados(grafo, cabrilla, 2));
        //System.out.println(banco.carteraJubilados(grafo, "Matias", 3, 40));
        
        //System.out.println(banco.carteraJubilados(grafo, "Rosana", 2, 40));
        
        //System.out.println(banco.carteraJubilados(grafo, "Matias", 2, 1));
    }
}