
package proyecto.controlador;

import HotelClienteVO.ClienteVO;
import HotelClienteVO.CostoVO;
import HotelClienteVO.HabitacionVO;
import java.util.ArrayList;

import proyecto.modelo.dbManager.DBOpenmindDAO;




public class Controlador {
    
    private DBOpenmindDAO dboManager;
    
    public Controlador(){
        dboManager=DBOpenmindDAO.obtenerInstancia();
    }
    public boolean insertarCliente(ClienteVO nuevo){
        boolean resultado=false;
        resultado=dboManager.insertarCliente(nuevo);
        return resultado;
    }
    
    public boolean insertarCosto(CostoVO nuevo){
        boolean resultado=false;
        resultado=dboManager.insertarCosto(nuevo);
        return resultado;
    }
    public boolean modificarOcupacion(CostoVO modificado){
        boolean resultado=false;
        resultado=dboManager.modificarHabitacion(modificado);
        return resultado;
    }
    
    public ClienteVO mostrarDatos(String cliente){
        return dboManager.mostrarDatos(cliente);
        
    }
    
    public HabitacionVO  mostrarDetalles(String id){
        return dboManager.mostrarDetalles(id);
    }
    
    public boolean encontradoBase(String cliente){
        boolean resultado = false;
        resultado=dboManager.encontradoBase(cliente);
        
        return resultado;
    }
    public ArrayList obtenerInforme7(){
        return dboManager.obtenerInforme7();
    }
    public ArrayList obtenerInforme1(){
        return dboManager.obtenerInforme1();
    }
    public ArrayList obtenerInforme2(String rut){
        return dboManager.obtenerInforme2(rut);
    }
    public ArrayList obtenerInforme3(){
        return dboManager.obtenerInforme3();
    }
    public ArrayList obtenerInforme4(){
        return dboManager.obtenerInforme4();
    }
    public ArrayList obtenerInforme5(){
        return dboManager.obtenerInforme5();
    }
    public ArrayList obtenerInforme6(){
        return dboManager.obtenerInforme6();
    }
    public int inventarioBebida(String bebida){
        return dboManager.inventarioBebida(bebida);
    }
    public ArrayList obtenerInforme9(){
        return dboManager.obtenerInforme9();
    }
    public boolean liberarHabitaciones(String id){
        boolean resultado=false;
        resultado=dboManager.liberarHabitacion(id);
        return resultado;          
    }
    public int mostrarInventario(String bebida) {
    	int inventario = dboManager.inventarioBebida(bebida);
    	
    	return inventario;
    	
    	
    }
    
    //En la vista se obtiene cuantas bebidas quiere separadas por tipo de bebida, primero visualiza cuantas hay
    //luego realiza el update a la base de datos, se verifica q esa modificación sea > 0, este metodo afecta la base de datos y arroja el precio a cobrar. 
    
    public int compraBebidas(int cantidad, String nombre) {
    	
    	int precio = 0;
    	int inventario = dboManager.compraBebidad(cantidad, nombre);
    	if(inventario-cantidad>0) {
    		precio = cantidad * 3000;
    		return precio ;
    	}else {
    		return inventario;
    	}
    	
    	
    }
}
