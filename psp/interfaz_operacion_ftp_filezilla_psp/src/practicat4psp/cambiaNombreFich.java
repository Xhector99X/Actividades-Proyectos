package practicat4psp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class cambiaNombreFich extends JFrame implements ActionListener {
    FTPClient cliente;
    JLabel tituloT;
    JPanel miPanel;
    JLabel fich;
    JButton volverB;
    JTextField miCampoDir;
    JButton validarB;
    JComboBox<String> miCombo;
    
    JLabel miCampoResultado;


    public cambiaNombreFich(FTPClient cliente) {
        this.cliente = cliente;
        this.setResizable(false);
        this.setTitle("Aplicación FTP");
        this.setSize(600, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        miPanel = new JPanel();
        miPanel.setLayout(null);

        tituloT = new JLabel("Cambiar nombre de fichero");
        tituloT.setBounds(20, 5, 200, 30);
        miPanel.add(tituloT);

        fich = new JLabel("Seleccionar el nombre del fichero");
        fich.setBounds(20, 70, 200, 30);
        miPanel.add(fich);
        
        validarB = new JButton("Validar");
        validarB.setBounds(480, 70, 100, 30);
        miPanel.add(validarB);
        
        miCampoResultado = new JLabel("");
        miCampoResultado.setBounds(300, 120, 200, 30);
        miPanel.add(miCampoResultado);

        volverB = new JButton("Volver");
        volverB.setBounds(450, 420, 100, 30);
        miPanel.add(volverB);

        miCampoDir = new JTextField();
        miCampoDir.setBounds(350, 70, 100, 30);
        miPanel.add(miCampoDir);

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
        
        if(e.getSource() ==validarB){
        
       

            try {
                if (cliente.rename((String) miCombo.getSelectedItem(), miCampoDir.getText())) {
                    System.out.println("Fichero renombrado... ");
                    miCampoResultado.setText("Fichero renombrado...");
                } else {
                    System.out.println("No he podido renombar el Fichero");
                    miCampoResultado.setText("No he podido renombar el Fichero");
                }
            } catch (IOException ex) {
                Logger.getLogger(cambiaNombreFich.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

    }

}
