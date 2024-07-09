package repaso.arboles_binarios.ejercicio9;

public class Data {
    private int sum;
    private int dif;

    public Data(int suma, int diferencia){
        this.sum = suma;
        this.dif = diferencia;
    }
    
    public int getSum(){
        return sum;
    }
    
    public void setSum(int suma){
        this.sum = suma;
    }
    
    public int getDif(){
        return dif;
    }
    
    public void setDif(int diferencia){
        this.dif = diferencia;
    }
    @Override
    public String toString() {
        return "Sum=" + sum + " Dif=" + dif; 
    }
}
