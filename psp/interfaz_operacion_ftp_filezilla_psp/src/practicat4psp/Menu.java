package practicat4psp;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import org.apache.commons.net.ftp.FTPClient;

public class Menu extends JFrame implements ActionListener {
    FTPClient cliente;
    JLabel tituloT;
    JPanel miPanel;
    JButton conectaB;
    JButton cambiaDirB;
    JButton mostrarB;
    JButton cambiaNombreFichB;
    JButton eliminiaFichB;

    JButton descargaFichB;
    JButton subirFichB;

    JButton salirB;

    public Menu(FTPClient cliente) {
        this.cliente = cliente;
        this.setResizable(false);
        this.setTitle("Aplicación FTP");
        this.setSize(220, 460);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        miPanel = new JPanel();
        miPanel.setLayout(null);

        tituloT = new JLabel("Conexón FTP Héctor 2ºDAM");
        tituloT.setBounds(20, 5, 200, 30);
        miPanel.add(tituloT);

        // x,y,ancho,alto
        conectaB = new JButton("Conectar al servidor");
        conectaB.setBounds(8, 30, 200, 30);
        miPanel.add(conectaB);

        cambiaDirB = new JButton("Cambiar de directorio");
        cambiaDirB.setBounds(8, 80, 200, 30);
        miPanel.add(cambiaDirB);

        mostrarB = new JButton("Mostrar tabla");
        mostrarB.setBounds(8, 130, 200, 30);
        miPanel.add(mostrarB);

        cambiaNombreFichB = new JButton("Cambiar nombre de fichero");
        cambiaNombreFichB.setBounds(8, 180, 200, 30);
        miPanel.add(cambiaNombreFichB);

        eliminiaFichB = new JButton("Eliminar fichero");
        eliminiaFichB.setBounds(8, 230, 200, 30);
        miPanel.add(eliminiaFichB);

        descargaFichB = new JButton("Descargar fichero");
        descargaFichB.setBounds(8, 280, 200, 30);
        miPanel.add(descargaFichB);

        subirFichB = new JButton("Subir fichero");
        subirFichB.setBounds(8, 330, 200, 30);
        miPanel.add(subirFichB);

        salirB = new JButton("Salir");
        salirB.setBounds(8, 380, 200, 30);
        miPanel.add(salirB);

        //Botones a la escucha
        
        conectaB.addActionListener(this);
        cambiaDirB.addActionListener(this);
        mostrarB.addActionListener(this);
        cambiaNombreFichB.addActionListener(this);
        eliminiaFichB.addActionListener(this);
        descargaFichB.addActionListener(this);
        subirFichB.addActionListener(this);
        salirB.addActionListener(this);
        
        this.add(miPanel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==salirB){
                   //Codigo al pulsar botón de Salir
                   System.exit(0);
                }
        
        if(e.getSource()==conectaB){
                   //Codigo al pulsar botón de alta
                   conectar miConectar = new conectar();
                   miConectar.setVisible(true);
                   this.dispose();
                }
        
        if(e.getSource()==cambiaDirB){
                   //Codigo al pulsar botón de alta
                   cambiaDir miCambiaDir = new cambiaDir(cliente);
                   miCambiaDir.setVisible(true);
                   this.dispose();
                }
        
        if(e.getSource()==mostrarB){
                   //Codigo al pulsar botón de alta
                   mostrar miMostrar = new mostrar(cliente);
                   miMostrar.setVisible(true);
                   this.dispose();
 
        }
        
        if(e.getSource()==cambiaNombreFichB){
                   //Codigo al pulsar botón de alta
                   cambiaNombreFich miCambiaNombreFich = new cambiaNombreFich(cliente);
                   miCambiaNombreFich.setVisible(true);
                   this.dispose();
                }
        
          if(e.getSource()==eliminiaFichB){
                   //Codigo al pulsar botón de alta
                   eliminaFich miEliminaFich = new eliminaFich(cliente);
                   miEliminaFich.setVisible(true);
                   this.dispose();
 
        }
          
          if(e.getSource()==descargaFichB){
                   //Codigo al pulsar botón de alta
                   descargaFich miDescargaFich = new descargaFich(cliente);
                   miDescargaFich.setVisible(true);
                   this.dispose();
 
        }
          
          if(e.getSource()==subirFichB){
                   //Codigo al pulsar botón de alta
                   subeFich miSubeFich = new subeFich(cliente);
                   miSubeFich.setVisible(true);
                   this.dispose();
 
        }
          
          
          
        
    }
    
}
