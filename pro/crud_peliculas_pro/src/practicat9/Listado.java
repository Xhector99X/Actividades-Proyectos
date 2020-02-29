package practicat9;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import com.db4o.*;

public class Listado extends JFrame implements ActionListener{
        JPanel miPanel;   
        JLabel tituloT;
        JTable tabla;
        JScrollPane scroll;
        JButton volverB;
        
        
        
            public Listado(){
                this.setResizable(false);
                this.setTitle("Listado Peliculas");
                this.setSize(600,500);
                this.setDefaultCloseOperation(EXIT_ON_CLOSE);
                this.setLocationRelativeTo(null);
                
                miPanel = new JPanel();
                miPanel.setLayout(null);
                
                tituloT = new JLabel("Listado de Peliculas");
                tituloT.setBounds(250,10,200,30);
                miPanel.add(tituloT);
                
                ObjectContainer base = Db4oEmbedded.openFile("peliculas.db4o");
                System.out.println("Conexión realizada");
                
                //Array de Cabecera para la tabla
                String[] campos = new String[]
                {"ID Pelicula","Titulo","Tema","Duracion","Precio"};
                
                
                //Array de Datos para la tabla
                Object[][] datos;
                
                //Listar objetos de la base de datos     
                
            Pelicula empleadoCondicion = new Pelicula(0, null,null,0,0);
            ObjectSet resultado = base.queryByExample(empleadoCondicion);
        
         
                        datos = new Object[resultado.size()][5];
                        
                        int i = 0;
                        while(resultado.hasNext()){
                            Pelicula peli = (Pelicula)resultado.next();
                            datos[i][0]=peli.getIdEmpleado();
                            datos[i][1]=peli.getTitulo();
                            datos[i][2]=peli.getTema();
                            datos[i][3]=peli.getDuracion();
                            datos[i][4]=peli.getPrecio();
                            i++;
                        }
                        //Cramosscroll la tabla pasandoles el array de datos y de campos
                        tabla = new JTable(datos,campos);
                        //Volcamos la tabla en el ScrollPane
                        scroll = new JScrollPane(tabla);
                        //Posicionamos el ScrollPane
                        
                        scroll.setBounds(10,60,580,350);
                        //Añadimos el panel JScrollPane al Panel
                        miPanel.add(scroll);

                 base.close();
                
               
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



