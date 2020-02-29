package practicat4psp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class mostrar extends JFrame implements ActionListener {
    FTPClient cliente;

    JLabel tituloT;
    JPanel miPanel;
    JButton volverB;
    JLabel miCampoResultado;
    JTable tabla;
    JScrollPane scroll;

    public mostrar(FTPClient cliente) {
        this.cliente = cliente;
        this.setResizable(false);
        this.setTitle("Aplicación FTP");
        this.setSize(600, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        miPanel = new JPanel();
        miPanel.setLayout(null);

        tituloT = new JLabel("Mostrar tabla");
        tituloT.setBounds(20, 5, 200, 30);
        miPanel.add(tituloT);

        miCampoResultado = new JLabel("");
        miCampoResultado.setBounds(250, 50, 200, 30);
        miPanel.add(miCampoResultado);

        volverB = new JButton("Volver");
        volverB.setBounds(450, 420, 100, 30);
        miPanel.add(volverB);

        FTPFile[] files;
        
         //Array de Cabecera para la tabla
                String[] campos = new String[]{"Contenido","Tamaño","Tipo"};
                
                //Array de Datos para la tabla
                Object[][] datos ;
                
             /*    files = cliente.listFiles();
                    datos = new Object[files.length][3];
                    int cont = 0;
                    for(int i = 0; i<files.length; i++){
                    datos[i][0]=files[i].getName();
                    if(files[i].getType()==0)
                        if(files[i].getType()==1)
                            if(files[i].getType()==2)
                              
                    datos[i][2]=files[i].getType();
                    cont++;}
                */
                String[] tipo = new String[]{"Fichero","Directorio","Enlace simb"};
             
                try{
                    files = cliente.listFiles();
                    datos = new Object[files.length][3];
                    int cont = 0;
                    for(int i = 0; i<files.length; i++){
                    datos[i][0]=files[i].getName();
                    datos[i][1]=files[i].getSize();
                    switch(files[i].getType()){
                        case 0:
                             datos[i][2]=tipo[0];
                             break;
                        case 1:
                            datos[i][2]=tipo[1];
                            break;
                        case 2:
                            datos[i][2]=tipo[2];
                            break;
                    }
                    
                    cont++;
                    }
                    
           
                       tabla = new JTable(datos , campos);
                    
                     tabla = new JTable(datos , campos);
                }catch(IOException e){
                    e.printStackTrace();
                    
                }
                
        
    
                                    
        
        //Cramosscroll la tabla pasandoles el array de datos y de campos
        
       
     
        //Volcamos la tabla en el ScrollPane
        scroll = new JScrollPane(tabla);
        //Posicionamos el ScrollPane

        scroll.setBounds(10, 60, 580, 350);
        //Añadimos el panel JScrollPane al Panel
        miPanel.add(scroll);

        //Botones a la escucha
        volverB.addActionListener(this);

        this.add(miPanel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == volverB) {

            Menu miMenu = new Menu(cliente);
            miMenu.setVisible(true);
            this.dispose();
        }

    }

}
