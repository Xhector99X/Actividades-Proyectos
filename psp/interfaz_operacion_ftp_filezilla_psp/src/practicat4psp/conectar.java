package practicat4psp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.commons.net.ftp.*;

import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class conectar extends JFrame implements ActionListener {

    FTPClient cliente;
    String servFTP = "localhost";

    JLabel tituloT;
    JLabel miCampoResultado;
    JPanel miPanel;
    JButton volverB;
    JButton validarB;

    JLabel miUsuario;
    JTextField miCampoUsuario;

    JLabel miContrase;
    JTextField miCampoConstrase;

    public conectar() {
        this.setResizable(false);
        this.setTitle("Aplicación FTP");
        this.setSize(600, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        miPanel = new JPanel();
        miPanel.setLayout(null);

        tituloT = new JLabel("Conectar al servidor");
        tituloT.setBounds(20, 5, 200, 30);
        miPanel.add(tituloT);

        miCampoResultado = new JLabel("");
        miCampoResultado.setBounds(300, 120, 200, 30);
        miPanel.add(miCampoResultado);

        miUsuario = new JLabel("Usuario");
        miUsuario.setBounds(30, 70, 100, 30);
        miPanel.add(miUsuario);

        miContrase = new JLabel("Constraseña");
        miContrase.setBounds(30, 120, 100, 30);
        miPanel.add(miContrase);

        validarB = new JButton("Conectar");
        validarB.setBounds(300, 70, 100, 30);
        miPanel.add(validarB);

        volverB = new JButton("Volver");
        volverB.setBounds(450, 420, 100, 30);
        miPanel.add(volverB);

        //Campos de texto
        miCampoUsuario = new JTextField();
        miCampoUsuario.setBounds(150, 70, 100, 30);
        miPanel.add(miCampoUsuario);

        miCampoConstrase = new JTextField();
        miCampoConstrase.setBounds(150, 120, 100, 30);
        miPanel.add(miCampoConstrase);

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

        //He tenido que recurrir a try-catch que me ofrecía NetBeans 
        if (e.getSource() == validarB) {

            String servFTP = "localhost";

            cliente = new FTPClient();
            try {
                cliente.connect(servFTP);

                boolean login = false;
                login = cliente.login(miCampoUsuario.getText(), miCampoConstrase.getText());
                if (login) {
                    miCampoResultado.setText("Login Correcto");
                    System.out.println("Login correcto...");
                    this.cliente = cliente;
                } else {
                    miCampoResultado.setText("Login Incorrecto");
                    System.out.println("Login Incorrecto...");
                    cliente.disconnect();
                }
            } catch (IOException ex) {
                Logger.getLogger(conectar.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    //Codigo copiado de la actividad 2 T4 Psp 
    /*    if(e.getSource() == validarB){
        
            FTPClient cliente;
     String servFTP = "localhost";
     
                 Scanner tec = new Scanner(System.in);

     //Conectar primero por teclado y luego por las cajas de texto 
          
     
             cliente = new FTPClient();
                    cliente.connect(servFTP);
                    System.out.println("Escribe un usuario: ");
                    String user = tec.nextLine();

                    System.out.println("Escribe una contraseña: ");
                    String pass = tec.nextLine();

                    boolean login = cliente.login(user, pass);
                    if (login) {
                        System.out.println("Login correcto...");
                    } else {
                        System.out.println("Login Incorrecto...");
                        cliente.disconnect();
                        System.exit(1);
                    }
       
                 

        }

     */
}


