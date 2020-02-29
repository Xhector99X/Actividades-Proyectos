package practicat4psp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import org.apache.commons.net.ftp.FTPClient;

public class cambiaDir extends JFrame implements ActionListener {
    FTPClient cliente;
    JLabel tituloT;
    JPanel miPanel;
    JButton volverB;
    JButton validarB;
    JLabel miCampoResultado;


    JLabel miDir;
    JTextField miCampoDir;

    public cambiaDir(FTPClient cliente) {
        this.cliente = cliente;
        this.setResizable(false);
        this.setTitle("Aplicación FTP");
        this.setSize(600, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        miPanel = new JPanel();
        miPanel.setLayout(null);

        tituloT = new JLabel("Cambiar de directorio");
        tituloT.setBounds(20, 5, 200, 30);
        miPanel.add(tituloT);

        miDir = new JLabel("Cambio de directorio");
        miDir.setBounds(20, 70, 120, 30);
        miPanel.add(miDir);

        validarB = new JButton("Validar");
        validarB.setBounds(300, 70, 100, 30);
        miPanel.add(validarB);
        
         miCampoResultado = new JLabel("");
        miCampoResultado.setBounds(300, 120, 200, 30);
        miPanel.add(miCampoResultado);

        volverB = new JButton("Volver");
        volverB.setBounds(450, 420, 100, 30);
        miPanel.add(volverB);

        //Campos de texto
        miCampoDir = new JTextField();
        miCampoDir.setBounds(150, 70, 100, 30);
        miPanel.add(miCampoDir);

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
            

            try {
                System.out.println("Directorio actual: " + cliente.printWorkingDirectory());
               // Scanner tec = new Scanner(System.in);
                
               //System.out.println("Nombre del nuevo directorio: ");
               // String nuevoDir = tec.nextLine();
                               
                    cliente.changeWorkingDirectory(miCampoDir.getText());
                    
                    miCampoResultado.setText("Directorio actual: "+cliente.printWorkingDirectory());

                    
                    System.out.println("Directorio actual: " + cliente.printWorkingDirectory());
                               
            } catch (IOException ex) {
                Logger.getLogger(cambiaDir.class.getName()).log(Level.SEVERE, null, ex);
            }

            
        }

    }
}
