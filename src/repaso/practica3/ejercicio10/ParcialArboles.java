package repaso.practica3.ejercicio10;

import java.util.LinkedList;
import java.util.List;

import tp3.ej3.GeneralTree;

public class ParcialArboles {
    public static List<Integer> resolver(GeneralTree<Integer> arbol){
        LinkedList<Integer> camino = new LinkedList<Integer>();
        int res = 0;
        if (!arbol.isEmpty()){
            res = buscarCamino(arbol, camino, new LinkedList<Integer>(),0 ,0, Integer.MIN_VALUE);
        }
        System.out.println(res);
        return camino;
    }

    private static int buscarCamino(GeneralTree<Integer> arbol, LinkedList<Integer> camino, LinkedList<Integer> caminoActual, int nivel, int suma, int max){
        if(arbol.getData() == 1){
            caminoActual.add(arbol.getData());
            suma += nivel;
        }
        if (arbol.isLeaf()){
            if (suma > max){
                max = suma;
                camino.removeAll(camino);
                camino.addAll(caminoActual);
            }
        }else{
            nivel++;
            List<GeneralTree<Integer>> children = arbol.getChildren();
            for (GeneralTree<Integer> child : children){
                max = buscarCamino(child, camino, caminoActual, nivel, suma, max);
            }
        }
        if (arbol.getData() == 1){
            caminoActual.remove(caminoActual.size()-1);
        }
        return max;
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