package tp1.ej8;

public class CircularQueue<T> extends Queue<T>{
	
	public T shift() {
		T dato = dequeue();   // le asigno a data el primer elemento de la cola y lo elimino de la cola
		enqueue(dato);        // agrego al fondo de la cola a dato
		return dato;
	}
}