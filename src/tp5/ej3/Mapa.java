package tp5.ej3;

import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class Mapa {
	Graph<String> mapaCiudades;
	
	public List<String> devolverCamino(String ciudad1, String ciudad2){
		List<String> lista = new LinkedList<String>();
		buscarCiudad(mapaCiudades, ciudad1, ciudad2, lista);
		return lista;
	}
	
	private void buscarCiudad(Graph<String> grafo, String ciudad1, String ciudad2, List<String> listaFinal){
		boolean [] visitados = new boolean [grafo.getSize()];
		Vertex<String> city1 = grafo.search(ciudad1);
		List<String> listaActual = new LinkedList<String>();
		dfs1(grafo, city1, ciudad2, listaFinal, listaActual, visitados);
	}
	
	private void dfs1(Graph<String> grafo, Vertex<String> v, String ciudad2, List<String> listaFinal, List<String> listaActual, boolean [] visitados) {
		if(v.getData() == ciudad2) {
			listaFinal.addAll(listaActual);
		}
		else{
	 		listaActual.add(v.getData());
	 		visitados[v.getPosition()] = true;
		 	// Pido adyacentes
		 	List<Edge<String>> ady = grafo.getEdges(v);
		 	for(Edge<String> edge : ady){
		 		// Vertice destino de la arista
		 		Vertex<String> destino = edge.getTarget();
		 		if(!visitados[destino.getPosition()]){
		 			dfs1(grafo, destino, ciudad2, listaFinal, listaActual, visitados);
		 		}
		 	}
		 	listaActual.remove(listaActual.size()-1);
		}
	}
	
	public List<String> devolverCaminoExceptuando (String ciudad1, String ciudad2, List<String> ciudades){
		List<String> lista = new LinkedList<String>();
		buscarCiudadExceptuando(mapaCiudades, ciudad1, ciudad2, ciudades, lista);
		return lista;
	}
	
	private void buscarCiudadExceptuando(Graph<String> grafo, String ciudad1, String ciudad2, List<String> ciudades, List<String> listaFinal){
		boolean [] visitados = new boolean [grafo.getSize()];
		Vertex<String> city1 = grafo.search(ciudad1);
		List<String> listaActual = new LinkedList<String>();
		dfs2(grafo, city1, ciudad2, listaFinal, listaActual, visitados, ciudades);
	}
	
	private boolean Contiene(List<String> ciudades, String Ciudad) {
		for (String city: ciudades) {
			if (city.equals(Ciudad)) return true;
		}
		return false;
	}
	
	private void dfs2(Graph<String> grafo, Vertex<String> v, String ciudad2, List<String> listaFinal, List<String> listaActual, boolean [] visitados, List<String> ciudades) {
		if(v.getData() == ciudad2) {
			listaFinal.addAll(listaActual);
		}
		else{
			if (!Contiene(ciudades, v.getData())) {
				listaActual.add(v.getData());
				visitados[v.getPosition()] = true;
			}
		 	// Pido adyacentes
		 	List<Edge<String>> ady = grafo.getEdges(v);
		 	for(Edge<String> edge : ady){
		 		// Vertice destino de la arista
		 		Vertex<String> destino = edge.getTarget();
		 		if(!visitados[destino.getPosition()]){
		 			dfs2(grafo, destino, ciudad2, listaFinal, listaActual, visitados,ciudades);
		 		}
		 	}
		 	listaActual.remove(listaActual.size()-1);
		}
	}

}
