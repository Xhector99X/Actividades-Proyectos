package practicat4psp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
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
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class eliminaFich extends JFrame implements ActionListener {

    FTPClient cliente;

    JLabel tituloT;
    JPanel miPanel;
    JButton volverB;
    JLabel fich;
    JButton validarB;
    JComboBox<String> miCombo;
    FTPFile file[];

    JLabel miCampoResultado;

    public eliminaFich(FTPClient cliente) {
        this.cliente = cliente;

        this.setResizable(false);
        this.setTitle("Aplicación FTP");
        this.setSize(600, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        miPanel = new JPanel();
        miPanel.setLayout(null);

        tituloT = new JLabel("Eliminar fichero");
        tituloT.setBounds(20, 5, 200, 30);
        miPanel.add(tituloT);

        fich = new JLabel("Seleccionar el nombre del fichero");
        fich.setBounds(20, 70, 200, 30);
        miPanel.add(fich);

        validarB = new JButton("Eliminar");
        validarB.setBounds(350, 70, 100, 30);
        miPanel.add(validarB);

        miCampoResultado = new JLabel("");
        miCampoResultado.setBounds(300, 120, 200, 30);
        miPanel.add(miCampoResultado);

        volverB = new JButton("Volver");
        volverB.setBounds(450, 420, 100, 30);
        miPanel.add(volverB);

        miCombo = new JComboBox();

        //cliente = file.length;ç
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

            try {

                if (cliente.deleteFile((String) miCombo.getSelectedItem())) {
                    System.out.println("Fichero eliminado... ");
                    miCampoResultado.setText("Fichero eliminado...");

                } else {
                    System.out.println("No se ha podido eliminar Fichero");
                    miCampoResultado.setText("Fichero eliminado...");
                }
            } catch (IOException ex) {
                Logger.getLogger(eliminaFich.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
