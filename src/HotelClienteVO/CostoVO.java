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
public class CostoVO {
    private String rut;
    private int id_modalidad;
    private int id_habitaciones;
    private String fecha_ingreso; 
    
    public CostoVO(){
        rut="";
        id_modalidad=0;
        fecha_ingreso="";
        id_habitaciones=0;
        
    }

    public void setInt_habitaciones(int int_habitaciones) {
        this.id_habitaciones = int_habitaciones;
    }

    public int getInt_habitaciones() {
        return id_habitaciones;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setId_modalidad(int id_modalidad) {
        this.id_modalidad = id_modalidad;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getRut() {
        return rut;
    }

    public int getId_modalidad() {
        return id_modalidad;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }
    
    public String toString(){
        return "'"+rut+"', "+id_habitaciones+", "+id_modalidad+", '"+fecha_ingreso+"'";
    }
}
