/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelClienteVO;
public class Informe2y3VO {
    
    private String rut;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String sexo;
    private String fecha_nacimiento;
    private String nacionalidad;
    private String fecha_ingreso;
    private int id_modalidad;
    private int precio_modalidad;
    private String nombre_habitacion;

    public Informe2y3VO(String rut, String nombre, String apellido_paterno, String apellido_materno, String sexo, String fecha_nacimiento, String nacionalidad, String fecha_ingreso, int id_modalidad, int precio_modalidad, String nombre_habitacion) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.sexo = sexo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.nacionalidad = nacionalidad;
        this.fecha_ingreso = fecha_ingreso;
        this.id_modalidad = id_modalidad;
        this.precio_modalidad = precio_modalidad;
        this.nombre_habitacion = nombre_habitacion;
    }
    public Informe2y3VO(){
        
        this.rut=this.nombre=this.apellido_paterno=this.apellido_materno=this.sexo=this.fecha_nacimiento=this.nacionalidad=this.fecha_ingreso=this.nombre_habitacion="";
        this.id_modalidad=0;
        this.precio_modalidad=0;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public int getId_modalidad() {
        return id_modalidad;
    }

    public void setId_modalidad(int id_modalidad) {
        this.id_modalidad = id_modalidad;
    }

    public int getPrecio_modalidad() {
        return precio_modalidad;
    }

    public void setPrecio_modalidad(int precio_modalidad) {
        this.precio_modalidad = precio_modalidad;
    }

    public String getNombre_habitacion() {
        return nombre_habitacion;
    }

    public void setNombre_habitacion(String nombre_habitacion) {
        this.nombre_habitacion = nombre_habitacion;
    }

    @Override
    public String toString() {
        return "rut=" + rut + ", nombre=" + nombre + ", apellido_paterno=" + apellido_paterno + ", apellido_materno=" + apellido_materno + ", sexo=" + sexo + ", fecha_nacimiento=" + fecha_nacimiento + ", nacionalidad=" + nacionalidad + ", fecha_ingreso=" + fecha_ingreso + ", id_modalidad=" + id_modalidad + ", precio_modalidad=" + precio_modalidad + ", nombre_habitacion=" + nombre_habitacion +"\n";
    }
   
}
