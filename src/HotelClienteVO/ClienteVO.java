
package HotelClienteVO;


public class ClienteVO {
    private String rut;
    private String nombre;
    private String apellidosPaterno;
    private String apellidoMaterno;
    private char sexo;
    private String fechaNacimiento;
    private String nacionalidad;

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

    public String getApellidosPaterno() {
        return apellidosPaterno;
    }

    public void setApellidosPaterno(String apellidosPaterno) {
        this.apellidosPaterno = apellidosPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public ClienteVO(String rut, String nombre, String apellidosPaterno, String apellidoMaterno, char sexo, String fechaNacimiento, String nacionalidad) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellidosPaterno = apellidosPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
    }
    public ClienteVO(){
        this.rut = "";
        this.nombre = "";
        this.apellidosPaterno = "";
        this.apellidoMaterno = "";
        this.sexo ='a';
        this.fechaNacimiento = "";
        this.nacionalidad = "";
    }
    @Override
    public String toString(){
        return "'"+rut+"', '" +nombre+"', '"+apellidosPaterno+"', '"+apellidoMaterno+"', '"+sexo+"', '"+fechaNacimiento+"', '"+nacionalidad+"'";
    }

}
