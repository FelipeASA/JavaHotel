/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelClienteVO;

/**
 *
 * @author saurbano
 */
public class HabitacionVO {
    private String nombre;
    private String detalle;
    private int ocupacion;

    public void setOcupacion(int ocupacion) {
        this.ocupacion = ocupacion;
    }

    public int getOcupacion() {
        return ocupacion;
    }
    
    public HabitacionVO(){
        nombre="";
        detalle="";
        
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDetalle() {
        return detalle;
    }
    
    public String toString(){
        return "Nombre: "+nombre+ "\n"+"Detalle: "+detalle;
    }
    
    
}
