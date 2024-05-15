package tp3.ej6;

import tp3.ej5.GeneralTree;

public class RedDeAguaPotable {
	GeneralTree<Character> arbol;
	
	public RedDeAguaPotable(GeneralTree<Character> arbol) {
		this.arbol = arbol;
	}
	public double minimoCaudal(double caudal) {
		double minimo = caudal;
		if (this != null)
			minimo = recorridoAux(arbol,caudal);
		return minimo;
	}
	private double recorridoAux(GeneralTree<Character> arbol, double caudal) {
		if (arbol.isLeaf()) return caudal;
		else {
			double caudalDivision = (caudal/arbol.getChildren().size());
			double caudalMin = Double.MAX_VALUE;
			for (GeneralTree<Character> child: arbol.getChildren()) {
				double caudalHijo = recorridoAux(child,caudalDivision);
				caudalMin = Math.min(caudalMin,caudalHijo);
			}
			return caudalMin;
		}
	}
}
