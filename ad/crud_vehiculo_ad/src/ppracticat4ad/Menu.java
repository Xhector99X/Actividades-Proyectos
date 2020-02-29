package ppracticat4ad;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.*;
import org.neodatis.odb.*;

public class Menu extends JFrame implements ActionListener{
        JLabel tituloT;
        JPanel miPanel;       
        JButton altaB;
        JButton bajaB;
        JButton consultaB;
        JButton actualizacionB;
        JButton listadoB;
        JButton salirB;
        
        
        
            public Menu(){
                this.setResizable(false);
                this.setTitle("Aplicación Vehículos");
                this.setSize(220,300);
                this.setDefaultCloseOperation(EXIT_ON_CLOSE);
                this.setLocationRelativeTo(null);
                
                miPanel = new JPanel();
                miPanel.setLayout(null);
                
                tituloT = new JLabel("Vehículos Héctor 2ºDAM");
                tituloT.setBounds(35,5,150,30);
                miPanel.add(tituloT);
                
               
                // x,y,ancho,alto
                altaB = new JButton("Alta Vehículo");
                altaB.setBounds(25,30,160,30);
                miPanel.add(altaB);
                
                
                bajaB = new JButton("Baja Vehículo");
                bajaB.setBounds(25,70,160,30);
                miPanel.add(bajaB);
                
                
                consultaB = new JButton("Consulta Vehículo");
                consultaB.setBounds(25,110,160,30);
                miPanel.add(consultaB);
                
                
                
                
                actualizacionB = new JButton("actualizacion Vehículo");
                actualizacionB.setBounds(25,150,160,30);
                miPanel.add(actualizacionB);
                
                
                listadoB = new JButton("Listado Vehículo");
                listadoB.setBounds(25,190,160,30);
                miPanel.add(listadoB);
                
                
                salirB = new JButton("Salir");
                salirB.setBounds(25,230,160,30);
                miPanel.add(salirB);
                
                
                
                
                
                
                altaB.addActionListener(this);
                bajaB.addActionListener(this);
                consultaB.addActionListener(this);
                actualizacionB.addActionListener(this);
                listadoB.addActionListener(this);
                salirB.addActionListener(this);
                
                
                this.add(miPanel);
                
            }
            
            @Override
            public void actionPerformed(ActionEvent e){
                if(e.getSource()==altaB){
                   //Codigo al pulsar botón de alta
                   Alta miAlta = new Alta();
                   miAlta.setVisible(true);
                   this.dispose();
                }
                
               if(e.getSource()==bajaB){
                   //Codigo al pulsar botón de baja
                   Baja miBaja = new Baja();
                   miBaja.setVisible(true);
                   this.dispose();
                }
                
                if(e.getSource()==consultaB){
                   //Codigo al pulsar botón de Consulta
                   Consulta miConsulta = new Consulta();
                   miConsulta.setVisible(true);
                   this.dispose();
                }
                
                if(e.getSource()==actualizacionB){
                   //Codigo al pulsar botón de Actualizacion
                   Actualizacion miActualizacion = new Actualizacion();
                   miActualizacion.setVisible(true);
                   this.dispose();
                }
                
                 if(e.getSource()==listadoB){
                   //Codigo al pulsar botón de Listado
                   Listado miListado = new Listado();
                   miListado.setVisible(true);
                   this.dispose();
                }
                 
                 
                if(e.getSource()==salirB){
                   //Codigo al pulsar botón de Salir
                   System.exit(0);
                }
                
                    
                }
        }
