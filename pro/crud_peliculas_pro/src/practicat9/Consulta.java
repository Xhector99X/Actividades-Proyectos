package practicat9;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.sql.*;
import com.db4o.*;
import com.db4o.query.Predicate;

 public class Consulta extends JFrame implements ActionListener{
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
        
        
        
            public Consulta(){
                this.setResizable(false);
                this.setTitle("Consulta Pelicula");
                this.setSize(600,500);
                this.setDefaultCloseOperation(EXIT_ON_CLOSE);
                this.setLocationRelativeTo(null);
                
                miPanel = new JPanel();
                miPanel.setLayout(null);
                
                tituloT = new JLabel("Consulta Pelicula");
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
                
               
                // x,y,ancho,alto
                volverB = new JButton("Volver");
                volverB.setBounds(450,420,100,30);
                miPanel.add(volverB);
                
   
                consultaB.addActionListener(this);
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
                
                if(e.getSource()==consultaB){
                   //Codigo al pulsar botón de consultar
                   
                   int id=Integer.parseInt(idEmpleadoTF.getText());
                   
                   
                   
                   ObjectContainer base = Db4oEmbedded.openFile("peliculas.db4o");
                  
                   //Listar objetos de la base de datos       
        
                   //Listar objetos de la base de datos       
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
        
        }
        
        base.close();
                   
        }
                
                
                
        
        
                }
                
                        
                
                    
                }
        

 