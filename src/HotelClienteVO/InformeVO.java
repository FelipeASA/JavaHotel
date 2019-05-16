package HotelClienteVO;

import java.util.ArrayList;

public class InformeVO {
	
	//Tabla Cliente
	
	private String rut;
	private String nombre;
	private String apellido_paterno;
	private String apellido_materno;
	private char sexo;
	private String fecha_nacimiento;
	private String nacionalidad;
	private int count;
	
	//Tabla Habitaciones


	private int id_habitaciones;
	private String nombre_habitacion;
	private char ocupacion;
	private String detalle;
	
	//Tabla Costos
	
	private int id_modalidad;
	private String fecha_ingreso;
	private int total;
	private int total_final;
	
	//Tabla Compra Habitaciones
	
	private String producto;
	private int cantidad_producto_a_comprar;
	
	//Tabla Catalogo
	
	private int precio_producto;
	private int cantidad_inventario;
	
	//Tabla Modalidad
	
	private int precio_modalidad;
	
	

	public InformeVO() {
		super();
		rut = "";
		this.nombre = "";
		this.apellido_paterno = "";
		this.apellido_materno = "";
		this.sexo = 'm';
		this.fecha_nacimiento = "";
		this.nacionalidad = "";
		this.count = 0;
		this.id_habitaciones = 0;
		this.nombre_habitacion = "";
		this.ocupacion = 'o';
		this.detalle = "";
		this.id_modalidad = 0;
		this.fecha_ingreso = "";
		this.total = 0;
		this.total_final = 0;
		this.producto = "";
		this.cantidad_producto_a_comprar = 0;
		this.precio_producto = 0;
		this.cantidad_inventario = 0;
		this.precio_modalidad = 0;
	}


	public String toStringConsulta1() {
		
		
		
		return "Informe 1 Comportamiento Clientes\n[nombre: " + nombre + " " + apellido_paterno + " "+ apellido_materno + "" 
				 + ", Fecha de ingreso: " + fecha_ingreso+", Habitación: "+ nombre_habitacion;
	}

	
	public String toStringConsulta2() {
		return "Informe 2 Informe Clientes \n[Rut" + rut + ", nombre=" + nombre + " " + apellido_paterno+ " " + apellido_materno + ", sexo: " + sexo + ", modalidad: " + id_modalidad + ", fecha de ingreso: "+ fecha_ingreso + ",\n "
				+ ", precio modalidad: " + precio_modalidad +"\n Habitación: "+ nombre_habitacion+"producto: " + producto + ", cantidad de productos: " + cantidad_producto_a_comprar+ ", precio: " + precio_producto +"]";
	}
	
	public String toStringConsulta3() {
		
		return "Informe 3 Cliente del Amor \n[Rut: "+ rut+", nombre: "+nombre+" "+ apellido_paterno+" "+apellido_materno+", sexo: "+sexo+", fecha de nacimiento: "+ fecha_nacimiento+", nacionalidad: "+nacionalidad+"\n"+
				"Fecha de ingreso: "+ fecha_ingreso+", habitación: "+nombre_habitacion+", modalidad: "+id_modalidad+".";
	}
	
	public String toStringConsulta4() {
		
		return "Informe 4 \n"+
				"Habitación: "+nombre_habitacion+", nombre: "+nombre+" "+apellido_paterno+" "+ apellido_materno+" Fecha de ingreso: "+ fecha_ingreso+" total:"+total;
	}
	
	public String toStringConsulta4_1() {
		return "Total final:"+total_final;
	}
	
	public String toStringConsulta5() {
		
		return "Informe 4 \n"+
				"Habitación: "+nombre_habitacion+", nombre: "+nombre+" "+apellido_paterno+" "+ apellido_materno+" Fecha de ingreso: "+ fecha_ingreso+" total:"+total;
	}
	
	public String toStringConsulta5_1() {
		return "Total final:"+total_final;
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


	public char getSexo() {
		return sexo;
	}


	public void setSexo(char sexo) {
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


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public int getId_habitaciones() {
		return id_habitaciones;
	}


	public void setId_habitaciones(int id_habitaciones) {
		this.id_habitaciones = id_habitaciones;
	}


	public String getNombre_habitacion() {
		return nombre_habitacion;
	}


	public void setNombre_habitacion(String nombre_habitacion) {
		this.nombre_habitacion = nombre_habitacion;
	}


	public char getOcupacion() {
		return ocupacion;
	}


	public void setOcupacion(char ocupacion) {
		this.ocupacion = ocupacion;
	}


	public String getDetalle() {
		return detalle;
	}


	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}


	public int getId_modalidad() {
		return id_modalidad;
	}


	public void setId_modalidad(int id_modalidad) {
		this.id_modalidad = id_modalidad;
	}


	public String getFecha_ingreso() {
		return fecha_ingreso;
	}


	public void setFecha_ingreso(String fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}


	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}


	public int getTotal_final() {
		return total_final;
	}


	public void setTotal_final(int total_final) {
		this.total_final = total_final;
	}


	public String getProducto() {
		return producto;
	}


	public void setProducto(String producto) {
		this.producto = producto;
	}


	public int getCantidad_producto_a_comprar() {
		return cantidad_producto_a_comprar;
	}


	public void setCantidad_producto_a_comprar(int cantidad_producto_a_comprar) {
		this.cantidad_producto_a_comprar = cantidad_producto_a_comprar;
	}


	public int getPrecio_producto() {
		return precio_producto;
	}


	public void setPrecio_producto(int precio_producto) {
		this.precio_producto = precio_producto;
	}


	public int getCantidad_inventario() {
		return cantidad_inventario;
	}


	public void setCantidad_inventario(int cantidad_inventario) {
		this.cantidad_inventario = cantidad_inventario;
	}


	public int getPrecio_modalidad() {
		return precio_modalidad;
	}


	public void setPrecio_modalidad(int precio_modalidad) {
		this.precio_modalidad = precio_modalidad;
	}



	
	
}