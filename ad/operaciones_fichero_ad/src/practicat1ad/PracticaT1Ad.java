package practicat1ad;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;

public class PracticaT1Ad {

    public static void main(String[] args) throws IOException {
        Scanner tec = new Scanner(System.in);
        int opcion = 0;
        String nombre;
        String capital;
        double superficie;
        int habitantes;
        boolean costero;
        File archivo = new File("mipais.txt");
        Pais mipais = new Pais();

        while (opcion != 5) {
            System.out.println("Practica AD T1 HECTOR CARPIO");
            System.out.println("------------------------------------------------");
            System.out.println("1.- Pedir datos del país y crear fichero.");
            System.out.println("2.- Leer fichero y volcar datos a objeto miPais.");
            System.out.println("3.- Crear fichero XML a partir del objeto miPais.");
            System.out.println("4.- Crear fichero Json a partir del objeto miPais.");
            System.out.println("5.- Salir de la aplicación");

            System.out.println("Escribe una de las opciones:");
            opcion = tec.nextInt();
            tec.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Introduce el nombre del pais: ");
                    nombre = tec.nextLine();

                    System.out.println("Introduce la capital del pais: ");
                    capital = tec.nextLine();

                    System.out.println("Introduce la superficie del pais: ");
                    superficie = tec.nextDouble();
                    tec.nextLine();

                    System.out.println("Introduce los habitantes del pais: ");
                    habitantes = tec.nextInt();
                    tec.nextLine();

                    System.out.println("Introduce si el pais es costero: ");
                    costero = tec.nextBoolean();

                    //true añade
                    try {
                        FileWriter fw = new FileWriter(archivo);
                        BufferedWriter bw = new BufferedWriter(fw);

                        bw.write(nombre);
                        bw.newLine();

                        bw.write(capital);
                        bw.newLine();

                        String superficiecast = String.valueOf(superficie);
                        bw.write(superficiecast);
                        bw.newLine();

                        String habitantescast = String.valueOf(habitantes);
                        bw.write(habitantescast);
                        bw.newLine();

                        String costerocast = String.valueOf(costero);
                        bw.write(costerocast);
                        bw.newLine();

                        bw.close();
                        fw.close();
                    } catch (IOException e) {
                        System.out.println("Se ha producido un error");
                    }

                    break;

                case 2:

                    //true añade
                    try {

                        FileReader fr = new FileReader(archivo);
                        BufferedReader br = new BufferedReader(fr);

                        nombre = br.readLine();
                        capital = br.readLine();
                        superficie = Double.valueOf(br.readLine());
                        habitantes = Integer.valueOf(br.readLine());
                        costero = Boolean.valueOf(br.readLine());
                        mipais = new Pais(nombre, capital, superficie, habitantes, costero);

                        System.out.println(mipais.toString());
                        br.close();
                        fr.close();

                    } catch (IOException e) {
                        System.out.println("Se ha producido un error");
                    }

                    break;

                case 3:

                    //pasar de objeto a xml
                    System.out.println(mipais.toString());

                    try {

                        JAXBContext contexto = JAXBContext.newInstance(mipais.getClass());
                        Marshaller marshaller = contexto.createMarshaller();

                        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
                                Boolean.TRUE);

                        //marshaller.marshal(miEmpleado, System.out);
                        marshaller.marshal(mipais, new File("mipais.xml"));
                    } catch (PropertyException e) {
                        e.printStackTrace();
                    } catch (JAXBException e) {
                        e.printStackTrace();
                    }

                    break;

                case 4:

                    //pasar de objeto a json
                    // Json a Objeto
                    File gson = new File("gson.json");

                    FileWriter fw = new FileWriter(gson);
                    BufferedWriter bw = new BufferedWriter(fw);

                    Gson miGson = new Gson();
                    String jdv = miGson.toJson(mipais);

                    bw.write(jdv);
                    bw.newLine();

                    bw.close();
                    fw.close();

                    // Objeto a Json
                    String jsonDevuelto = miGson.toJson(mipais);
                    System.out.println(jsonDevuelto);

                    break;

                case 5:

                    System.out.println("aplicación terminada");

            }
        }

    }

}
