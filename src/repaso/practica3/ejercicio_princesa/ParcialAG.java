package repaso.practica3.ejercicio_princesa;

import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

import tp3.ej1.GeneralTree;

public class ParcialAG {
    /*Ejercicio de parcial – Encontrar a la Princesa

     * Dado un árbol general compuesto por personajes, donde
    puede haber dragones, princesas y otros, se denominan
    nodos accesibles a aquellos nodos tales que a lo largo
    del camino del nodo raíz del árbol hasta el nodo (ambos
    inclusive) no se encuentra ningún dragón. 

    Implementar un método que devuelva una lista con un camino desde la raíz a una Princesa sin
    pasar por un Dragón –sin necesidad de ser el más cercano a la raíz-. Asuma que existe al menos
    un camino accesible.

     */
    public List<Personaje> buscarPrincesa(GeneralTree<Personaje> tree){
        LinkedList<Personaje> lista = new LinkedList<>();
        if (!tree.isEmpty()){
            recursividad(tree, lista);
        }
        return lista;
    }

    private boolean recursividad(GeneralTree<Personaje> tree, LinkedList<Personaje> lista){
        boolean ok = false;
        if (tree.getData().getTipo().equals("Princesa")){
            ok = true;
            lista.add(tree.getData());
        }
        else {
            if (tree.getData().getTipo().equals("Dragon") || (tree.isLeaf()))
                return ok;
            else {
                // si no una princesa, ni es un dragon ni es una hoja
                lista.add(tree.getData());
                List<GeneralTree<Personaje>> children = tree.getChildren();
		        Iterator <GeneralTree<Personaje>> it = children.iterator();
                while (it.hasNext() && !ok){
                    ok = recursividad(it.next(), lista);
                }

            }
        }
        return ok;
    }

    public static void main(String[] args) {
        Personaje p0 = new Personaje("COYOTE", "Animal");
        Personaje p1 = new Personaje("SIMBA", "Animal");
        Personaje p2 = new Personaje("MUSHU", "Dragon");
        Personaje p3 = new Personaje("TIMON", "Animal");
        Personaje p4 = new Personaje("ELLIOT", "Dragon");
        Personaje p5 = new Personaje("Bella", "Princesa");
        Personaje p6 = new Personaje("ZAZU", "Animal");
        Personaje p7 = new Personaje("RAFIKI", "Animal");
        Personaje p8 = new Personaje("MULAN", "Princesa");
        Personaje p9 = new Personaje("FROZEN", "Princesa");
        Personaje p10 = new Personaje("NALA", "Animal");
        //SIMBA
        GeneralTree<Personaje> a1 = new GeneralTree<Personaje>(p1);
        //MUSHU
        GeneralTree<Personaje> a21 = new GeneralTree<Personaje>(p3);
        GeneralTree<Personaje> a22 = new GeneralTree<Personaje>(p4);
        GeneralTree<Personaje> a23 = new GeneralTree<Personaje>(p5);
        List<GeneralTree<Personaje>> hijosa2 = new LinkedList<GeneralTree<Personaje>>();
        hijosa2.add(a21);
        hijosa2.add(a22);
        hijosa2.add(a23);
        GeneralTree<Personaje> a2 = new GeneralTree<Personaje>(p2, hijosa2);
        //ZAZU
        GeneralTree<Personaje> a24 = new GeneralTree<Personaje>(p7);
        GeneralTree<Personaje> a26 = new GeneralTree<Personaje>(p9);
        GeneralTree<Personaje> a27 = new GeneralTree<Personaje>(p10);
        List<GeneralTree<Personaje>> hijosa4 = new LinkedList<GeneralTree<Personaje>>();
        hijosa4.add(a26);
        hijosa4.add(a27);
        GeneralTree<Personaje> a25 = new GeneralTree<Personaje>(p8, hijosa4);
        List<GeneralTree<Personaje>> hijosa3 = new LinkedList<GeneralTree<Personaje>>();
        hijosa3.add(a24);
        hijosa3.add(a25);
        GeneralTree<Personaje> a3 = new GeneralTree<Personaje>(p6, hijosa3);
        // Creo arbol
        List<GeneralTree<Personaje>> hijosa5 = new LinkedList<GeneralTree<Personaje>>();
        hijosa5.add(a1);
        hijosa5.add(a2);
        hijosa5.add(a3);
        GeneralTree<Personaje> a = new GeneralTree<Personaje>(p0, hijosa5);

        ParcialAG p = new ParcialAG();

        List<Personaje> caminoPrincesa = p.buscarPrincesa(a);
        for(Personaje personaje : caminoPrincesa){
            System.out.println(personaje);
        }
    }
       
}
