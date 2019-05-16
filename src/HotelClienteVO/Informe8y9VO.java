package HotelClienteVO;

public class Informe8y9VO  implements Comparable <Informe8y9VO> {
 
    private String nombre_habitacion;
    private double promedio;

    public Informe8y9VO(String nombre_habitacion, double promedio) {
        this.nombre_habitacion = nombre_habitacion;
        this.promedio = promedio;
    }
    
    public Informe8y9VO(){
        
        this.nombre_habitacion="";
        this.promedio=1.5;
    }

    public String getNombre_habitacion() {
        return nombre_habitacion;
    }

    public void setNombre_habitacion(String nombre_habitacion) {
        this.nombre_habitacion = nombre_habitacion;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return "Informe8y9VO{" + "nombre_habitacion=" + nombre_habitacion + ", promedio=" + promedio + '}';
    }

    
    
    public int compareTo(Informe8y9VO o) {
        String a=new String(String.valueOf(this.promedio)+this.nombre_habitacion);
        String b=new String(String.valueOf(o.promedio)+o.nombre_habitacion);
        return a.compareTo(b);
    }
     
    
}