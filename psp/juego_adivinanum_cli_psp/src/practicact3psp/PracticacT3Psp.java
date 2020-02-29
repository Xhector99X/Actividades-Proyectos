package practicact3psp;

import java.io.*;
import java.net.*;

public class PracticacT3Psp {

    public static void main(String[] args) {

        String Host = "localhost";
        int Puerto = 6001;
        int num = 0;

        System.out.println(" Cliente Iniciado....");

        try {

            Socket cliente = new Socket(Host, Puerto);

            DataOutputStream flujo = new DataOutputStream(cliente.getOutputStream());
            DataInputStream entrada = new DataInputStream(cliente.getInputStream());

            for (int i = 0; i < 5; i++) {

                num = (int) (Math.random() * 10);

                System.out.println("¿Puede ser el numero " + num + " ?");

                flujo.writeInt(num);

                if (entrada.read() == 1) {
                    break;
                }

            }

            flujo.close();

            cliente.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

}
