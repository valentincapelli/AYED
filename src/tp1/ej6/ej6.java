package tp1.ej6;

public class ej6 {
	
	String str = """
		a. ¿En qué casos ArrayList ofrece un mejor rendimiento que LinkedList?
        b. ¿Cuándo LinkedList puede ser más eficiente que ArrayList?
        c. ¿Qué diferencia encuentra en el uso de la memoria en ArrayList y LinkedList?
        d. ¿En qué casos sería preferible usar un ArrayList o un LinkedList?
        
        a_ El arraylist permite el acceso aleatorio ya que los arreglos se basan en índices. Eso 
        significa que acceder a cualquier elemento siempre lleva un tiempo constante y mas reducido, 
        a diferencia de la linkedlist.
         
        b_ En linked list agregar/borrar elementos en un lugar específico, en el peor de los casos, 
        es de O(n). Suele ser más rápida que arraylist porque nunca se necesita cambiar el tamaño de
        la estructura.
         
        c_  Una linkedlist consume un poco mas de memoria que el arraylist ya que cada nodo almacena dos
        referencias al elemento anterior y al siguiente.
        
        d_ El arraylist es mas util cuando la aplicacion requiere acceso a datos y su tamaño no varia 
        demasiado.
        La linkedlist es más útil cuando se conoce que la aplicación requiere manipulación de datos 
        (muchas inserciones y borrados).

			
		""";  

}