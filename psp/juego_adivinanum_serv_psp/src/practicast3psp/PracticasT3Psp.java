package practicast3psp;

import java.io.*;
import java.net.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

public class PracticasT3Psp {

    public static void main(String[] args) {

        ServerSocket servidor;
        int numeroPuerto = 6001;

        int numAzar = 0;
        try {
            servidor = new ServerSocket(numeroPuerto);

            System.out.println("Esperando al cliente.....");
            Socket clienteConectado = servidor.accept();

            DataInputStream entrada = new DataInputStream(clienteConectado.getInputStream());
            DataOutputStream flujo = new DataOutputStream(clienteConectado.getOutputStream());

            numAzar = (int) (Math.random() * 10);

            int acierto = 0;

            LocalTime tiempoAcertado = LocalTime.now();

            for (int i = 1; i < 5; i++) {

                if (numAzar == entrada.readInt()) {

                    System.out.println("No me lo puedo creer, Has averiguado el numero secreto!!! ");

                    System.out.println("Te ha costado " + i + " intentos");

                    System.out.println("El numero secreto era " + numAzar + " ");

                    System.out.println("Tiempo total en acertar el numero secreto " + ChronoUnit.MILLIS.between(tiempoAcertado, LocalTime.now()) + " ms");

                    acierto = 1;

                    flujo.write(acierto);

                    break;

                } else {
                    System.out.println("Sigue probando numeros, este no es el correcto");
                    flujo.write(acierto);

                }

            }

            if (acierto == 0) {
                System.out.println("El numero secreto era el " + numAzar + " GAME OVER :-(");

            }

            entrada.close();
            servidor.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
