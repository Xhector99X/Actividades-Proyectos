package ppracticat4ad;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.*;
import org.neodatis.odb.*;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class Listado extends JFrame implements ActionListener{
        JPanel miPanel;   
        JLabel tituloT;
        JLabel miCampoResultado;
        JTable tabla;
        JScrollPane scroll;
        JButton volverB;
        
         ArrayList<Vehiculo> vector = new ArrayList<>();
    Vehiculo miVehiculo;
        
            public Listado(){
                this.setResizable(false);
                this.setTitle("Listado Vehiculos");
                this.setSize(600,500);
                this.setDefaultCloseOperation(EXIT_ON_CLOSE);
                this.setLocationRelativeTo(null);
                
                miPanel = new JPanel();
                miPanel.setLayout(null);
                
                tituloT = new JLabel("Listado de Vehiculos");
                tituloT.setBounds(250,10,200,30);
                miPanel.add(tituloT);
                
                miCampoResultado = new JLabel("");
                miCampoResultado.setBounds(250, 50, 200, 30);
                miPanel.add(miCampoResultado);
                
                
                
                
                
                
                ODB conexion = ODBFactory.open("vehiculos.neo");// Abrir BD
                
                   //NECESITO LISTAR LOS DATOS INTRODUCIDOS
            //recuperamos todos los objetos
            Objects<Vehiculo> objectos = conexion.getObjects(Vehiculo.class);
            System.out.println("Vehículos: " + objectos.size());
            int i = 1;
            // visualizar los objetos mientras haya objeto que mostrar
            while (objectos.hasNext()) {
                // Recuperamos el objeto de tipo Jugadores
                
                
                Vehiculo h = objectos.next();
                System.out.println(i + ": " + h.getMatricula() + " " + h.getMarca() + " " + h.getModelo() + " " + h.getPrecio());
                i++;
            }
            
                  System.out.println("Conexión realizada");

                 //Array de Cabecera para la tabla
                String[] campos = new String[]
                {"Matricula","Marca","Modelo","Precio"};
                
                //Array de Datos para la tabla
                Object[][] datos;
                
                //En esta línea está la clave
                IQuery query = new CriteriaQuery(Vehiculo.class);
        Objects<Vehiculo> objects = conexion.getObjects(query);
        
         
                        datos = new Object[objects.size()][5];
                        
                        int h = 0;
                        while(objects.hasNext()){
                            Vehiculo peli = (Vehiculo)objects.next();
                            datos[h][0]=peli.getMatricula();
                            datos[h][1]=peli.getMarca();
                            datos[h][2]=peli.getModelo();
                            datos[h][3]=peli.getPrecio();
                            h++;
                        }
                        //Cramosscroll la tabla pasandoles el array de datos y de campos
                        tabla = new JTable(datos,campos);
                        //Volcamos la tabla en el ScrollPane
                        scroll = new JScrollPane(tabla);
                        //Posicionamos el ScrollPane
                        
                        scroll.setBounds(10,60,580,350);
                        //Añadimos el panel JScrollPane al Panel
                        miPanel.add(scroll); 
         
                
                conexion.close();
                
                
         
                // x,y,ancho,alto
                volverB = new JButton("Volver");
                volverB.setBounds(450,420,100,30);
                miPanel.add(volverB);
                
   
               
                volverB.addActionListener(this);
                
                
                this.add(miPanel);
                
            }
            
            @Override
            public void actionPerformed(ActionEvent e){
               
                 
                 
                if(e.getSource()==volverB){
                   //Codigo al pulsar botón de baja
                   Menu miMenu = new Menu();
                   miMenu.setVisible(true);
                   this.dispose();
                }
                
  
                    
                }
        }



