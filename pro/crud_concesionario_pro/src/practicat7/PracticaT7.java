package practicat7;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.time.*;
import java.time.format.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
public class PracticaT7 {
    public static void main(String[] args) {
         Formulario miFormulario = new Formulario();
        miFormulario.setVisible(true);
        
    }
    
}
//(3) Implementar interface ActionListener
class Formulario extends JFrame implements ActionListener{
    JPanel miCapa;
    JLabel miMatricula;
    JTextField miCampoMatricula;
    
    JLabel miMarca;
    JTextField miCampoMarca;
    
    JLabel miModelo;
    JTextField miCampoModelo;
    
    JLabel miFechaMatri;
    JTextField miCampoFechaMatri;
    
    JLabel miCilindrada;
    JTextField miCampoCilindrada;
    
    JLabel miPotencia;
    JTextField miCampoPotencia;
    
    JLabel miHoraLlegada;
    JTextField miCampoHoraLlegada;
    
    JLabel miCampoResultado;
    
    
    JButton cerrar;
    JLabel nombreCompleto;
    JButton aniadir;
    JButton borrar;
    JButton lista;
    
    ArrayList<Vehiculo> vector =  new ArrayList<>();
    Vehiculo miVehiculo;
    
    
    public Formulario(){
        this.setTitle("Mi aplicación Java");
        this.setSize(700,500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        miCapa = new JPanel();
        miCapa.setLayout(null);
        
        miMatricula = new JLabel();
        miMatricula.setBounds(20,30,100,30);
        //xx, y, ancho , alto
        
        //color texto
        Color miColor = new Color(255,0,0);
        miMatricula.setForeground(miColor);
        miCapa.add(miMatricula);
        
        //Fondo 
        Color miFondo = new Color(192, 240, 10  );
        miCapa.setBackground(miFondo);
        
        
       miMatricula.setText("Matrícula:");
       miCapa.add(miMatricula);
        
       miCampoMatricula = new JTextField();
       miCampoMatricula.setBounds(130,30,120,30);
       miCapa.add(miCampoMatricula);
       
       
        miMarca = new JLabel();
       
        miMarca.setBounds(20,80,100,30);
        miMarca.setText("Marca:");
        miMarca.setForeground(miColor);
        miCapa.add(miMarca);
        
       miCampoMarca = new JTextField();
       miCampoMarca.setBounds(130,80,120,30);
       miCapa.add(miCampoMarca);
       
       
       
       miModelo = new JLabel();
       
        miModelo.setBounds(20,130,100,30);
        miModelo.setText("Modelo:");
        miModelo.setForeground(miColor);
        miCapa.add(miModelo);
        
       miCampoModelo = new JTextField();
       miCampoModelo.setBounds(130,130,120,30);
       miCapa.add(miCampoModelo);
       
       
       
       
       miFechaMatri = new JLabel();
       
        miFechaMatri.setBounds(20,180,100,30);
        miFechaMatri.setText("Fecha matricula:");
        miFechaMatri.setForeground(miColor);
        miCapa.add(miFechaMatri);
        
       miCampoFechaMatri = new JTextField();
       miCampoFechaMatri.setBounds(130,180,120,30);
       miCapa.add(miCampoFechaMatri);
       
       
       
       
       miCilindrada = new JLabel();
       
        miCilindrada.setBounds(20,230,100,30);
        miCilindrada.setText("Cilindrada:");
        miCilindrada.setForeground(miColor);
        miCapa.add(miCilindrada);
        
       miCampoCilindrada = new JTextField();
       miCampoCilindrada.setBounds(130,230,120,30);
       miCapa.add(miCampoCilindrada);
       
       
       
       miPotencia = new JLabel();
       
        miPotencia.setBounds(20,280,100,30);
        miPotencia.setText("Potencia:");
        miPotencia.setForeground(miColor);
        miCapa.add(miPotencia);
        
       miCampoPotencia = new JTextField();
       miCampoPotencia.setBounds(130,280,120,30);
       miCapa.add(miCampoPotencia);
       
       
       
       
       
       
       miCampoResultado = new JLabel();
       miCampoResultado.setBounds(320,20,350,350);
       miCapa.add(miCampoResultado);
       
       
       
       

       
       
       
       
       
       
       
       
       
  
       //botón
       cerrar = new JButton("Salir");
       cerrar.setBounds(360,400,80,30);
       miCapa.add(cerrar);
       
       //Etiqueta donde Volcará nombre y apellidos
        nombreCompleto = new JLabel();    
        nombreCompleto.setBounds(20,180,200,30);
        miCapa.add(nombreCompleto);
        
       //Muestra botón para coger los datos del formulario 
       aniadir = new JButton("Añadir vehículos");
       aniadir.setBounds(210,400,120,30);
       miCapa.add(aniadir);
       
       borrar = new JButton("Borrar");
       borrar.setBounds(60,400,120,30);
       miCapa.add(borrar);
       
       
       lista = new JButton("Lista");
       lista.setBounds(510,400,120,30);
       miCapa.add(lista);
       
       
       
       //(1) botón a la escucha
       cerrar.addActionListener(this);
       aniadir.addActionListener(this);
       borrar.addActionListener(this);
       lista.addActionListener(this);
       
       //Añadimos JPanel al Formulario
        this.add(miCapa);
    }
    //(4) Sobreescribir el método actionPerformed
    //y parametro e recoge información del evento
    //e.getSource devuelve quien originó el evento
     @Override
       public void actionPerformed(ActionEvent e){
           if(e.getSource()==cerrar){
               System.exit(0);
           }
           if(e.getSource()==aniadir){
              // LocalDate fechaHoy = LocalDate.now();
              DateTimeFormatter formato = DateTimeFormatter.ofPattern("d/MM/yyyy");
              String fechaCadena = miCampoFechaMatri.getText();
              LocalDate mifecha = LocalDate.parse(fechaCadena, formato);
              
               miVehiculo = new Vehiculo(miCampoMatricula.getText(), miCampoMarca.getText(),miCampoModelo.getText(),mifecha, Integer.valueOf(miCampoCilindrada.getText()), Integer.valueOf(miCampoPotencia.getText()));
               
               vector.add(miVehiculo);
               miCampoMatricula.setText("");
               miCampoMarca.setText("");
               miCampoModelo.setText("");
               miCampoFechaMatri.setText("");
               miCampoCilindrada.setText("");
               miCampoPotencia.setText("");
               
                 
           }
           
           
           if(e.getSource()==borrar){
               vector.remove(0);
           }
           
           if(e.getSource()==lista){
                 
  
                 String listadoSt;
            int i;
            
            listadoSt = "<html>";
            for (i = 0; i < vector.size(); i++) {
                listadoSt += vector.get(i);
            }
            listadoSt += "</html>";
            miCampoResultado.setText(listadoSt);
                 
           }
       }
}
    