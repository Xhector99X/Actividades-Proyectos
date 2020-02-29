package ppracticat4ad;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.*;
import org.neodatis.odb.*;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class Consulta extends JFrame implements ActionListener {

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

    JLabel miMatricula;
    JTextField miCampoMatricula;

    JLabel miMarca;
    JTextField miCampoMarca;

    JLabel miModelo;
    JTextField miCampoModelo;

    JLabel miPrecio;
    JTextField miCampoPrecio;

    JButton consultaB;
    JButton actualizaB;

    ArrayList<Vehiculo> vector = new ArrayList<>();
    Vehiculo miVehiculo;

    public Consulta() {
        this.setResizable(false);
        this.setTitle("Consulta Vehiculo");
        this.setSize(600, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        miPanel = new JPanel();
        miPanel.setLayout(null);

        tituloT = new JLabel("Consulta Vehiculo");
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
        miCampoMarca.setEditable(false);
        miPanel.add(miCampoMarca);

        miCampoModelo = new JTextField();
        miCampoModelo.setBounds(150, 170, 100, 30);
        miCampoModelo.setEditable(false);
        miPanel.add(miCampoModelo);

        miCampoPrecio = new JTextField();
        miCampoPrecio.setBounds(150, 220, 100, 30);
        miCampoPrecio.setEditable(false);
        miPanel.add(miCampoPrecio);

        consultaB = new JButton("Consulta");
        consultaB.setBounds(300, 70, 100, 30);
        miPanel.add(consultaB);

        // x,y,ancho,alto
        volverB = new JButton("Volver");
        volverB.setBounds(450, 420, 100, 30);
        miPanel.add(volverB);

        consultaB.addActionListener(this);
        volverB.addActionListener(this);

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

        if (e.getSource() == consultaB) {
            //Codigo al pulsar botón de consultar

            ODB conexion = ODBFactory.open("vehiculos.neo");// Abrir BD

            IQuery quer = new CriteriaQuery(Vehiculo.class, Where.like("matricula", miCampoMatricula.getText()));

            Objects<Vehiculo> objects = conexion.getObjects(quer);

            Vehiculo lista = null;

            while (objects.hasNext()) {
                lista = objects.next();
                miCampoMatricula.setText(lista.getMatricula());
                miCampoMarca.setText(lista.getMarca());
                miCampoModelo.setText(lista.getModelo());
                miCampoPrecio.setText((Double.toString( lista.getPrecio())));
                System.out.println(lista);
            }

            conexion.close();

        }

    }

}
