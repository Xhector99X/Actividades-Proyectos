package practicat4psp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.apache.commons.net.ftp.*;

public class subeFich extends JFrame implements ActionListener {

    FTPClient cliente;

    JLabel tituloT;
    JPanel miPanel;
    JButton volverB;

    JButton validarB;

    JLabel miDir;
    JTextField miCampoDir;

    JLabel miCampoResultado;

    public subeFich(FTPClient cliente) {
        this.cliente = cliente;

        this.setResizable(false);
        this.setTitle("Aplicación FTP");
        this.setSize(600, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        miPanel = new JPanel();
        miPanel.setLayout(null);

        tituloT = new JLabel("Subir fichero");
        tituloT.setBounds(20, 5, 200, 30);
        miPanel.add(tituloT);

        miDir = new JLabel("Ruta del fichero");
        miDir.setBounds(20, 70, 120, 30);
        miPanel.add(miDir);

        validarB = new JButton("Subir");
        validarB.setBounds(360, 70, 100, 30);
        miPanel.add(validarB);

        miCampoResultado = new JLabel("");
        miCampoResultado.setBounds(300, 120, 200, 30);
        miPanel.add(miCampoResultado);

        volverB = new JButton("Volver");
        volverB.setBounds(450, 420, 100, 30);
        miPanel.add(volverB);

        //Campos de texto
        miCampoDir = new JTextField();
        miCampoDir.setBounds(120, 70, 220, 30);
        miPanel.add(miCampoDir);

        //Botones a la escucha
        volverB.addActionListener(this);
        validarB.addActionListener(this);

        this.add(miPanel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == volverB) {
            //Codigo al pulsar botón de volver
            Menu miMenu = new Menu(cliente);
            miMenu.setVisible(true);
            this.dispose();
        }

        if (e.getSource() == validarB) {


            //NO FUNCIONA PORQUE HE INICIALIZADO VARIAS VARIABLES A = NULL
            /*   
           Scanner tec = new Scanner(System.in);

            FTPClient cliente=null;
            String servFTP = "localhost";
            
            System.out.println("Introduce el nombre del archivo que vas a subir");

            String ficheroSubido = tec.nextLine();

            String rutaArchivo = "C:\\Users\\hecto\\Desktop\\prueba.txt";

            BufferedInputStream in=null;
            try {
                in = new BufferedInputStream(new FileInputStream(rutaArchivo));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(subeFich.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                if (cliente.storeFile(ficheroSubido, in)) {
                    System.out.println("Subido correctamente... ");
                } else {
                    System.out.println("No se ha podido subir el fichero.");
                }
            } catch (IOException ex) {
                Logger.getLogger(subeFich.class.getName()).log(Level.SEVERE, null, ex);
            }

            
             */
            //Codigo original del ej 3
            String ruta = miCampoDir.getText();

            //CAMBIAR LA RUTA EN FUNCIÓN DEL ORDENADOR EN EL QUE SE EJECUTE
            
            // String rutaArchivo = "C:\\Users\\hecto\\Desktop\\prueba.txt";
            // String rutaArchivo = "C:\\Users\\dam2\\Desktop\\prueba.txt";
            try {
                BufferedInputStream in = new BufferedInputStream(new FileInputStream(ruta));
              
                
               int index = ruta.lastIndexOf("\\");
                
               String nombre = ruta.substring(index+2);
                
               
                
                if (cliente.storeFile(nombre, in)) {
                    System.out.println("Subido correctamente... ");
                    miCampoResultado.setText("Archivo subido correctamente");
                } else {
                    System.out.println("No se ha podido subir el fichero.");
                    miCampoResultado.setText("No se ha podido subir el fichero.");

                }
            } catch (IOException ex) {
                Logger.getLogger(subeFich.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
