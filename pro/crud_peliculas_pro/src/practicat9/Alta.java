package practicat9;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.db4o.*;


    public class Alta extends JFrame implements ActionListener{
        
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
        
        
        
            public Alta(){
                
                
                this.setResizable(false);
                this.setTitle("Alta Pelicula");
                this.setSize(600,500);
                this.setDefaultCloseOperation(EXIT_ON_CLOSE);
                this.setLocationRelativeTo(null);
                
                miPanel = new JPanel();
                miPanel.setLayout(null);
                
                tituloT = new JLabel("Alta de pelicula");
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
                miPanel.add(tituloPeliTF);
                
                temaTF = new JTextField();
                temaTF.setBounds(150,170,100,30);
                miPanel.add(temaTF);
                
                duracionTF = new JTextField();
                duracionTF.setBounds(150,220,100,30);
                miPanel.add(duracionTF);
                
                precioTF = new JTextField();
                precioTF.setBounds(150,270,100,30);
                miPanel.add(precioTF);
                
                anadirB = new JButton("Añadir");
                anadirB.setBounds(300,70,100,30);
                miPanel.add(anadirB);
                
               
                // x,y,ancho,alto
                volverB = new JButton("Volver");
                volverB.setBounds(450,420,100,30);
                miPanel.add(volverB);
                
   
               
                volverB.addActionListener(this);
                anadirB.addActionListener(this);
                
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
                
                 if(e.getSource()==anadirB){
                ObjectContainer base = Db4oEmbedded.openFile("peliculas.db4o");                    
                   //Codigo al pulsar botón de añadir
                   //PARA AÑADIR PELICULAS
                   int id=Integer.parseInt(idEmpleadoTF.getText());
                   String titulo=(tituloPeliTF.getText());
                   String tema=(temaTF.getText());
                   int duracion=Integer.parseInt(duracionTF.getText());
                   double precio=Double.parseDouble(precioTF.getText());
                   
                   Pelicula miPelicula = new Pelicula(id,titulo,tema,duracion,precio);
                   base.store(miPelicula);
                        
                
                    base.close();
                }
        }
            
    }

