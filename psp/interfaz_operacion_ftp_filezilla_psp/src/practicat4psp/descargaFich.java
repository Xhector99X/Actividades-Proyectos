package practicat4psp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import static java.lang.System.out;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class descargaFich extends JFrame implements ActionListener {

    FTPClient cliente;
    JLabel tituloT;
    JPanel miPanel;
    JButton volverB;
    JLabel fich;
    JButton validarB;
    JComboBox<String> miCombo;
    
    JLabel miCampoResultado;


    public descargaFich(FTPClient cliente) {
        this.cliente = cliente;
        this.setResizable(false);
        this.setTitle("Aplicación FTP");
        this.setSize(600, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        miPanel = new JPanel();
        miPanel.setLayout(null);

        tituloT = new JLabel("Descargar fichero");
        tituloT.setBounds(20, 5, 200, 30);
        miPanel.add(tituloT);

        fich = new JLabel("Seleccionar el nombre del fichero");
        fich.setBounds(20, 70, 200, 30);
        miPanel.add(fich);

        validarB = new JButton("Descargar");
        validarB.setBounds(350, 70, 100, 30);
        miPanel.add(validarB);
        
        miCampoResultado = new JLabel("");
        miCampoResultado.setBounds(300, 120, 200, 30);
        miPanel.add(miCampoResultado);
        

        volverB = new JButton("Volver");
        volverB.setBounds(450, 420, 100, 30);
        miPanel.add(volverB);

        miCombo = new JComboBox();
        
        miCombo.setBounds(230, 70, 100, 30);
        
           FTPFile[] files;
        try {
            files = cliente.listFiles();
            for (FTPFile ftpFile : files) {
                // Check the file type and print result
                miCombo.addItem(ftpFile.getName());
            }
        } catch (IOException ex) {
        }
        
        miPanel.add(miCombo);

        //Botones a la escucha
        volverB.addActionListener(this);
        validarB.addActionListener(this);

        this.add(miPanel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == volverB) {
            //Codigo al pulsar botón de baja
            Menu miMenu = new Menu(cliente);
            miMenu.setVisible(true);
            this.dispose();
        }

        if (e.getSource() == validarB) {
            /*   FTPClient cliente = null;
        String servFTP = "localhost";
        
        Scanner tec = new Scanner(System.in);
        
            boolean login = false;
              String usuario = "usuario1";
                    String contraseña = "1234";
                    
                    System.err.println("Nombre del fichero que quieres descargar: ");

                    String ficheroDescargado = tec.nextLine();

            try {
                login = cliente.login(usuario, contraseña);
            } catch (IOException ex) {
                Logger.getLogger(descargaFich.class.getName()).log(Level.SEVERE, null, ex);
            }
                    if (login) {
                        System.out.println("Login correcto");
                    //descargar fichero
                        String direc = "/pdfs";
            try {
                cliente.changeWorkingDirectory(ficheroDescargado);
            } catch (IOException ex) {
                Logger.getLogger(descargaFich.class.getName()).log(Level.SEVERE, null, ex);
            }
                    //stream de salida para recibir el fichero descargado
                        BufferedOutputStream out = null;
            try{
                out = new BufferedOutputStream(
                        new FileOutputStream("C:\\copia usb\\prueba2.txt"));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(descargaFich.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                if (cliente.retrieveFile(ficheroDescargado, out)) {
                    System.out.println("Recuperado correctamente... ");
                } else {
                    System.out.println("No se ha podido descargar... ");
                }
            } catch (IOException ex) {
                Logger.getLogger(descargaFich.class.getName()).log(Level.SEVERE, null, ex);
            }
                    } */

            //Código original actividad 3
            
                    
         // FTPClient cliente = null;
         //String servFTP = "localhost";
         
                     

        
       
        
            boolean login = false;
                    
              String usuario = "usuario1";
                    String contraseña = "1234";
                    

                    

            try {
                login = cliente.login(usuario, contraseña);
            } catch (IOException ex) {
                Logger.getLogger(descargaFich.class.getName()).log(Level.SEVERE, null, ex);
            }
                    if (login) {
                        System.out.println("Login correcto");
                    //descargar fichero
            try {
                cliente.changeWorkingDirectory((String) miCombo.getSelectedItem());
            } catch (IOException ex) {
                Logger.getLogger(descargaFich.class.getName()).log(Level.SEVERE, null, ex);
            }
                    //stream de salida para recibir el fichero descargado
                        //BufferedOutputStream out;
            try {
               BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("C:\\copia usb\\"+miCombo.getSelectedItem()));
         //E:\2ºDAM
         //C:\\copia usb\\
            
                if (cliente.retrieveFile((String) miCombo.getSelectedItem(), out)) {
                    System.out.println("Recuperado correctamente... ");
                    miCampoResultado.setText("Recuperado correctamente...");
                } else {
                    System.out.println("No se ha podido descargar... ");
                    miCampoResultado.setText("No se ha podido descargar...");

                }
            } catch (IOException ex) {
                Logger.getLogger(descargaFich.class.getName()).log(Level.SEVERE, null, ex);
            }
                    }
             
        }

    }

}
