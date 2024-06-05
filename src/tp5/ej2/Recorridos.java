package tp5.ej2;

import java.util.ArrayList;
import java.util.List;

import tp1.ej8.Queue;
import tp5.ejercicio1.*;

public class Recorridos<T> {
	 public ArrayList<T> dfs(Graph<T> grafo) {
		 ArrayList<T> list = new ArrayList<>();
		 boolean[] marca = new boolean[grafo.getSize()];
		 for (int i = 0; i < grafo.getSize(); i++) {
			 if (!marca[i]) {
				 System.out.println("largo con: "+grafo.getVertex(i).getData());
				 dfs(i, grafo, marca, list);
			 }
		 }
		 return list;
	 }
	 
	 private void dfs(int i, Graph<T> grafo, boolean[] marca, ArrayList<T> list) {
		 marca[i] = true;
		 Vertex<T> v = grafo.getVertex(i);
		 System.out.println("Agrego a la lista a: " + v.getData());
		 list.add(v.getData());
		 
		 List<Edge<T>> adyacentes = grafo.getEdges(v); //adyacentes
		 for (Edge<T> e: adyacentes){
			 int j = e.getTarget().getPosition();
			 if (!marca[j]) {
				 dfs(j, grafo, marca, list);
			 }
		 }
	 }
	 
	 public ArrayList<T> bfs(Graph<T> grafo) {
		 ArrayList<T> list = new ArrayList<>();
	 	 boolean[] marca = new boolean [grafo.getSize()];
	 	 for (int i = 1; i <= marca.length; i++) {
	 	 	 if (!marca[i]){
	 	 		 this.bfs(i, grafo, marca,list); //las listas empiezan en la pos 1
	 	 	 }
	 	 }
	 	 return list;
	 }
	 
	 private void bfs(int i, Graph<T> grafo, boolean[] marca, ArrayList<T> list) {
		Queue<Vertex<T>> q = new Queue<Vertex<T>>();
		q.enqueue(grafo.getVertex(i));
		marca[i] = true;
		while (!q.isEmpty()) {
			Vertex<T> w = q.dequeue();
			System.out.println("Agrego a la lista a: " + w.getData());
			list.add(w.getData());
			
			// para todos los vecinos de w:
			List<Edge<T>> adyacentes = grafo.getEdges(w);
			for (Edge<T> e: adyacentes) {
				int j = e.getTarget().getPosition();
				if (!marca[j]) {
					marca[j] = true;
					//Vertex<T> v = e.getTarget();
					q.enqueue(e.getTarget());
				}
			}
		}
	} 
}
