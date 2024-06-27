package repaso.practica5.primera_fecha_tema1;

public class Data {
    private String nombre;
    private Integer minutos;

    public Data(String nombre, Integer minutos) {
        this.nombre = nombre;
        this.minutos = minutos;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setMinutos(Integer minutos){
        this.minutos = minutos;
    }
    
    public Integer getMinutos(){
        return this.minutos;
    }
}
