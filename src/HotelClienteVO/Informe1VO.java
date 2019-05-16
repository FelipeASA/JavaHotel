
package HotelClienteVO;

public class Informe1VO {
    
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String fecha_ingreso;
    private String nombre_habitacion;

    public Informe1VO(String nombre, String apellido_paterno, String apellido_materno, String fecha_ingreso, String nombre_habitacion) {
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.fecha_ingreso = fecha_ingreso;
        this.nombre_habitacion = nombre_habitacion;
    }
    
    public Informe1VO(){
        this.nombre=this.apellido_paterno=this.apellido_paterno=this.fecha_ingreso=this.nombre_habitacion="";
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

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getNombre_habitacion() {
        return nombre_habitacion;
    }

    public void setNombre_habitacion(String nombre_habitacion) {
        this.nombre_habitacion = nombre_habitacion;
    }

    @Override
    public String toString() {
        return "nombre=" + nombre + ", apellido_paterno=" + apellido_paterno + ", apellido_materno=" + apellido_materno + ", fecha_ingreso=" + fecha_ingreso + ", nombre_habitacion=" + nombre_habitacion +"\n";
    }
    
}

