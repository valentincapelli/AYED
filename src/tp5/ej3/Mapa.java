package tp5.ej3;

import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import java.util.Iterator;

public class Mapa {
	Graph<String> mapaCiudades;
	
	public Mapa(Graph<String> mapa) {
        this.setMapaCiudades(mapa);
    }

    public Graph<String> getMapaCiudades() {
        return mapaCiudades;
    }

    public void setMapaCiudades(Graph<String> mapaCiudades) {
        this.mapaCiudades = mapaCiudades;
    }

	 ///-------------------------------------1-------------------------------------/
	public List<String> devolverCamino(String ciudad1, String ciudad2){
		List<String> listaFinal = new LinkedList<String>();
		boolean [] visitados = new boolean [mapaCiudades.getSize()];
		Vertex<String> origen = mapaCiudades.search(ciudad1);
		Vertex<String> destino = mapaCiudades.search(ciudad2);
		if (origen != null && destino != null)
			devolverJourney(origen, destino, listaFinal, visitados);
		return listaFinal;
	}
	
	
	private boolean devolverJourney( Vertex<String> origen, Vertex<String> destino, List<String> camino, boolean [] visitados) {
		boolean encontre = false;
		camino.add(origen.getData());
	 	visitados[origen.getPosition()] = true;
		if (origen == destino)
			return true;
		else{ 
			List<Edge<String>> ady = this.mapaCiudades.getEdges(origen);
            Iterator<Edge<String>> it = ady.iterator();
			while (it.hasNext() && !encontre){
				Vertex<String> v = it.next().getTarget();
				if (!visitados[v.getPosition()])
					encontre = devolverJourney(v, destino, camino, visitados);
			}
		}
		if (!encontre)
			camino.remove(camino.size()-1);
		return encontre;
	}
	///-------------------------------------2-------------------------------------/
	public List<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, List <String> ciudades){
		List<String> listaFinal = new LinkedList<String>();
		boolean [] visitados = new boolean [mapaCiudades.getSize()];
		Vertex<String> origen = mapaCiudades.search(ciudad1);
		Vertex<String> destino = mapaCiudades.search(ciudad2);
		if (origen != null && destino != null)
			devolverJourneyExceptuando(origen, destino, listaFinal, visitados, ciudades);
		return listaFinal;
	}
	
	private boolean devolverJourneyExceptuando( Vertex<String> origen, Vertex<String> destino, List<String> camino, boolean [] visitados, List<String> ciudades) {
		boolean encontre = false;
		if (!Contiene(ciudades, origen.getData())) {
			camino.add(origen.getData());
		}
		visitados[origen.getPosition()] = true;
		if (origen == destino)
			return true;
		else{ 
			List<Edge<String>> ady = this.mapaCiudades.getEdges(origen);
            Iterator<Edge<String>> it = ady.iterator();
			while (it.hasNext() && !encontre){
				Vertex<String> v = it.next().getTarget();
				if (!visitados[v.getPosition()])
					encontre = devolverJourneyExceptuando(v, destino, camino, visitados, ciudades);
			}
		}
		if (!encontre)
			camino.remove(camino.size()-1);
		return encontre;
	}
	
	private boolean Contiene(List<String> ciudades, String Ciudad) {
		boolean result = false;
		Iterator <String> it = ciudades.iterator();
			while (it.hasNext() && !result){
			if (it.next().equals(Ciudad)) result = true;
		}
		return result;
	}
	
	///-------------------------------------3-------------------------------------/
    // mi forma, a consultar
	
	/*public List<String> caminoMasCorto(String ciudad1, String ciudad2){
		List<String> lista = new LinkedList<String>();
		boolean [] visitados = new boolean [mapaCiudades.getSize()];
		Vertex<String> origen = mapaCiudades.search(ciudad1);
		Vertex<String> destino = mapaCiudades.search(ciudad2);
		DistanciaMinima min = new DistanciaMinima(Integer.MAX_VALUE);
		if (origen != null && destino != null)
			shortestPath(origen, destino, visitados, lista, new LinkedList<>(), 0, min);
		return lista;
	}

	private void shortestPath(Vertex<String> v, Vertex<String> destino , boolean [] visitados, List<String> listaFinal, List<String> listaActual, int distancia, DistanciaMinima min) {
		if(v == destino){
			if (distancia < min.getMinDistancia())
				min.setMinDistancia(distancia); 
				listaFinal.clear();
				listaFinal.addAll(listaActual);
		}
		else{
			listaActual.add(v.getData());
			visitados[v.getPosition()] = true;
			}
		 	// Pido adyacentes
		 	List<Edge<String>> ady = mapaCiudades.getEdges(v);
		 	for(Edge<String> edge : ady){
		 		// Vertice destino de la arista
		 		Vertex<String> dest = edge.getTarget();
		 		if(!visitados[dest.getPosition()]){
					shortestPath(dest, destino, visitados, listaFinal, listaActual, distancia+edge.getWeight(), min);
		 		}
		 	}
		 	listaActual.remove(listaActual.size()-1);
		 	visitados[v.getPosition()] = false; //Deja desmarcadas todas las posiciones del vector de marcas
		}
	
	*/
	public List<String> caminoMasCorto(String ciudad1, String ciudad2) {
        List<String> camino = new LinkedList<String>();
        if(!this.mapaCiudades.isEmpty()) {
            Vertex origen = this.mapaCiudades.search(ciudad1);
            Vertex destino = this.mapaCiudades.search(ciudad2);
            if(origen != null && destino != null) {
                caminoMasCorto(origen, destino, camino, new LinkedList<String>(), new boolean[this.getMapaCiudades().getSize()], 0, Integer.MAX_VALUE);
            }
        }
        return camino;
    }
    
    private int caminoMasCorto(Vertex<String> origen, Vertex<String> destino, List<String> caminoMinimo, List<String> caminoAct, boolean[] marcas, int total, int min) {
        marcas[origen.getPosition()] = true;
        caminoAct.add(origen.getData());
        if(origen == destino && total < min) {
            caminoMinimo.removeAll(caminoMinimo);
            caminoMinimo.addAll(caminoAct);
            min = total;
        } else {
            List<Edge<String>> ady = this.mapaCiudades.getEdges(origen);
            Iterator<Edge<String>> it = ady.iterator();
            while(it.hasNext() && total < min) {
                Edge<String> v = it.next();
                int j = v.getTarget().getPosition();
                int aux = total + v.getWeight();
                if(!marcas[j] && aux < min) {
                    min = caminoMasCorto(v.getTarget(), destino, caminoMinimo, caminoAct, marcas, aux, min);
                }
            }
        }
        marcas[origen.getPosition()] = false;
        caminoAct.remove(caminoAct.size()-1);
        return min;
    }
	///-------------------------------------4-------------------------------------/
	//Retorna la lista de ciudades que forman un camino para llegar de ciudad1 a ciudad2. El auto no debe
	//quedarse sin combustible y no puede cargar. Si no existe camino retorna la lista vacía.
	public List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto){
		List<String> lista = new LinkedList<String>();
		boolean [] visitados = new boolean [mapaCiudades.getSize()];
		Vertex<String> origen = mapaCiudades.search(ciudad1);
		Vertex<String> destino = mapaCiudades.search(ciudad2);
		if (origen != null && destino != null)
			pathUsingFuel(origen, destino, visitados, lista, tanqueAuto, 0);
		return lista;
	}
	
	private boolean pathUsingFuel(Vertex<String> origen, Vertex<String> destino, boolean [] visitados, List<String> camino, int tanque, int consumo) {
		boolean encontre = false;
		if (consumo <= tanque) {
			camino.add(origen.getData());
			tanque -= consumo;
		}
		visitados[origen.getPosition()] = true;
		if (origen == destino)
			return true;
		else {
			List<Edge<String>> ady = this.mapaCiudades.getEdges(origen);
            Iterator<Edge<String>> it = ady.iterator();
			while (it.hasNext() && !encontre){
				Vertex<String> v = it.next().getTarget();
				if (!visitados[v.getPosition()])
					encontre = pathUsingFuel(v, destino, visitados, camino, tanque, consumo);
			}
		}
		if (!encontre)
			camino.remove(camino.size()-1);
		 	visitados[origen.getPosition()] = false; 
		return encontre;
	}
	
	///-------------------------------------5-------------------------------------/
	//Retorna la lista de ciudades que forman un camino para llegar de ciudad1 a ciudad2 teniendo en cuenta
	//que el auto debe cargar la menor cantidad de veces. El auto no se debe quedar sin combustible en
	//medio de una ruta, además puede completar su tanque al llegar a cualquier ciudad. Si no existe camino
	//retorna la lista vacía.

	public List<String> caminoConMenorCargaDeCombustible (String ciudad1, String ciudad2, int tanqueAuto){
		List<String> lista = new LinkedList<String>();
		return lista;
	}
		
}


