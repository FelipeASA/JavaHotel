/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelClienteVO;

public class Informe6VO {
    private String producto;
    private String nombre_habitacion;
    private int total;

    public Informe6VO(String producto, String nombre_habitacion, int total) {
        this.producto = producto;
        this.nombre_habitacion = nombre_habitacion;
        this.total = total;
    }
    public Informe6VO(){
        this.producto=this.nombre_habitacion= "";
        this.total=0;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getNombre_habitacion() {
        return nombre_habitacion;
    }

    public void setNombre_habitacion(String nombre_habitacion) {
        this.nombre_habitacion = nombre_habitacion;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "producto=" + producto + ", nombre_habitacion=" + nombre_habitacion + ", total=" + total + "\n";
    }
    
}

