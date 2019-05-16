
package proyecto.modelo.dbManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import HotelClienteVO.ClienteVO;
import HotelClienteVO.CostoVO;
import HotelClienteVO.HabitacionVO;
import HotelClienteVO.Informe1VO;
import HotelClienteVO.Informe2y3VO;
import HotelClienteVO.Informe4y5VO;
import HotelClienteVO.Informe6VO;
import HotelClienteVO.Informe8y9VO;
import java.sql.ResultSet;
import java.util.ArrayList;


public class DBOpenmindDAO {
    
    private String url;
    private String user;
    private String pass;
    private Connection con;
    private static DBOpenmindDAO manager;
    
    public DBOpenmindDAO(){
        user= "root";
        pass= "root";
        url= "jdbc:mysql://localhost:8889/openmind";
        con = null;
    }
    public static DBOpenmindDAO obtenerInstancia(){
        if(manager==null){
            manager= new DBOpenmindDAO();
        }
        return manager;
    }
    public boolean insertarCliente(ClienteVO nuevo){
        if(conectar() == true){
            try {
                Statement st = con.createStatement();
                String sql = "insert into clientes values (" + nuevo.toString() + ")";
                System.out.println("Insertando:[" + sql + "]");
                int rowsAffected = st.executeUpdate(sql);
                desconectar();
                return (rowsAffected==1);
            } catch (SQLException ex) {
                System.out.println("Error al insertar:[" + ex.getMessage() + "]");
            }
            desconectar();
        }
        return false;
    }
    
    public boolean modificarHabitacion(CostoVO modificado){
        if(conectar()==true){
            try {
                Statement st = con.createStatement();
                String sql = "update habitaciones set ocupacion=1"
                          + " where id_habitaciones='" + modificado.getInt_habitaciones()+ "'";
                System.out.println("Modificando:[" + sql + "]");
                int rowsAffected = st.executeUpdate(sql);
                return (rowsAffected==1);
            } catch (SQLException ex) {
                System.out.println("Error al modificar:[" + ex.getMessage() + "]");
            }
        }
        return false;
    }
    
    
    
    public boolean encontradoBase(String cliente){
        boolean resultado = false;
        
        if(conectar()){
            try {
                Statement st = con.createStatement();
                String sql = "select * from openmind.clientes where rut='"+cliente+"';";
                System.out.println("Insertando:[" + sql + "]");
                ResultSet result = st.executeQuery(sql);
                int rowsAffected = st.executeUpdate(sql);
                desconectar();
                return (rowsAffected==1);
            } catch (SQLException ex) {
                System.out.println("Error al insertar:[" + ex.getMessage() + "]");
            }
            desconectar();  
            }
        return false;
        }
    public ClienteVO mostrarDatos(String cliente){
        boolean resultado = false;
        ClienteVO muestraData=new ClienteVO();
        if(conectar()){
            
            try {
                Statement st = con.createStatement();
                String sql = "select * from openmind.clientes where rut='"+cliente+"';";
                System.out.println("Consultando:[" + sql + "]");
                ResultSet result = st.executeQuery(sql);
                if(result.next()){
                    muestraData.setNombre(result.getString("nombre"));
                    muestraData.setApellidoMaterno(result.getString("apellido_materno"));
                    muestraData.setApellidosPaterno(result.getString("apellido_paterno"));
                    muestraData.setSexo(result.getString("sexo").charAt(0));
                    muestraData.setNacionalidad(result.getString("nacionalidad"));
                    muestraData.setFechaNacimiento(result.getString("fecha_nacimiento"));
                    desconectar();
                    return muestraData;
                }
                
            } catch (SQLException ex) {
                System.out.println("Error al consultar:[" + ex.getMessage() + "]");
            }
            desconectar();  
            }
        return muestraData;
    }
    
    public HabitacionVO mostrarDetalles(String id){
        HabitacionVO muestraDetalle=new HabitacionVO();
        if(conectar()){
            
            try {
                Statement st = con.createStatement();
                String sql = "select * from openmind.habitaciones where id_habitaciones='"+id+"';";
                System.out.println("Consultando:[" + sql + "]");
                ResultSet result = st.executeQuery(sql);
                if(result.next()){
                    muestraDetalle.setNombre(result.getString("nombre_habitacion"));
                    muestraDetalle.setDetalle(result.getString("detalles"));
                    muestraDetalle.setOcupacion(result.getInt("ocupacion"));
                    desconectar();
                    return muestraDetalle;
                }
                
            } catch (SQLException ex) {
                System.out.println("Error al consultar:[" + ex.getMessage() + "]");
            }
            desconectar();  
            }
        return muestraDetalle;
                
    }

    public boolean insertarCosto(CostoVO nuevo){
        if(conectar() == true){
            try {
                Statement st = con.createStatement();
                String sql = "insert into costos values (" + nuevo.toString() + ")";
                System.out.println("Insertando:[" + sql + "]");
                int rowsAffected = st.executeUpdate(sql);
                desconectar();
                return (rowsAffected==1);
            } catch (SQLException ex) {
                System.out.println("Error al insertar:[" + ex.getMessage() + "]");
            }
            desconectar();
        }
        return false;
    }
        
    
      public boolean conectar(){
        try {        
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("Estimado, usted ha conectado con la base");
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al conectar:[" + ex.getMessage() + "]");
        }
        return false;
    }
    
    private void desconectar(){
        if(con != null){
            try {
                if(!con.isClosed()){
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error al desconectar:[" + ex.getMessage() + "]");
            }
        }     
    }
    
    public ArrayList obtenerInforme1(){
        ArrayList<Object> listaDeNombres1 = new ArrayList<Object>();
        int n=0;
        String nombre= null;
        Informe1VO informe1 = null;
        
        if(this.conectar() == true){
            try {
                Statement st = con.createStatement();
                String sql="select cl.nombre ,cl.apellido_paterno,cl.apellido_materno,cto.fecha_ingreso, h.nombre_habitacion\n" +
" from costos cto , clientes cl,habitaciones h,modalidad mo,compra_habitaciones ch,catalogo ca\n" +
" where cl.rut= cto.rut and h.id_habitaciones=cto.id_habitaciones and \n" +
" ch.id_habitaciones=h.id_habitaciones and mo.id_modalidad=cto.id_modalidad and cto.fecha_ingreso=ch.fecha_ingreso and ch.producto=ca.producto \n" +
" order by cl.nombre;";
                ResultSet result = st.executeQuery(sql);
             

                while(result.next() == true){
                    informe1 = new Informe1VO();
                    informe1.setNombre(result.getString("nombre"));
                    informe1.setApellido_paterno(result.getString("apellido_paterno"));
                    informe1.setApellido_materno(result.getString("apellido_materno"));
                    informe1.setFecha_ingreso(result.getString("fecha_ingreso"));
                    informe1.setNombre_habitacion(result.getString("nombre_habitacion"));
              
                    
                    listaDeNombres1.add(n,informe1);
                    //System.out.println(listaDeNombres.get(n));
                    n=n+1;
                    //System.out.println(informe1.toString());
                }
                
                
                this.desconectar();
            } catch (SQLException ex) {
                System.out.println("Error en la consulta:[" + ex.getMessage() + "]");
            }
        }
        return listaDeNombres1;
     
    }
    
    public ArrayList obtenerInforme2(String rut){
        ArrayList<Object> listaDeNombres2 = new ArrayList<Object>();
        //int n=0;
       
        Informe2y3VO informe2 = null;
        
        if(this.conectar() == true){
            try {
                Statement st = con.createStatement();
                String sql="select cl.*,cto.id_modalidad,cto.fecha_ingreso,mo.precio_modalidad,h.nombre_habitacion,ch.producto,ch.cantidad_producto_a_comprar,ca.precio_producto\n" +
" from costos cto , clientes cl,habitaciones h,modalidad mo,\n" +
"compra_habitaciones ch,catalogo ca\n" +
" where cl.rut = '"+rut+"' and cl.rut= cto.rut and h.id_habitaciones=cto.id_habitaciones and \n" +
" ch.id_habitaciones=h.id_habitaciones and mo.id_modalidad=cto.id_modalidad and ch.producto=ca.producto \n" +
" and cto.fecha_ingreso=ch.fecha_ingreso;";
                ResultSet result = st.executeQuery(sql);
             

                while(result.next() == true){
                    informe2 = new Informe2y3VO();
                    informe2.setRut(rut);
                    informe2.setNombre(result.getString("nombre"));
                    informe2.setApellido_paterno(result.getString("apellido_paterno"));
                    informe2.setApellido_materno(result.getString("apellido_materno"));
                    informe2.setSexo(result.getString("sexo"));
                    informe2.setFecha_nacimiento(result.getString("fecha_nacimiento"));
                    informe2.setNacionalidad(result.getString("nacionalidad"));
                    informe2.setFecha_ingreso(result.getString("fecha_ingreso"));
                    informe2.setId_modalidad(result.getInt("id_modalidad"));
                    informe2.setPrecio_modalidad(result.getInt("precio_modalidad"));
                    informe2.setNombre_habitacion(result.getString("nombre_habitacion"));
              
                    
                    listaDeNombres2.add(informe2);
                    //System.out.println(listaDeNombres.get(n));
                    //n=n+1;
                    System.out.println(informe2.toString());
                }
                
                
                this.desconectar();
            } catch (SQLException ex) {
                System.out.println("Error en la consulta:[" + ex.getMessage() + "]");
            }
        }
        return listaDeNombres2;
    }
     public ArrayList obtenerInforme3(){
        ArrayList<Object> listaDeNombres3 = new ArrayList<Object>();
        int n=0;
        String rut= null;
        Informe2y3VO informe3 = null;
        
        if(this.conectar() == true){
            try {
                Statement st = con.createStatement();
                String sql="select cto.rut from costos cto, clientes cl where  cl.rut= cto.rut\n" +
"group by cto.rut having count(cto.rut) order by count(cto.rut) desc limit 1";
                ResultSet result = st.executeQuery(sql);
                if(result.next()){
                   rut=result.getString("rut");
                    //System.out.println(nombre);
                
                String sSql = "select cl.*,cto.fecha_ingreso,h.nombre_habitacion,cto.id_modalidad\n" +
" from costos cto , clientes cl,habitaciones h,modalidad mo,\n" +
"compra_habitaciones ch,catalogo ca\n" +
" where cl.rut = '"+rut+"' and cl.rut= cto.rut and h.id_habitaciones=cto.id_habitaciones and \n" +
" ch.id_habitaciones=h.id_habitaciones and mo.id_modalidad=cto.id_modalidad and ch.producto=ca.producto \n" +
" and cto.fecha_ingreso=ch.fecha_ingreso;";
                //System.out.println("Consultando:[" + sSql + "]");
               ResultSet resultt=st.executeQuery(sSql);
                while(resultt.next() == true){
                    informe3 = new Informe2y3VO();
                    informe3.setRut(rut);
                    informe3.setNombre(resultt.getString("nombre"));
                    informe3.setApellido_paterno(resultt.getString("apellido_paterno"));
                    informe3.setApellido_materno(resultt.getString("apellido_materno"));
                    informe3.setSexo(resultt.getString("sexo"));
                    informe3.setFecha_nacimiento(resultt.getString("fecha_nacimiento"));
                    informe3.setNacionalidad(resultt.getString("nacionalidad"));
                    informe3.setFecha_ingreso(resultt.getString("fecha_ingreso"));
                    informe3.setId_modalidad(resultt.getInt("id_modalidad"));
                    informe3.setNombre_habitacion(resultt.getString("nombre_habitacion"));
                    
                    listaDeNombres3.add(n,informe3);
                    //System.out.println(listaDeNombres.get(n));
                    n=n+1;
                    System.out.println(informe3.toString());
                }
                }
                
                this.desconectar();
            } catch (SQLException ex) {
                System.out.println("Error en la consulta:[" + ex.getMessage() + "]");
            }
        }
        return listaDeNombres3;
     
    }
    
     public ArrayList obtenerInforme4(){
        ArrayList<Object> listaDeNombres4 = new ArrayList<Object>();
        int n=0;
        String nombre= null;
        Informe4y5VO informe4 = null;
        
        if(this.conectar() == true){
            try {
                Statement st = con.createStatement();
                String sql="select h.nombre_habitacion, count(cto.id_habitaciones) from costos cto, habitaciones h where cto.id_habitaciones = h.id_habitaciones\n" +
"group by cto.id_habitaciones limit 1";
                ResultSet result = st.executeQuery(sql);
                if(result.next()){
                   nombre=result.getString("nombre_habitacion");
                    System.out.println(nombre);
                
                String sSql = "select h.nombre_habitacion, cl.nombre, cl. apellido_paterno, cl.apellido_materno,cto.fecha_ingreso, \n" +
"(ch.cantidad_producto_a_comprar*ca.precio_producto+mo.precio_modalidad )as total\n" +
"from habitaciones h,clientes cl,\n" +
"costos cto,modalidad mo, compra_habitaciones ch,catalogo ca\n" +
" where h.nombre_habitacion=" +"'"+nombre+"'"+" and cl.rut= cto.rut and h.id_habitaciones=cto.id_habitaciones and \n" +
" ch.id_habitaciones=h.id_habitaciones and mo.id_modalidad=cto.id_modalidad and ch.producto=ca.producto \n" +
" and cto.fecha_ingreso=ch.fecha_ingreso \n" +
"group by  fecha_ingreso";
                //System.out.println("Consultando:[" + sSql + "]");
               ResultSet resultt=st.executeQuery(sSql);
                while(resultt.next() == true){
                    informe4 = new Informe4y5VO();
                    informe4.setNombre_habitacion(resultt.getString("nombre_habitacion"));
                    informe4.setNombre(resultt.getString("nombre"));
                    informe4.setApellido_paterno(resultt.getString("apellido_paterno"));
                    informe4.setApellido_materno(resultt.getString("apellido_materno"));
                    informe4.setFecha_ingreso(resultt.getString("fecha_ingreso"));
                    informe4.setTotal(resultt.getInt("total"));
                    
                    listaDeNombres4.add(n,informe4);
                    System.out.println(listaDeNombres4.get(n));
                    n=n+1;
                    System.out.println(informe4.toString());
                }
                }
                
                this.desconectar();
            } catch (SQLException ex) {
                System.out.println("Error en la consulta:[" + ex.getMessage() + "]");
            }
        }
        return listaDeNombres4;
     
    }
     public ArrayList obtenerInforme5(){
        ArrayList<Object> listaDeNombres5 = new ArrayList<Object>();
        int n=0;
        String nombre= null;
        Informe4y5VO informe4 = null;
        
        if(this.conectar() == true){
            try {
                Statement st = con.createStatement();
                String sql="select h.nombre_habitacion, count(cto.id_habitaciones) from costos cto, habitaciones h where cto.id_habitaciones = h.id_habitaciones\n" +
"group by cto.id_habitaciones order by count(cto.id_habitaciones) limit 1";
                ResultSet result = st.executeQuery(sql);
                if(result.next()){
                   nombre=result.getString("nombre_habitacion");
                    System.out.println(nombre);
                
                String sSql = "select h.nombre_habitacion, cl.nombre, cl. apellido_paterno, cl.apellido_materno,cto.fecha_ingreso, \n" +
"(ch.cantidad_producto_a_comprar*ca.precio_producto+mo.precio_modalidad )as total\n" +
"from habitaciones h,clientes cl,\n" +
"costos cto,modalidad mo, compra_habitaciones ch,catalogo ca\n" +
" where h.nombre_habitacion=" +"'"+nombre+"'"+" and cl.rut= cto.rut and h.id_habitaciones=cto.id_habitaciones and \n" +
" ch.id_habitaciones=h.id_habitaciones and mo.id_modalidad=cto.id_modalidad and ch.producto=ca.producto \n" +
" and cto.fecha_ingreso=ch.fecha_ingreso \n" +
"group by fecha_ingreso";
                //System.out.println("Consultando:[" + sSql + "]");
               ResultSet resultt=st.executeQuery(sSql);
                while(resultt.next() == true){
                    informe4 = new Informe4y5VO();
                    informe4.setNombre_habitacion(resultt.getString("nombre_habitacion"));
                    informe4.setNombre(resultt.getString("nombre"));
                    informe4.setApellido_paterno(resultt.getString("apellido_paterno"));
                    informe4.setApellido_materno(resultt.getString("apellido_materno"));
                    informe4.setFecha_ingreso(resultt.getString("fecha_ingreso"));
                    informe4.setTotal(resultt.getInt("total"));
                    
                    listaDeNombres5.add(n,informe4);
                    System.out.println(listaDeNombres5.get(n));
                    n=n+1;
                    System.out.println(informe4.toString());
                }
                }
                
                this.desconectar();
            } catch (SQLException ex) {
                System.out.println("Error en la consulta:[" + ex.getMessage() + "]");
            }
        }
        return listaDeNombres5;
     
    }
    
     public ArrayList obtenerInforme6(){
        ArrayList<Object> listaDeNombres6 = new ArrayList<Object>();
        int n=0;
        String nombre= null;
        Informe6VO informe6 = null;
        
        if(this.conectar() == true){
            try {
                Statement st = con.createStatement();
                String sql="select ca.producto\n" +
"from catalogo ca, compra_habitaciones ch\n" +
"where ca.producto= ch.producto group by ca.producto order by ch.cantidad_producto_a_comprar desc limit 1";
                ResultSet result = st.executeQuery(sql);
                if(result.next()){
                   nombre=result.getString("producto");
                    //System.out.println(nombre);
                
                String sSql = "select producto,h.nombre_habitacion, sum(ch.cantidad_producto_a_comprar) as total\n" +
"from  compra_habitaciones ch, habitaciones h\n" +
"where producto ='"+nombre+"' and ch.id_habitaciones= h.id_habitaciones	group by ch.id_habitaciones limit 1";
                //System.out.println("Consultando:[" + sSql + "]");
               ResultSet resultt=st.executeQuery(sSql);
                while(resultt.next() == true){
                    informe6 = new Informe6VO();
                        informe6.setProducto(resultt.getString("producto"));
                        informe6.setNombre_habitacion(resultt.getString("nombre_habitacion"));
                        informe6.setTotal(resultt.getInt("total"));
                    
                    listaDeNombres6.add(n,informe6);
                    //System.out.println(listaDeNombres.get(n));
                    n=n+1;
                    //System.out.println(informe6.toString());
                }
                 String ssSql="select producto,h.nombre_habitacion, sum(ch.cantidad_producto_a_comprar) as total\n" +
"from  compra_habitaciones ch, habitaciones h\n" +
"where producto ='"+nombre+"' and ch.id_habitaciones= h.id_habitaciones	group by ch.id_habitaciones\n" +
"order by ch.cantidad_producto_a_comprar asc limit 1"; 
                ResultSet resulttt=st.executeQuery(ssSql);
                
                while(resulttt.next()){
                        informe6.setProducto(resulttt.getString("producto"));
                        informe6.setNombre_habitacion(resulttt.getString("nombre_habitacion"));
                        informe6.setTotal(resulttt.getInt("total"));
                        
                    listaDeNombres6.add(n,informe6);
                    
                    //System.out.println(informe6.toString());
                }
                }
                this.desconectar();
            } catch (SQLException ex) {
                System.out.println("Error en la consulta:[" + ex.getMessage() + "]");
            }
        }
        return listaDeNombres6;
     
    }
     
          public ArrayList obtenerInforme7(){
        ArrayList<Object> listaDeNombres7 = new ArrayList<Object>();
        int n=0;
        String nombre= null;
        Informe6VO informe61 = null;
        
        if(this.conectar() == true){
            try {
                Statement st = con.createStatement();
                String sql="select ca.producto\n" +
"from catalogo ca, compra_habitaciones ch\n" +
"where ca.producto= ch.producto group by ca.producto order by ch.cantidad_producto_a_comprar limit 1";
                ResultSet result = st.executeQuery(sql);
                if(result.next()){
                   nombre=result.getString("producto");
                    //System.out.println(nombre);
                
                String sSql = "select producto,h.nombre_habitacion, sum(ch.cantidad_producto_a_comprar) as total\n" +
"from  compra_habitaciones ch, habitaciones h\n" +
"where producto ='"+nombre+"' and ch.id_habitaciones= h.id_habitaciones	group by ch.id_habitaciones limit 1";
                //System.out.println("Consultando:[" + sSql + "]");
               ResultSet resultt=st.executeQuery(sSql);
                while(resultt.next() == true){
                    informe61 = new Informe6VO();
                        informe61.setProducto(resultt.getString("producto"));
                        informe61.setNombre_habitacion(resultt.getString("nombre_habitacion"));
                        informe61.setTotal(resultt.getInt("total"));
                    
                    listaDeNombres7.add(n,informe61);
                    //System.out.println(listaDeNombres.get(n));
                    n=n+1;
                    //ySstem.out.println(informe61.toString());
                }
                String ssSql="select producto,h.nombre_habitacion, sum(ch.cantidad_producto_a_comprar) as total\n" +
"from  compra_habitaciones ch, habitaciones h\n" +
"where producto ='"+nombre+"' and ch.id_habitaciones= h.id_habitaciones	group by ch.id_habitaciones\n" +
"order by ch.cantidad_producto_a_comprar asc limit 1"; 
                ResultSet resulttt=st.executeQuery(ssSql);
                
                while(resulttt.next()){
                        informe61.setProducto(resulttt.getString("producto"));
                        informe61.setNombre_habitacion(resulttt.getString("nombre_habitacion"));
                        informe61.setTotal(resulttt.getInt("total"));
                        
                    listaDeNombres7.add(n,informe61);
                    
                    //System.out.println(informe61.toString());
                }
                }
                
                this.desconectar();
            } catch (SQLException ex) {
                System.out.println("Error en la consulta:[" + ex.getMessage() + "]");
            }
        }
        return listaDeNombres7;
     
    }
          
          public int inventarioBebida(String bebida) {
		
	//Este método muestra la cantidad de bebidas de cierto tipo quedan en el inventario
		int inventario=0;
		if(this.conectar()) {
			try {
				
				Statement st = con.createStatement();
				String query = "select * from catalogo where producto = '"+bebida+"';";
				ResultSet result=st.executeQuery(query);
                                if(result.next()){
                                    inventario = result.getInt("cantidad_inventario");
                                }
				return inventario;
				
			}catch (SQLException e) {
				System.out.println("Error en búsqueda de inventario ["+e.getMessage()+"]");
			}}
		return inventario;
		
	}
          
    
          public ArrayList obtenerInforme9(){
        ArrayList<Object> listaDeNombres9 = new ArrayList<Object>();
        int n=0;
        int i=0;
       
        Informe8y9VO informe9 = null;
        
        
        for(i=1;i<11;i++){
        if(this.conectar() == true){
            try {
                Statement st = con.createStatement();
                String sql="select nombre_habitacion, avg(cant) as promedio from(\n" +
"select cto.id_habitaciones,h.nombre_habitacion,cto.fecha_ingreso,count(cto.id_habitaciones ) as cant\n" +
"from costos cto,clientes cl,habitaciones h\n" +
"where cto.id_habitaciones="+i+" and cto.rut= cl.rut and cto.id_habitaciones=h.id_habitaciones \n" +
"group by fecha_ingreso order by nombre_habitacion desc)t1;";
                ResultSet result = st.executeQuery(sql);
             

                while(result.next() == true){
                    informe9 = new Informe8y9VO();
                    informe9.setNombre_habitacion(result.getString("nombre_habitacion"));
                    informe9.setPromedio(result.getDouble("promedio"));
                  
              
                    
                    listaDeNombres9.add(n,informe9);
                    //System.out.println(listaDeNombres.get(n));
                    n=n+1;
                    System.out.println(informe9.toString());
                }
                
                
                this.desconectar();
            } catch (SQLException ex) {
                System.out.println("Error en la consulta:[" + ex.getMessage() + "]");
            }
        }
        }
        return listaDeNombres9;
    }
    
        public boolean liberarHabitacion(String id){
        if(conectar()==true){
            try {
                Statement st = con.createStatement();
                String sql = "update habitaciones set ocupacion=0"
                          + " where id_habitaciones='" + id+ "'";
                System.out.println("Modificando:[" + sql + "]");
                int rowsAffected = st.executeUpdate(sql);
                return (rowsAffected==1);
            } catch (SQLException ex) {
                System.out.println("Error al modificar:[" + ex.getMessage() + "]");
            }
        }
        return false;
    }
        int inventario = 0;
        public int compraBebidad(int cantidad, String bebida) {
    		
    		if(this.conectar()) {
    			try {
    				
    				Statement st = con.createStatement();
    				
    				String query2 = "update catalogo set cantidad_inventario = if (( cantidad_inventario-"+cantidad+">=0), cantidad_inventario-"+cantidad+
    						", cantidad_inventario )  where producto = '"+bebida+"';";
    				
    				ResultSet result=st.executeQuery(query2);
    				if(result.rowUpdated()) {
    					return inventario = result.getInt("cantidad_inventario");
    				}else {
    					return inventario;
    				}
    				
    				
    				
    			} catch (SQLException e) {
    				System.out.println("Error al crear cuenta ["+e.getMessage()+"]");
    			}
    			
    		}
    		
    		return inventario;
    	}
    	
    }

        

