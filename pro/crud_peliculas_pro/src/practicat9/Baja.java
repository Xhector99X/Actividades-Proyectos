package practicat9;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.db4o.*;

 public class Baja extends JFrame implements ActionListener{
        JPanel miPanel;   
        JLabel tituloT;
        JButton volverB;
        JButton anadirB;                                                      
        JLabel idEmpleadoT;
        JLabel tituloPeliT;
        JLabel temaT;
        JLabel duracionT;
        JLabel precioT;      
        JTextField idEmpleadoTF;
        JTextField tituloPeliTF;
        JTextField temaTF;
        JTextField duracionTF;
        JTextField precioTF;
        
        JButton consultaB;
        JButton bajaB;
        
        
        
            public Baja(){
                this.setResizable(false);
                this.setTitle("Baja Pelicula");
                this.setSize(600,500);
                this.setDefaultCloseOperation(EXIT_ON_CLOSE);
                this.setLocationRelativeTo(null);
                
                miPanel = new JPanel();
                miPanel.setLayout(null);
                
                tituloT = new JLabel("Baja Pelicula");
                tituloT.setBounds(250,10,200,30);
                miPanel.add(tituloT);
                
                idEmpleadoT = new JLabel("ID Pelicula");
                idEmpleadoT.setBounds(30,70,100,30);
                miPanel.add(idEmpleadoT);
                
                tituloPeliT = new JLabel("Titulo");
                tituloPeliT.setBounds(30,120,100,30);
                miPanel.add(tituloPeliT);
                
                temaT = new JLabel("Tema");
                temaT.setBounds(30,170,100,30);
                miPanel.add(temaT);
                
                duracionT = new JLabel("Duración");
                duracionT.setBounds(30,220,100,30);
                miPanel.add(duracionT);
                
                precioT = new JLabel("Precio");
                precioT.setBounds(30,270,100,30);
                miPanel.add(precioT);
                
                
                idEmpleadoTF = new JTextField();
                idEmpleadoTF.setBounds(150,70,100,30);
                miPanel.add(idEmpleadoTF);
                
                tituloPeliTF = new JTextField();
                tituloPeliTF.setBounds(150,120,100,30);
                tituloPeliTF.setEditable(false);
                miPanel.add(tituloPeliTF);
                
                temaTF = new JTextField();
                temaTF.setBounds(150,170,100,30);
                temaTF.setEditable(false);
                miPanel.add(temaTF);
                
                duracionTF = new JTextField();
                duracionTF.setBounds(150,220,100,30);
                duracionTF.setEditable(false);
                miPanel.add(duracionTF);
                
                precioTF = new JTextField();
                precioTF.setBounds(150,270,100,30);
                precioTF.setEditable(false);
                miPanel.add(precioTF);
                
                consultaB = new JButton("Consulta");
                consultaB.setBounds(300,70,100,30);
                miPanel.add(consultaB);
                
                bajaB = new JButton("Baja");
                bajaB.setBounds(300,120,100,30);
                miPanel.add(bajaB);
                
                
               
                // x,y,ancho,alto
                volverB = new JButton("Volver");
                volverB.setBounds(450,420,100,30);
                miPanel.add(volverB);
                
   
               
                volverB.addActionListener(this);
                consultaB.addActionListener(this);
                bajaB.addActionListener(this);
                
                
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
                
                 if(e.getSource()==bajaB){
                   //Codigo al pulsar botón de añadir
                   //INSERTAR ID PARA BORRAR PELICULAS
                   //Borrar
                  ObjectContainer base = Db4oEmbedded.openFile("peliculas.db4o");
                  int id=Integer.parseInt(idEmpleadoTF.getText());
                  Pelicula peliculaBorrar = new Pelicula(id, null,null,0,0);
                  ObjectSet registroBorrado = base.queryByExample(peliculaBorrar);        
                  try{
                  Pelicula miEmpleado = (Pelicula)registroBorrado.next();
                  base.delete(miEmpleado);
                 }catch(Exception ex){ 
                  System.out.println("El objeto no existe!!");
                 }
                  base.close();
                  /*
                   //Borrar
        //Alumno AlumnoBorrar = new Alumno(1, null,null,0,null);
        //ObjectSet registroBorrado = base.queryByExample(AlumnoBorrar);        
        //try{
        //Alumno miAlumno = (Alumno)registroBorrado.next();
        //base.delete(miAlumno);
        //}catch(Exception e){
        //    System.out.println("El objeto no existe!!");
        //}
                  */
                        
                
                    
                }
                 
                 if(e.getSource()==consultaB){
                   //Codigo al pulsar botón de añadir
                   //consulta PELICULAS
                   int id=Integer.parseInt(idEmpleadoTF.getText());
                   ObjectContainer base = Db4oEmbedded.openFile("peliculas.db4o");
                Pelicula empleadoCondicion = new Pelicula(id, null,null,0,0);
        ObjectSet resultado = base.queryByExample(empleadoCondicion);
        
        if(resultado.hasNext()){
            Pelicula peli = (Pelicula)resultado.next();
            tituloPeliTF.setText(peli.getTitulo());
            temaTF.setText(peli.getTema());
            duracionTF.setText(Integer.toString(peli.getDuracion()));
            precioTF.setText((Double.toString( peli.getPrecio())));
            
            
        }else{
              tituloPeliTF.setText("No existe");
              temaTF.setText("No existe");
              duracionTF.setText("No existe");
              precioTF.setText("No existe");
        
        }base.close();
                        
                
                    
                }
                 
        }
        }


