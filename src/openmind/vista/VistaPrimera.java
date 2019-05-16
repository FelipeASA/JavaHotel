
package openmind.vista;


import HotelClienteVO.ClienteVO;
import HotelClienteVO.CostoVO;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import proyecto.controlador.Controlador;
import sun.security.util.Length;

/**
 *
 * @author duoc
 */
public class VistaPrimera implements ActionListener{
    private Controlador con;
    private DefaultListModel modelo;
    private JFrame ventana;
    private JTextArea area, area2, area8;
    private JList rut_ingresar;
    private JButton aceptar2, agregarPersona2, validarRut2, aceptar4;
    private JLabel textoencuentraBase2;
    private JLabel tituloPrincipal, titulo2, titulo4;
    private JPanel panel1, panel2, panel3, panel4, panel5, panel6, panel7, panel10, panel8, panel11;
    private JButton registrar, informes, habitaciones;
    private JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
    private JButton volver1,volver2,volver3,volver4,volver10,volver5,volver8, volver11;
    private JLabel i1,i2,i3,i4,i5,i6,i7;
    private JTextField t1,t2,t3,t4,t5,t6,t7;
    private ArrayList<ClienteVO> lista;
    private boolean condicionador;
    private JLabel deValidacion;
    private JButton informe1, informe2, informe3, informe4, informe5, informe6, informe7;
    private JButton informe8, informe9;
    private JRadioButton momento, jornada;
    private ButtonGroup bg;
    private JLabel hab;
    private JButton compraHab, liberarHab, binforme2, comprarProductos;
    private int administrador, modalidad;
    private String listaDeDatos="";
    private JLabel preciofinal, rutsilabel;
    private JScrollPane sp;
    private JTextField rutsillo;
    private JLabel bebida1, bebida2, bebida3, bebida4, preciototal; 
    private JLabel cantidad1, cantidad2, cantidad3, cantidad4;
    private JTextField numero1, numero2, numero3, numero4;
    public VistaPrimera(String titulo){
        initVentana(titulo);
        
    }
    private void initVentana(String titulo){
        ventana=new JFrame(titulo);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setBounds(200, 200, 450, 450);
        con=new Controlador();
        administrador=0;
        modalidad=0;
        initComponentes();
        ventana.setVisible(true);
        
    }
    
    private void initComponentes(){
        tituloPrincipal= new JLabel("Administración Hotel Open Mind");
        tituloPrincipal.setBounds(100, 30, 200, 30);
        //tituloPrincipal.set
        registrar=new JButton("Registrar nuevos pasajeros");
        registrar.setBounds(100, 100, 200, 20);
        registrar.addActionListener(this);
        informes=new JButton("Informes Hotel Open Mind");
        informes.setBounds(100, 150, 200, 20);
        informes.addActionListener(this);
        habitaciones=new JButton("Administrar Habitaciones");
        habitaciones.setBounds(100, 200, 200, 20);
        habitaciones.addActionListener(this);
        
        panel1=new JPanel(null);
        panel1.setBounds(0, 0, 450, 450);
        panel1.add(tituloPrincipal);
        panel1.add(registrar);
        panel1.add(informes);
        panel1.add(habitaciones);
        panel1.setVisible(true);
        ventana.add(panel1);
        
        lista=new ArrayList<>();
        
        panel4=new JPanel(null);
        panel4.setBounds(0, 0, 450, 450);
        panel4.setVisible(false);
        
        //botones para el panel 4
        titulo4=new JLabel("Administración de habitaciones");
        titulo4.setBounds(100, 40, 200, 30);
        
        b1=new JButton("h1");
        b1.setBounds(40, 100, 70, 20);
        colorBoton("1", b1);
        b1.addActionListener(this);

        b2=new JButton("h2");
        b2.setBounds(120, 100, 70, 20);
        colorBoton("2", b2);
        
        
        
        b3=new JButton("h3");
        b3.setBounds(200, 100, 70, 20);
        colorBoton("3", b3);
        b3.addActionListener(this);
        b4=new JButton("h4");
        b4.setBounds(280, 100, 70, 20);
        colorBoton("4", b4);
        b4.addActionListener(this);
        b5=new JButton("h5");
        b5.setBounds(360, 100, 70, 20);
        colorBoton("5", b5);
        b5.addActionListener(this);
        b6=new JButton("h6");
        b6.setBounds(40, 140, 70, 20);
        colorBoton("6", b6);
        b6.addActionListener(this);
        b7=new JButton("h7");
        b7.setBounds(120, 140, 70, 20);
        colorBoton("7", b7);
        b7.addActionListener(this);
        b8=new JButton("h8");
        b8.setBounds(200, 140, 70, 20);
        colorBoton("8", b8);
        b8.addActionListener(this);
        b9=new JButton("h9");
        b9.setBounds(280, 140, 70, 20);
        colorBoton("9", b9);
        b9.addActionListener(this);
        b10=new JButton("h10");
        b10.setBounds(360, 140, 70, 20);
        colorBoton("10", b10);
        b10.addActionListener(this);
        hab=new JLabel("");
        hab.setBounds(300, 320, 120, 20);
        bg=new ButtonGroup();
        momento= new JRadioButton("Momento(3h)");
        momento.setBounds(30, 320, 120, 20);
        momento.setEnabled(false);
        momento.addActionListener(this);
        jornada=new JRadioButton("Jornada(12h)");
        jornada.setBounds(170, 320, 120, 20);
        jornada.setEnabled(false);
        jornada.addActionListener(this);
        bg.add(momento);
        bg.add(jornada);
        area2=new JTextArea();
        area2.setEditable(false);
        area2.setBounds(210, 200 , 180, 100);
        //rut_ingresar=new JList();
        //rut_ingresar.setBounds(50, 200, 300, 100);
        //modelo = new DefaultListModel();
        aceptar4=new JButton("Pagar");
        aceptar4.setBounds(50, 350, 100, 20);
        aceptar4.setEnabled(false);
        aceptar4.addActionListener(this);
        volver4=new JButton("Volver");
        volver4.setBounds(200, 350, 100, 20);
        volver4.addActionListener(this);
        panel4.add(titulo4);
        panel4.add(momento);
        panel4.add(jornada);
        panel4.add(b1);
        panel4.add(b2);
        panel4.add(b3);
        panel4.add(b4);
        panel4.add(b5);
        panel4.add(b6);
        panel4.add(b7);
        panel4.add(b8);
        panel4.add(b9);
        panel4.add(b10);
        //panel4.add(rut_ingresar);
        panel4.add(area2);
        panel4.add(volver4);
        panel4.add(hab);
        panel4.add(aceptar4);
        ventana.add(panel4);
        
        panel2=new JPanel(null);
        panel2.setBounds(0, 0, 450, 450);
        panel2.setVisible(false);
        
        //botones para el panel2
        titulo2=new JLabel("Registro Pasajeros");
        titulo2.setBounds(100, 20, 200, 20);
        i1=new JLabel("Rut");
        i1.setBounds(30, 40, 120, 20);
        textoencuentraBase2=new JLabel("");
        textoencuentraBase2.setBounds(50, 60, 300, 20);
        validarRut2=new JButton("Buscar");
        validarRut2.setBounds(310, 40, 80, 20);
        validarRut2.addActionListener(this);
        i2=new JLabel("Nombres");
        i2.setBounds(30, 90, 120, 20);
        i3=new JLabel("Apellido Paterno");
        i3.setBounds(30, 120, 120, 20);
        i4=new JLabel("Apellido Materno");
        i4.setBounds(30, 150, 120, 20);
        i5=new JLabel("Sexo");
        i5.setBounds(30, 180, 120, 20);
        i6=new JLabel("Fecha Nacimiento");
        i6.setBounds(30, 210, 120, 20);
        i7=new JLabel("Nacionalidad");
        i7.setBounds(30, 240, 120, 20);
        t1=new JTextField();
        t1.setBounds(160, 40, 140, 20);
        t2=new JTextField();
        t2.setBounds(160, 90, 140, 20);
        t3=new JTextField();
        t3.setBounds(160, 120, 140, 20);
        t4=new JTextField();
        t4.setBounds(160, 150, 140, 20);
        t5=new JTextField();
        t5.setBounds(160, 180, 140, 20);
        t6=new JTextField();
        t6.setBounds(160, 210, 140, 20);
        t7=new JTextField();
        t7.setBounds(160, 240, 140, 20);
        deValidacion=new JLabel("");
        deValidacion.setBounds(50, 270, 200, 20);
        deValidacion.setVisible(!validador());
        agregarPersona2=new JButton("Agregar Persona");
        agregarPersona2.setBounds(25, 345, 150, 20);
        agregarPersona2.addActionListener(this);
        aceptar2=new JButton("Aceptar");
        aceptar2.setBounds(185, 345, 100, 20);
        aceptar2.addActionListener(this);
        volver2=new JButton("Cancelar");
        volver2.setBounds(295, 345, 90, 20);
        volver2.addActionListener(this);
        panel2.add(titulo2);
        panel2.add(validarRut2);
        panel2.add(textoencuentraBase2);
        panel2.add(i1);
        panel2.add(i2);
        panel2.add(i3);
        panel2.add(i4);
        panel2.add(i5);
        panel2.add(i6);
        panel2.add(i7);
        panel2.add(t1);
        panel2.add(t2);
        panel2.add(t3);
        panel2.add(t4);
        panel2.add(t5);
        panel2.add(t6);
        panel2.add(t7);
        panel2.add(deValidacion);
        panel2.add(agregarPersona2);
        panel2.add(aceptar2);
        panel2.add(volver2);
        ventana.add(panel2);
        
        panel5=new JPanel(null);
        panel5.setBounds(0, 0, 450, 450);
        panel5.setVisible(false);
        informe1=new JButton("Comportamiento Clientes");
        informe1.setBounds(100, 30, 200, 20);
        informe1.addActionListener(this);
        informe2=new JButton("Informe de Clientes");
        informe2.setBounds(100, 60, 200, 20);
        informe2.addActionListener(this);
        informe3=new JButton("Informe Cliente del Amor <3");
        informe3.setBounds(100, 90, 200, 20);
        informe3.addActionListener(this);
        informe4=new JButton("Habitación más utilizada");
        informe4.setBounds(100, 120, 200, 20);
        informe4.addActionListener(this);
        informe5=new JButton("Habitación menos utilizada");
        informe5.setBounds(100, 150, 200, 20);
        informe5.addActionListener(this);
        informe6=new JButton("Producto más vendido");
        informe6.setBounds(100, 180, 200, 20);
        informe6.addActionListener(this);
        informe7=new JButton("Producto menos vendido");
        informe7.setBounds(100, 210, 200, 20);
        informe7.addActionListener(this);
        informe8=new JButton("Habitación más concurrida");
        informe8.setBounds(100, 240, 200, 20);
        informe8.addActionListener(this);
        informe9=new JButton("Promedio de pasajeros por periodo");
        informe9.setBounds(100, 270, 200, 20);
        informe9.addActionListener(this);
        volver5=new JButton("Volver");
        volver5.setBounds(300,350,100,20);
        volver5.addActionListener(this);
        panel5.add(informe1);
        panel5.add(informe2);
        panel5.add(informe3);
        panel5.add(informe4);
        panel5.add(informe5);
        panel5.add(informe6);
        panel5.add(informe7);
        panel5.add(informe8);
        panel5.add(informe9);
        
        ventana.add(panel5);
        
        panel6=new JPanel(null);
        panel6.setBounds(0, 0, 450, 450);
        panel6.setVisible(false);
        
        panel7=new JPanel(null);
        panel7.setBounds(0, 0, 450, 450);
        panel7.setVisible(false);
        
        
        panel8=new JPanel(null);
        panel8.setBounds(0, 0, 450, 450);
        panel8.setVisible(false);
        
        volver8=new JButton("Volver");
        volver8.setBounds(300,380,120,20);
        volver8.addActionListener(this);
        area8=new JTextArea();
        sp=new JScrollPane(area8);
        sp.setBounds(30, 100, 400, 250);
        rutsillo=new JTextField();
        rutsillo.setBounds(150, 50, 100, 20);
        rutsillo.setVisible(false);
        rutsilabel=new JLabel("Rut");
        rutsilabel.setBounds(20, 50, 120, 20);
        rutsilabel.setVisible(false);
        binforme2=new JButton("Buscar");
        binforme2.setBounds(280 , 50, 100, 20);
        binforme2.setVisible(false);
        binforme2.addActionListener(this);
        panel8.add(rutsilabel);
        panel8.add(binforme2);
        panel8.add(sp);
        panel8.add(rutsillo);
        panel8.add(volver8);
        ventana.add(panel8);
        
        compraHab=new JButton("Comprar Habitaciones");
        compraHab.setBounds(100, 100, 200, 20);
        compraHab.addActionListener(this);
        liberarHab=new JButton("Liberar Habitaciones");
        liberarHab.setBounds(100, 150, 200, 20);
        liberarHab.addActionListener(this);
        volver10=new JButton("Volver");
        volver10.setBounds(250, 300, 150, 20);
        volver10.addActionListener(this);
        panel10=new JPanel(null);
        panel10.setBounds(0, 0, 450, 450);
        panel10.add(compraHab);
        panel10.add(liberarHab);
        panel10.add(volver10);
        panel10.setVisible(false);
        ventana.add(panel10);
        
        
        bebida1=new JLabel("7up");
        bebida1.setBounds(100,100,150,20);
        bebida2=new JLabel("cocacola");
        bebida2.setBounds(100,150,150,20);
        bebida3=new JLabel("fanta");
        bebida3.setBounds(100,200,150,20);
        bebida4=new JLabel("sprite");
        bebida4.setBounds(100,250,150,20);
        numero1= new JTextField();
        numero1.setBounds(260, 100, 50, 20);
        cantidad1= new JLabel("");
        cantidad1.setText(Integer.toString(con.inventarioBebida(bebida1.getText())));
        cantidad1.setBounds(320, 100, 50, 20);
        numero2= new JTextField();
        numero2.setBounds(260, 150, 50, 20);
        cantidad2= new JLabel("");
        cantidad2.setText(Integer.toString(con.inventarioBebida(bebida2.getText())));
        cantidad2.setBounds(320, 150, 50, 20);
        numero3= new JTextField();
        numero3.setBounds(260, 200, 50, 20);
        cantidad3= new JLabel("");
        cantidad3.setText(Integer.toString(con.inventarioBebida(bebida3.getText())));
        cantidad3.setBounds(320, 200, 50, 20);
        numero4= new JTextField();
        numero4.setBounds(260, 250, 50, 20);
        cantidad4= new JLabel("");
        cantidad4.setText(Integer.toString(con.inventarioBebida(bebida4.getText())));
        cantidad4.setBounds(320, 250, 50, 20);
        volver11=new JButton("Volver");
        volver11.setBounds(300, 350, 120, 20);
        comprarProductos= new JButton("Comprar");
        comprarProductos.setBounds(100,350,120,20);
        comprarProductos.addActionListener(this);
        panel11=new JPanel(null);
        panel11.setBounds(0, 0, 450, 450);
        panel11.setVisible(false);
        panel11.add(bebida1);
        panel11.add(bebida2);
        panel11.add(bebida3);
        panel11.add(bebida4);
        panel11.add(numero1);
        panel11.add(cantidad1);
        panel11.add(numero2);
        panel11.add(cantidad2);
        panel11.add(numero3);
        panel11.add(cantidad3);
        panel11.add(numero4);
        panel11.add(cantidad4);
        panel11.add(volver11);
        panel11.add(comprarProductos);
        ventana.add(panel11);
        
    }
    
    public void actionPerformed(ActionEvent e){
        
        
        
        if(e.getSource().equals(aceptar2)){
            if(validador()){
                ClienteVO nuevo=new ClienteVO();
            nuevo.setRut(t1.getText());
            nuevo.setNombre(t2.getText());
            nuevo.setApellidosPaterno(t3.getText());
            nuevo.setApellidoMaterno(t4.getText());
            nuevo.setSexo(t5.getText().charAt(0));
            nuevo.setFechaNacimiento(t6.getText());
            nuevo.setNacionalidad(t7.getText());
            if(!encontradoEnBase(t1.getText())){
                System.out.println("bkn");
                con.insertarCliente(nuevo);
            }
            else{
                System.out.println("estamos en la b");
            }
            lista.add(nuevo);
            panel2.setVisible(false);
            panel4.setVisible(true);
            Iterator<ClienteVO> it = lista.iterator();
            
 
            while (it.hasNext()) {
                //modelo.addElement(it.next().getRut());
                listaDeDatos+=it.next().getRut()+",";
 
            }
            listaDeDatos=listaDeDatos.substring(0,listaDeDatos.length()-1);
            area=new JTextArea(listaDeDatos);
            area.setEditable(false);
            area.setBounds(50, 200, 120 , 100);
            panel4.add(area);
            condicionador=true;
            }
            else{
                
                deValidacion.setText("Debe rellenar todos los campos");
                deValidacion.setVisible(true);
            }
    }
            
        if(e.getSource().equals(habitaciones)){
            panel1.setVisible(false);
            panel10.setVisible(true);
            
            
            
            
        }
        if(e.getSource().equals(informes)){
            panel1.setVisible(false);
            panel5.setVisible(true);
        }
        if(e.getSource().equals(registrar)){
            panel1.setVisible(false);
            panel2.setVisible(true);
        }
        if(e.getSource().equals(b1)){
            if(administrador==0){
               if(b1.getBackground().equals(Color.green)){
                b1.setBackground(Color.red);
                String id="1";
                
                area2.setEditable(false);
                
                area2.setText(con.mostrarDetalles(id).toString());
                area2.setVisible(true);
                area2.setBounds(210, 200 , 180, 100);
                hab.setText(id);
                panel4.add(area2);
                momento.setEnabled(true);
                jornada.setEnabled(true);
            }
            }
            if(administrador==1){
                if(b1.getBackground().equals(Color.red)){
                    b1.setBackground(Color.green);
                    String id="1";
                    con.liberarHabitaciones(id);
                }
                
            }
            if(administrador==2){
                panel11.setVisible(true);
                panel4.setVisible(false);
                
                
            }
            
        }
        if(e.getSource().equals(b2)){
            if(administrador==0){
               if(b1.getBackground().equals(Color.green)){
                b1.setBackground(Color.red);
                String id="2";
                
                area2.setEditable(false);
                
                area2.setText(con.mostrarDetalles(id).toString());
                area2.setVisible(true);
                area2.setBounds(210, 200 , 180, 100);
                hab.setText(id);
                panel4.add(area2);
                momento.setEnabled(true);
                jornada.setEnabled(true);
            }
            }
            if(administrador==1){
                if(b1.getBackground().equals(Color.red)){
                    b1.setBackground(Color.green);
                    String id="2";
                    con.liberarHabitaciones(id);
                }
                
            }
            if(administrador==2){
                panel11.setVisible(true);
                panel4.setVisible(false);
                
                
            }
        }
        if(e.getSource().equals(b3)){
            if(administrador==0){
               if(b1.getBackground().equals(Color.green)){
                b1.setBackground(Color.red);
                String id="3";
                
                area2.setEditable(false);
                
                area2.setText(con.mostrarDetalles(id).toString());
                area2.setVisible(true);
                area2.setBounds(210, 200 , 180, 100);
                hab.setText(id);
                panel4.add(area2);
                momento.setEnabled(true);
                jornada.setEnabled(true);
            }
            }
            if(administrador==1){
                if(b1.getBackground().equals(Color.red)){
                    b1.setBackground(Color.green);
                    String id="3";
                    con.liberarHabitaciones(id);
                }
                
            }
            if(administrador==2){
                panel11.setVisible(true);
                panel4.setVisible(false);
                
                
            }
        }
        if(e.getSource().equals(b4)){
             if(administrador==0){
               if(b1.getBackground().equals(Color.green)){
                b1.setBackground(Color.red);
                String id="4";
                
                area2.setEditable(false);
                
                area2.setText(con.mostrarDetalles(id).toString());
                area2.setVisible(true);
                area2.setBounds(210, 200 , 180, 100);
                hab.setText(id);
                panel4.add(area2);
                momento.setEnabled(true);
                jornada.setEnabled(true);
            }
            }
            if(administrador==1){
                if(b1.getBackground().equals(Color.red)){
                    b1.setBackground(Color.green);
                    String id="4";
                    con.liberarHabitaciones(id);
                }
                
            }
            if(administrador==2){
                panel11.setVisible(true);
                panel4.setVisible(false);
                
                
            }
        }
        if(e.getSource().equals(b5)){
            if(administrador==0){
               if(b1.getBackground().equals(Color.green)){
                b1.setBackground(Color.red);
                String id="5";
                
                area2.setEditable(false);
                
                area2.setText(con.mostrarDetalles(id).toString());
                area2.setVisible(true);
                area2.setBounds(210, 200 , 180, 100);
                hab.setText(id);
                panel4.add(area2);
                momento.setEnabled(true);
                jornada.setEnabled(true);
            }
            }
            if(administrador==1){
                if(b1.getBackground().equals(Color.red)){
                    b1.setBackground(Color.green);
                    String id="5";
                    con.liberarHabitaciones(id);
                }
                
            }
            if(administrador==2){
                panel11.setVisible(true);
                panel4.setVisible(false);
                
                
            }
        }
        if(e.getSource().equals(b6)){
            if(administrador==0){
               if(b1.getBackground().equals(Color.green)){
                b1.setBackground(Color.red);
                String id="6";
                
                area2.setEditable(false);
                
                area2.setText(con.mostrarDetalles(id).toString());
                area2.setVisible(true);
                area2.setBounds(210, 200 , 180, 100);
                hab.setText(id);
                panel4.add(area2);
                momento.setEnabled(true);
                jornada.setEnabled(true);
            }
            }
            if(administrador==1){
                if(b1.getBackground().equals(Color.red)){
                    b1.setBackground(Color.green);
                    String id="6";
                    con.liberarHabitaciones(id);
                }
                
            }
            if(administrador==2){
                panel11.setVisible(true);
                panel4.setVisible(false);
                
                
            }
        }
        if(e.getSource().equals(b7)){
            if(administrador==0){
               if(b1.getBackground().equals(Color.green)){
                b1.setBackground(Color.red);
                String id="7";
                
                area2.setEditable(false);
                
                area2.setText(con.mostrarDetalles(id).toString());
                area2.setVisible(true);
                area2.setBounds(210, 200 , 180, 100);
                hab.setText(id);
                panel4.add(area2);
                momento.setEnabled(true);
                jornada.setEnabled(true);
            }
            }
            if(administrador==1){
                if(b1.getBackground().equals(Color.red)){
                    b1.setBackground(Color.green);
                    String id="7";
                    con.liberarHabitaciones(id);
                }
                
            }
            if(administrador==2){
                panel11.setVisible(true);
                panel4.setVisible(false);
                
                
            }
        }
        
        if(e.getSource().equals(validarRut2)){
            //se busca en la base de datos, para ver si encuentra el rut
            //se agrega un label que muestra que el cliente ya fue agregado
            //a la clase cliente sólo se le entrega el rut
            //ClienteVO verificar=new ClienteVO();
            //verificar.setRut(t1.getText());
            if(encontradoEnBase(t1.getText())){
                textoencuentraBase2.setText("El Rut ya se encuentra en la base");
                t2.setText(con.mostrarDatos(t1.getText()).getNombre());
                t3.setText(con.mostrarDatos(t1.getText()).getApellidosPaterno());
                t4.setText(con.mostrarDatos(t1.getText()).getApellidoMaterno());
                t5.setText(Character.toString(con.mostrarDatos(t1.getText()).getSexo()));
                t6.setText(con.mostrarDatos(t1.getText()).getFechaNacimiento());
                t7.setText(con.mostrarDatos(t1.getText()).getNacionalidad());

           }
            else{
                textoencuentraBase2.setText("El Rut no está en la base de datos imbécil");
            }
        }
        if(e.getSource().equals(agregarPersona2)){
            //se crea el cliente con los datos, pero si ya se rellenó con validarRut, sólo se entrega
            if(validador()){
                ClienteVO nuevo=new ClienteVO();
                nuevo.setRut(t1.getText());
                nuevo.setNombre(t2.getText());
                nuevo.setApellidosPaterno(t3.getText());
                nuevo.setApellidoMaterno(t4.getText());
                nuevo.setSexo(t5.getText().charAt(0));
                nuevo.setFechaNacimiento(t6.getText());
                nuevo.setNacionalidad(t7.getText());
                if(!encontradoEnBase(t1.getText())){
                    con.insertarCliente(nuevo);
                }                
                lista.add(nuevo);
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
                t7.setText("");
            }
            else{
                
                deValidacion.setText("Debe rellenar todos los campos");
                deValidacion.setVisible(true);
            }
        }
        if(e.getSource().equals(b8)){
            if(administrador==0){
               if(b1.getBackground().equals(Color.green)){
                b1.setBackground(Color.red);
                String id="8";
                
                area2.setEditable(false);
                
                area2.setText(con.mostrarDetalles(id).toString());
                area2.setVisible(true);
                area2.setBounds(210, 200 , 180, 100);
                hab.setText(id);
                panel4.add(area2);
                momento.setEnabled(true);
                jornada.setEnabled(true);
            }
            }
            if(administrador==1){
                if(b1.getBackground().equals(Color.red)){
                    b1.setBackground(Color.green);
                    String id="8";
                    con.liberarHabitaciones(id);
                }
                
            }
            if(administrador==2){
                panel11.setVisible(true);
                panel4.setVisible(false);
                
                
            }
        }
        if(e.getSource().equals(b9)){
            if(administrador==0){
               if(b1.getBackground().equals(Color.green)){
                b1.setBackground(Color.red);
                String id="9";
                
                area2.setEditable(false);
                
                area2.setText(con.mostrarDetalles(id).toString());
                area2.setVisible(true);
                area2.setBounds(210, 200 , 180, 100);
                hab.setText(id);
                panel4.add(area2);
                momento.setEnabled(true);
                jornada.setEnabled(true);
            }
            }
            if(administrador==1){
                if(b1.getBackground().equals(Color.red)){
                    b1.setBackground(Color.green);
                    String id="9";
                    con.liberarHabitaciones(id);
                }
                
            }
            if(administrador==2){
                panel11.setVisible(true);
                panel4.setVisible(false);
                
                
            }
        }
        if(e.getSource().equals(b10)){
            if(administrador==0){
               if(b1.getBackground().equals(Color.green)){
                b1.setBackground(Color.red);
                String id="10";
                
                area2.setEditable(false);
                
                area2.setText(con.mostrarDetalles(id).toString());
                area2.setVisible(true);
                area2.setBounds(210, 200 , 180, 100);
                hab.setText(id);
                panel4.add(area2);
                momento.setEnabled(true);
                jornada.setEnabled(true);
            }
            }
            if(administrador==1){
                if(b1.getBackground().equals(Color.red)){
                    b1.setBackground(Color.green);
                    String id="10";
                    con.liberarHabitaciones(id);
                }
                
            }
            if(administrador==2){
                panel11.setVisible(true);
                panel4.setVisible(false);
                
                
            }
        }
        if(e.getSource().equals(volver4)){
            panel4.setVisible(false);
            panel10.setVisible(true);
        }
        if(e.getSource().equals(volver10)){
            panel10.setVisible(false);
            panel1.setVisible(true);
        }
        
        if(e.getSource().equals(volver2)){
            panel2.setVisible(false);
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            t6.setText("");
            t7.setText("");
            panel1.setVisible(true);
            lista.clear();
        }
        if(e.getSource().equals(momento)){
            modalidad=1;
            //System.out.println("hola");
            aceptar4.setEnabled(true);
        }
        if(e.getSource().equals(jornada)){
            modalidad=2;
            aceptar4.setEnabled(true);
        }
        if(e.getSource().equals(aceptar4)){
            String[] ruts=listaDeDatos.split(",");
            int habi=Integer.parseInt(hab.getText());
            for(int i=0;i<ruts.length;i++){
                //guardarCosto(ruts[i], modalidad,habi);
                if(con.insertarCosto(guardarCosto(ruts[i], modalidad,habi))){
                    con.modificarOcupacion(guardarCosto(ruts[i], modalidad,habi));
                    System.out.println("Si se pudo");
                }
                else{
                    System.out.println("No se pudo");
                }
            }
            
        }
        if(e.getSource().equals(informe1)){
            panel8.setVisible(true);
            panel5.setVisible(false);
            area8.setText(con.obtenerInforme1().toString());
            area8.setEditable(false);
        }
        if(e.getSource().equals(informe2)){
            panel8.setVisible(true);
            panel5.setVisible(false);
            rutsillo.setVisible(true);
            binforme2.setVisible(true);
            //area8.setText(con.obtenerInforme2(rutsillo.getText()).toString());
            area8.setEditable(false);
        }
        if(e.getSource().equals(binforme2)){
            area8.setText(con.obtenerInforme2(rutsillo.getText()).toString());
        }
        if(e.getSource().equals(volver8)){
            area8.setText("");
            panel8.setVisible(false);
            panel5.setVisible(true);
        }
        if(e.getSource().equals(informe3)){
            panel8.setVisible(true);
            panel5.setVisible(false);
            area8.setText(con.obtenerInforme3().toString());
            area8.setEditable(false);
        }
        if(e.getSource().equals(informe4)){
            panel8.setVisible(true);
            panel5.setVisible(false);
            area8.setText(con.obtenerInforme4().toString());
            area8.setEditable(false);
        }
        if(e.getSource().equals(informe5)){
            panel8.setVisible(true);
            panel5.setVisible(false);
            area8.setText(con.obtenerInforme5().toString());
            area8.setEditable(false);
        }
        if(e.getSource().equals(informe6)){
            panel8.setVisible(true);
            panel5.setVisible(false);
            area8.setText(con.obtenerInforme6().toString());
            area8.setEditable(false);
        }
        if(e.getSource().equals(informe7)){
            panel8.setVisible(true);
            panel5.setVisible(false);
            area8.setText(con.obtenerInforme7().toString());
            area8.setEditable(false);
        }
        if(e.getSource().equals(informe8)){
            panel8.setVisible(true);
            panel5.setVisible(false);
            area8.setText("En Proceso");
            //area8.setText(con.obtenerInforme1().toString());
            area8.setEditable(false);
        }
        if(e.getSource().equals(informe9)){
            panel8.setVisible(true);
            panel5.setVisible(false);
            area8.setText(con.obtenerInforme9().toString());
            area8.setEditable(false);
        }
        
                                                                        
        if(e.getSource().equals(compraHab)){
            System.out.println("Boton comprahab");
            panel10.setVisible(false);
            panel4.setVisible(true);
            administrador=2;
            area2.setVisible(false);
            hab.setVisible(false);
            aceptar4.setVisible(false);
            momento.setVisible(false);
            jornada.setVisible(false);
            colorBotonHab("1", b1);
            colorBotonHab("2", b2);
            colorBotonHab("3", b3);
            colorBotonHab("4", b4);
            colorBotonHab("5", b5);
            colorBotonHab("6", b6);
            colorBotonHab("7", b7);
            colorBotonHab("8", b8);
            colorBotonHab("9", b9);
            colorBotonHab("10", b10);
        
            
        }
        if(e.getSource().equals(liberarHab)){
            administrador=1;
            panel10.setVisible(false);
            panel4.setVisible(true);
            area2.setVisible(false);
            hab.setVisible(false);
            aceptar4.setVisible(false);
            momento.setVisible(false);
            jornada.setVisible(false);
            colorBotonHab("1", b1);
            colorBotonHab("2", b2);
            colorBotonHab("3", b3);
            colorBotonHab("4", b4);
            colorBotonHab("5", b5);
            colorBotonHab("6", b6);
            colorBotonHab("7", b7);
            colorBotonHab("8", b8);
            colorBotonHab("9", b9);
            colorBotonHab("10", b10);
        }
    }
    
    private boolean validador(){
        //valida de que los datos, sean no nulos, para ingresarlos 
        //boolean validacion=false;
        
        boolean validacion=false;
        if(noVacio(t1.getText()) && noVacio(t2.getText()) && noVacio(t3.getText()) && noVacio(t4.getText()) && noVacio(t5.getText()) && noVacio(t6.getText()) && noVacio(t7.getText())){
            validacion=true;
        }
        return validacion;
    }
    private boolean encontradoEnBase(String cliente){
        ClienteVO encontrado=new ClienteVO();
            //se condiciona, de manera de ver si se encuentra en la base.
            //si se encuentra, entonces pasa a ser verdadero
        encontrado = con.mostrarDatos(cliente);
        if(noVacio(encontrado.getNombre())){
            return true;
        }else{
            return false;
        }
        
        
    }
    private boolean noVacio(String r){
        return (r!=null && !r.isEmpty());
    }
    
    private void colorBoton(String id, JButton boton){
        if(con.mostrarDetalles(id).getOcupacion()==1){
            
            boton.setBackground(Color.red);
            boton.setOpaque(true);
            boton.setBorderPainted(false);
            boton.setEnabled(false);
        }
        else{
            boton.setBackground(Color.green);
            boton.setOpaque(true);
            boton.setBorderPainted(false);
            boton.setEnabled(true);
        }
    }
    private void colorBotonHab(String id, JButton boton){
        if(con.mostrarDetalles(id).getOcupacion()==1){
            
            boton.setBackground(Color.red);
            boton.setOpaque(true);
            boton.setBorderPainted(false);
            boton.setEnabled(true);
        }
        else{
            boton.setBackground(Color.green);
            boton.setOpaque(true);
            boton.setBorderPainted(false);
            boton.setEnabled(false);
        }
    }
    
    public void ActionPerformed(ActionEvent e){
        String etiqueta="Has pulsado el botón " + e.getActionCommand();
        
    }
    public String fechaHoy(){
        Calendar c1=Calendar.getInstance();
        String dia = Integer.toString(c1.get(Calendar.DATE));
        String mes = Integer.toString(c1.get(Calendar.MONTH));
        String annio = Integer.toString(c1.get(Calendar.YEAR));
        String fecha=dia+"/"+mes+"/"+annio;
        return fecha;
    }
    
    public CostoVO guardarCosto(String rut, int id, int hab){
        CostoVO costo=new CostoVO();
        costo.setFecha_ingreso(fechaHoy());
        costo.setId_modalidad(id);
        costo.setInt_habitaciones(hab);
        costo.setRut(rut);
        return costo;
    }
    
    
}
