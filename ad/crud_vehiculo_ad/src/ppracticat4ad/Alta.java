package ppracticat4ad;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.*;
import org.neodatis.odb.*;

public class Alta extends JFrame implements ActionListener {

    JPanel miPanel;
    JLabel tituloT;
    JButton volverB;
    JButton anadirB;

    JLabel miMatricula;
    JTextField miCampoMatricula;

    JLabel miMarca;
    JTextField miCampoMarca;

    JLabel miModelo;
    JTextField miCampoModelo;

    JLabel miPrecio;
    JTextField miCampoPrecio;
    
     ArrayList<Vehiculo> vector = new ArrayList<>();
    Vehiculo miVehiculo;

    public Alta() {

        this.setResizable(false);
        this.setTitle("Alta Vehiculo");
        this.setSize(600, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        miPanel = new JPanel();
        miPanel.setLayout(null);

        tituloT = new JLabel("Alta de Vehiculo");
        tituloT.setBounds(250, 10, 200, 30);
        miPanel.add(tituloT);

        miMatricula = new JLabel("Matricula");
        miMatricula.setBounds(30, 70, 100, 30);
        miPanel.add(miMatricula);

        miMarca = new JLabel("Marca");
        miMarca.setBounds(30, 120, 100, 30);
        miPanel.add(miMarca);

        miModelo = new JLabel("Modelo");
        miModelo.setBounds(30, 170, 100, 30);
        miPanel.add(miModelo);

        miPrecio = new JLabel("Precio");
        miPrecio.setBounds(30, 220, 100, 30);
        miPanel.add(miPrecio);

        miCampoMatricula = new JTextField();
        miCampoMatricula.setBounds(150, 70, 100, 30);
        miPanel.add(miCampoMatricula);

        miCampoMarca = new JTextField();
        miCampoMarca.setBounds(150, 120, 100, 30);
        miPanel.add(miCampoMarca);

        miCampoModelo = new JTextField();
        miCampoModelo.setBounds(150, 170, 100, 30);
        miPanel.add(miCampoModelo);

        miCampoPrecio = new JTextField();
        miCampoPrecio.setBounds(150, 220, 100, 30);
        miPanel.add(miCampoPrecio);

        anadirB = new JButton("Añadir");
        anadirB.setBounds(300, 70, 100, 30);
        miPanel.add(anadirB);

        // x,y,ancho,alto
        volverB = new JButton("Volver");
        volverB.setBounds(450, 420, 100, 30);
        miPanel.add(volverB);

        volverB.addActionListener(this);
        anadirB.addActionListener(this);

        this.add(miPanel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == volverB) {
            //Codigo al pulsar botón de baja
            Menu miMenu = new Menu();
            miMenu.setVisible(true);
            this.dispose();
        }

        if (e.getSource() == anadirB) {
            
             ODB conexion = ODBFactory.open("vehiculos.neo");// Abrir BD

            miVehiculo = new Vehiculo(miCampoMatricula.getText(), miCampoMarca.getText(), miCampoModelo.getText(), Integer.valueOf(miCampoPrecio.getText()));

            vector.add(miVehiculo);
            miCampoMatricula.setText("");
            miCampoMarca.setText("");
            miCampoModelo.setText("");
            miCampoPrecio.setText("");

            conexion.store(miVehiculo);

            //Cerra la conexión es un paso clave para que la inserción se realice conrrectamente
           conexion.close();


        }
        
    }

}
