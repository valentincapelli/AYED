package tp5.ej3;

import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.adjList.AdjListGraph;

public class TestEj3 {

	public static void main(String[] args) {
		Graph<String> mapaCiudades = new AdjListGraph<String>();
		
		Vertex<String> v1 = mapaCiudades.createVertex("Brandsen");
		Vertex<String> v2 = mapaCiudades.createVertex("Chascomus");
		Vertex<String> v3 = mapaCiudades.createVertex("La Plata");
		Vertex<String> v4 = mapaCiudades.createVertex("Jeppener");
		Vertex<String> v5 = mapaCiudades.createVertex("San Vicente");
		Vertex<String> v6 = mapaCiudades.createVertex("Belgrano");
		Vertex<String> v7 = mapaCiudades.createVertex("Lobos");
		
		// Es el grafo de caperucita roja pero con ciudades
		mapaCiudades.connect(v1, v3, 3);
		mapaCiudades.connect(v3, v1, 3);
		mapaCiudades.connect(v1, v2, 4);
		mapaCiudades.connect(v2, v1, 4);
		mapaCiudades.connect(v1, v4, 4);
		mapaCiudades.connect(v4, v1, 4);
		mapaCiudades.connect(v2, v5, 15);
		mapaCiudades.connect(v5, v2, 15);
		mapaCiudades.connect(v3, v5, 3);
		mapaCiudades.connect(v5, v3, 3);
		mapaCiudades.connect(v3, v4, 4);
		mapaCiudades.connect(v4, v3, 4);
		mapaCiudades.connect(v4, v5, 11);
		mapaCiudades.connect(v5, v4, 11);
		mapaCiudades.connect(v4, v6, 10);
		mapaCiudades.connect(v6, v4, 10);
		mapaCiudades.connect(v5, v7, 4);
		mapaCiudades.connect(v7, v5, 4);
		mapaCiudades.connect(v6, v7, 9);
		mapaCiudades.connect(v7, v6, 9);
		
		Mapa map = new Mapa(mapaCiudades);
		System.out.println("Lista primer camino que encuentra");
		System.out.println(map.devolverCamino("Brandsen","Lobos")); // informal mal
		
		
		System.out.println("Lista camino exceptuando");
		List<String> exceptuar = new LinkedList<String>();
        exceptuar.add("La Plata");
		System.out.println(map.devolverCaminoExceptuando("Brandsen","Lobos", exceptuar)); // informal mal
		
		
		System.out.println("Lista camino mas corto");
		//System.out.println(map.caminoMasCorto("Brandsen","Lobos")); // no anda
		
		
		System.out.println("Lista camino sin cargar combustible.");
		System.out.println(map.caminoSinCargarCombustible("Brandsen","Lobos", 0));  // informal mal
		
	}

}
