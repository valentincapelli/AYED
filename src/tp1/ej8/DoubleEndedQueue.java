package tp1.ej8;

public class DoubleEndedQueue<T> extends Queue<T>{
	
	public void enqueueFirst(T dato) {
		super.data.add(0, dato);  // accedo a data de tipo lista con super y uso add con el indice en la posicion 0, osea la primera
		}
}
