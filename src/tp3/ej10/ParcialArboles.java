package tp3.ej10;

import java.util.List;
import java.util.LinkedList;

import tp3.ej5.GeneralTree;

public class ParcialArboles {
	/* BOCETO
 	public static List<Integer> resolver(GeneralTree<Integer> arbol){
    debe crear las listas e inicializar las variables
    ejercicio 10
	dos listas, una auxiliar y una maxima para guardar el resultado
	dos variables, una que vaya contando el maxactual y otra que cuente el maximo total
	y otra variable para ir llevando la cuenta de los niveles
	*/

	public static List<Integer> resolver(GeneralTree<Integer> arbol){
		List<Integer> listaActual = new LinkedList <Integer>();
		List<Integer> listaMaxima = new LinkedList <Integer>();
		if(!arbol.isEmpty()) 
			resolver(arbol, listaActual, listaMaxima, 0, 0, 0);
		return listaMaxima;
		
	}

	private static int resolver(GeneralTree<Integer> arbol, List<Integer> listaActual, List<Integer> listaMaxima, int nivelActual, int sumaActual, int sumaMaxima){
		if(arbol.getData() == 1) listaActual.add(arbol.getData()); //actualizarLista
		sumaActual += arbol.getData() * nivelActual; //arbol.getData() * nivel;
		if(arbol.isLeaf()){
			if(sumaActual > sumaMaxima) {
				sumaMaxima = sumaActual;
				listaMaxima.removeAll(listaMaxima);
				listaMaxima.addAll(listaActual);
			}	
		}else{
			for(GeneralTree<Integer> child : arbol.getChildren()){
				sumaMaxima = resolver(child, listaActual, listaMaxima, nivelActual+1, sumaActual, sumaMaxima);  
			}	
		}
		if(arbol.getData() == 1) listaActual.remove(listaActual.size()-1);
		return sumaMaxima;
	}
	
    public static void main(String[] args){
        List<GeneralTree<Integer>> subChildren1 = new LinkedList<GeneralTree<Integer>>();
        subChildren1.add(new GeneralTree<Integer>(1));
        subChildren1.add(new GeneralTree<Integer>(1));
        subChildren1.add(new GeneralTree<Integer>(1));
        GeneralTree<Integer> subA = new GeneralTree<Integer>(1, subChildren1);
        List<GeneralTree<Integer>> subChildren2 = new LinkedList<GeneralTree<Integer>>();
        subChildren2.add(subA);
        subChildren2.add(new GeneralTree<Integer>(1));
        GeneralTree<Integer> a1 = new GeneralTree<Integer>(0, subChildren2);
        
        List<GeneralTree<Integer>> subChildren3 = new LinkedList<GeneralTree<Integer>>();
        subChildren3.add(new GeneralTree<Integer>(1));
        GeneralTree<Integer> subB = new GeneralTree<Integer>(0, subChildren3);
        List<GeneralTree<Integer>> subChildren4 = new LinkedList<GeneralTree<Integer>>();
        subChildren4.add(subB);
        GeneralTree<Integer> subC = new GeneralTree<Integer>(0, subChildren4);
        List<GeneralTree<Integer>> subChildren5 = new LinkedList<GeneralTree<Integer>>();
        subChildren5.add(new GeneralTree<Integer>(1));
        subChildren5.add(subC);
        GeneralTree<Integer> a2 = new GeneralTree<Integer>(1, subChildren5);
        
        List<GeneralTree<Integer>> subChildren6 = new LinkedList<GeneralTree<Integer>>();
        subChildren6.add(new GeneralTree<Integer>(0));
        subChildren6.add(new GeneralTree<Integer>(0));
        GeneralTree<Integer> subD = new GeneralTree<Integer>(0, subChildren6);
        List<GeneralTree<Integer>> subChildren7 = new LinkedList<GeneralTree<Integer>>();
        subChildren7.add(subD);
        GeneralTree<Integer> subE = new GeneralTree<Integer>(0, subChildren7);
        List<GeneralTree<Integer>> subChildren8 = new LinkedList<GeneralTree<Integer>>();
        subChildren8.add(subE);
        GeneralTree<Integer> a3 = new GeneralTree<Integer>(1, subChildren8);
        
        List<GeneralTree<Integer>> arbol = new LinkedList<GeneralTree<Integer>>();
        arbol.add(a1);
        arbol.add(a2);
        arbol.add(a3);
        GeneralTree<Integer> a = new GeneralTree<Integer>(1, arbol);
        
        System.out.println(resolver(a));
        
    }
}