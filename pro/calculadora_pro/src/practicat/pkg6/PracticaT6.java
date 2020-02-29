package practicat.pkg6;
import javax.swing.*;
import java.awt.Color;
//(2) Importar awt.event.*;
import java.awt.event.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
public class PracticaT6 {  
    public static void main(String[] args) {
         Formulario miFormulario = new Formulario();
        miFormulario.setVisible(true);
    }
    
}
//(3) Implementar interface ActionListener
class Formulario extends JFrame implements ActionListener{
    JPanel miCapa;  
    JTextField miCampoResultado;  
    JTextField miCampoValor1;
    JTextField miCampoValor2;
    
    JButton miBotonSalir;
    JButton miBotonSuma;
    JButton miBotonResta;
    JButton miBotonMultiplica;
    JButton miBotonDivide;
    
    
    
    
    public Formulario(){
        this.setTitle("Mi aplicación Java");
        this.setSize(500,300);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        miCapa = new JPanel();
        miCapa.setLayout(null);
        
        
        
        
        
        //Fondo 
        Color miFondo = new Color(192, 240, 10  );
        miCapa.setBackground(miFondo);
        
        
       
       //caja de texto miCampoResultado
       miCampoResultado = new JTextField();
       miCampoResultado.setBounds(20,30,450,30);
       miCapa.add(miCampoResultado);
       
      //caja de texto miCampoValor1
       miCampoValor1 = new JTextField();
       miCampoValor1.setBounds(20,80,220,30);
       miCapa.add(miCampoValor1);
       
       //caja de texto miCampoValor2
       miCampoValor2 = new JTextField();
       miCampoValor2.setBounds(250,80,220,30);
       miCapa.add(miCampoValor2);
       
       
       
       
       //botón miBotonSalir
       miBotonSalir = new JButton("Salir de la aplicación");
       miBotonSalir.setBounds(130,220,220,30);
       miCapa.add(miBotonSalir);
       
       //botón miBotonSuma
       miBotonSuma = new JButton("Suma");
       miBotonSuma.setBounds(20,140,100,30);
       miCapa.add(miBotonSuma);
       
       //botón miBotonResta
       miBotonResta = new JButton("Resta");
       miBotonResta.setBounds(140,140,100,30);
       miCapa.add(miBotonResta);
       
       //botón miBotonMultiplica
       miBotonMultiplica = new JButton("Multiplicar");
       miBotonMultiplica.setBounds(250,140,100,30);
       miCapa.add(miBotonMultiplica);
       
       //botón miBotonDivide
       miBotonDivide = new JButton("Dividir");
       miBotonDivide.setBounds(370,140,100,30);
       miCapa.add(miBotonDivide);
       
       
       
       
       
       
       
      
       
       //(1) botón a la escucha
       miBotonSalir.addActionListener(this);
       miBotonSuma.addActionListener(this);
       miBotonResta.addActionListener(this);
       miBotonMultiplica.addActionListener(this);
       miBotonDivide.addActionListener(this);
      
       
       //Añadimos JPanel al Formulario
        this.add(miCapa);
    }
    //(4) Sobreescribir el método actionPerformed
    //y parametro e recoge información del evento
    //e.getSource devuelve quien originó el evento
     @Override
       public void actionPerformed(ActionEvent e){
           //Definición de Atributos
           double Num1, Num2, Total;
           if(e.getSource()==miBotonSalir){
               System.exit(0);
            //Suma   
           }if(e.getSource()==miBotonSuma){              
               Num1=Double.parseDouble(miCampoValor1.getText());
               Num2=Double.parseDouble(miCampoValor2.getText());
               Total=Num1+Num2;
               miCampoResultado.setText(String.valueOf(Total)); 
            //Resta   
	   }if(e.getSource()==miBotonResta){  
               Num1=Double.parseDouble(miCampoValor1.getText());
               Num2=Double.parseDouble(miCampoValor2.getText());
               Total=Num1-Num2;
               miCampoResultado.setText(String.valueOf(Total));         
            //Multiplocación   
	   }if(e.getSource()==miBotonMultiplica){  
               Num1=Double.parseDouble(miCampoValor1.getText());
               Num2=Double.parseDouble(miCampoValor2.getText());
               Total=Num1*Num2;
               miCampoResultado.setText(String.valueOf(Total));     
            //División   
	   }if(e.getSource()==miBotonDivide){  
               Num1=Double.parseDouble(miCampoValor1.getText());
               Num2=Double.parseDouble(miCampoValor2.getText());
               Total=Num1/Num2;
               miCampoResultado.setText(String.valueOf(Total)); 
           }   
	   	
               
           
       }
}
    
