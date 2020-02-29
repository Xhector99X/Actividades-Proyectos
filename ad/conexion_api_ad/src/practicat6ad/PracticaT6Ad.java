package practicat6ad;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class PracticaT6Ad {

    public static void main(String[] args) throws MalformedURLException, IOException {

        Scanner tec = new Scanner(System.in);

        System.out.println("Elige un numero del 1 al 5: ");

        System.out.println("----------------------------------------------------------------------------------");

        System.out.println("1.- Listado de libros");
        System.out.println("2.- Consulta de libros");
        System.out.println("3.- Eliminar libro");
        System.out.println("4.- Insertar libro");
        System.out.println("5.- Actualizar libro");

        System.out.println("----------------------------------------------------------------------------------");

        int opc = tec.nextInt();
        tec.nextLine();

        switch (opc) {
            case 1:

                //Listado
                try {
                    //Creamos Conexión
                    URL url = new URL("http://localhost:8080/ApiBiblioteca/ApiB/libros/");
                    HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
                    // Establecemos Método HTTP y tipo de datos para intercambio de información
                    conexion.setRequestMethod("GET");
                    conexion.setRequestProperty("Accept", "application/json");
                    // Obtenemos el código de respuesta.
                    int codigoRespuesta = conexion.getResponseCode();
                    System.out.println("Listado de libros: " + codigoRespuesta);
                    // Creamos el buffer de datos sobre la conexión
                    BufferedReader br = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
                    // Variable que almacenará la salida de la petición
                    
                   
                    
                    String salida;
                    
                    // Mientras hay datos va leyendo líneas de datos
                    while ((salida = br.readLine()) != null) {
                        System.out.println(salida);
                        
             
                /*        
                        // Json a Objeto
                        Gson miGson = new Gson();
                        Libro miLibro = miGson.fromJson(salida, Libro.class);
                        System.out.println("codLibro: " + miLibro.getCodLibro());
                        
                        System.out.println("Titulo: " + miLibro.getTitulo());

                        System.out.println("Autor: " + miLibro.getAutor());

                        System.out.println("Editorial: " + miLibro.getEditorial());

                        System.out.println("Tema: " + miLibro.getTema());

                        System.out.println("Isbn: " + miLibro.getIsbn());

                        // Json a Objeto              

                */        

                    }

                    // Cerramos el flujo de datos
                    br.close();
                    // Cerramos la conexion
                    conexion.disconnect();

                } catch (IOException e) {
                }

                //Listado
                break;

            //---------------------------------------------------------------------------------------------------------------              
            case 2:

                //Consulta
                try {

                    System.out.println("Introduce el id de libro que quieres consultar: ");
                    String consultaId = tec.nextLine();

                    //Creamos Conexión
                    URL url = new URL("http://localhost:8080/ApiBiblioteca/ApiB/libros/" + consultaId);
                    HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
                    // Establecemos Método HTTP y tipo de datos para intercambio de información
                    conexion.setRequestMethod("GET");
                    conexion.setRequestProperty("Accept", "application/json");
                    // Obtenemos el código de respuesta.
                    int codigoRespuesta = conexion.getResponseCode();
                    System.out.println("Consulta: " + codigoRespuesta);
                    // Creamos el buffer de datos sobre la conexión
                    BufferedReader br = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
                    // Variable que almacenará la salida de la petición
                    String salida;
                    // Mientras hay datos va leyendo líneas de datos
                    while ((salida = br.readLine()) != null) {
                         //System.out.println(salida);

                        // Json a Objeto
                        Gson miGson = new Gson();
                        Libro miLibro = miGson.fromJson(salida, Libro.class);
                        System.out.println("codLibro: " + miLibro.getCodLibro());
                        
                        System.out.println("Titulo: " + miLibro.getTitulo());

                        System.out.println("Autor: " + miLibro.getAutor());

                        System.out.println("Editorial: " + miLibro.getEditorial());

                        System.out.println("Tema: " + miLibro.getTema());

                        System.out.println("Isbn: " + miLibro.getIsbn());

                        // Json a Objeto                        
                    }

                    // Cerramos el flujo de datos
                    br.close();
                    // Cerramos la conexion
                    conexion.disconnect();

                } catch (IOException e) {
                }

                //Consulta
                break;

            //---------------------------------------------------------------------------------------------------------------              
            case 3:

                //Eliminar 
                try {

                    System.out.println("Introduce el id de libro que quieres eliminar: ");
                    String eliminaId = tec.nextLine();

                    //Creamos Conexión
                    URL url = new URL("http://localhost:8080/ApiBiblioteca/ApiB/libros/" + eliminaId);
                    HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
                    // Establecemos Método HTTP y tipo de datos para intercambio de información
                    conexion.setRequestMethod("DELETE");
                    conexion.setRequestProperty("Accept", "application/json");
                    // Obtenemos el código de respuesta.
                    int codigoRespuesta = conexion.getResponseCode();
                    System.out.println("Eliminar: " + codigoRespuesta);

                    // Cerramos la conexion
                    conexion.disconnect();

                } catch (IOException e) {
                }

                //Eliminar 
                break;

            //---------------------------------------------------------------------------------------------------------------            
            case 4:

                //insertar 
                System.out.println("Introduce el autor:");
                String autor = tec.nextLine();

                System.out.println("Introduce el codigo del libro:");
                String codLibro = tec.nextLine();

                System.out.println("Introduce la editorial:");
                String editorial = tec.nextLine();

                System.out.println("Introduce el isbn:");
                String isbn = tec.nextLine();

                System.out.println("Introduce el tema:");
                String tema = tec.nextLine();

                System.out.println("Introduce el titulo:");
                String titulo = tec.nextLine();

                try {
                    //Creamos Conexión
                    URL url = new URL("http://localhost:8080/ApiBiblioteca/ApiB/libros/");
                    HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
                    // Establecemos que se va a enviar información, el método HTTP
                    // y tipo de datos para intercambio de información
                    conexion.setDoOutput(true);
                    conexion.setRequestMethod("POST");
                    conexion.setRequestProperty("Content-Type", "application/json");
                    // Creamos el json

                    //String json = "{\"autor\":autor,\"codLibro\":codLibro,\"editorial\":editorial,\"isbn\":isbn,\"tema\":tema,\"titulo\":\titulo}";
                    String json = "{\"autor\" : \"" + autor + "\" , " + "\"codLibro\" : \"" + codLibro + "\"   , " + "\"editorial\": \"" + editorial + "\" , " + "\"isbn\" :\"" + isbn + "\" , " + "\"tema\" :\"" + tema + "\" , " + "\"titulo\" :\"" + titulo + "\" }";

                    // Escribimos información json que enviaremos a la petición
                    // sobre el flujo de datos de salida de la conexión
                    OutputStream os = conexion.getOutputStream();
                    os.write(json.getBytes());
                    os.flush();

                    // Obtenemos el código de respuesta.
                    int codigoRespuesta = conexion.getResponseCode();
                    System.out.println("insertar: " + codigoRespuesta);

                    // Cerramos la conexion
                    conexion.disconnect();

                } catch (IOException e) {
                }

                //insertar    
                break;

            //---------------------------------------------------------------------------------------------------------------            
            case 5:

                //Actualizar
                try {

                    System.out.println("Introduce el codigo del libro sobre el que vas actualizar los registros:");
                    String cod = tec.nextLine();

                    System.out.println("Introduce el autor:");
                    String autor2 = tec.nextLine();

                    System.out.println("Introduce la editorial:");
                    String editorial2 = tec.nextLine();

                    System.out.println("Introduce el isbn:");
                    String isbn2 = tec.nextLine();

                    System.out.println("Introduce el tema:");
                    String tema2 = tec.nextLine();

                    System.out.println("Introduce el titulo:");
                    String titulo2 = tec.nextLine();

                    //Creamos Conexión
                    URL url = new URL("http://localhost:8080/ApiBiblioteca/ApiB/libros/" + cod);
                    HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
                    // Establecemos que se va a enviar información, el método HTTP
                    // y tipo de datos para intercambio de información
                    conexion.setDoOutput(true);
                    conexion.setRequestMethod("PUT");
                    conexion.setRequestProperty("Content-Type", "application/json");
                    // Creamos el json

                    String json = "{\"autor\" : \"" + autor2 + "\" , " + "\"codLibro\" : \"" + cod + "\"   , " + "\"editorial\": \"" + editorial2 + "\" , " + "\"isbn\" :\"" + isbn2 + "\" , " + "\"tema\" :\"" + tema2 + "\" , " + "\"titulo\" :\"" + titulo2 + "\" }";

                    // Escribimos información json que enviaremos a la petición
                    // sobre el flujo de datos de salida de la conexión
                    OutputStream os = conexion.getOutputStream();
                    os.write(json.getBytes());
                    os.flush();

                    // Cerramos la conexion
                    conexion.disconnect();

                    // Obtenemos el código de respuesta.
                    int codigoRespuesta = conexion.getResponseCode();
                    System.out.println("Actualizar: " + codigoRespuesta);

                } catch (IOException e) {
                }
                //Actualizar

                break;

        }

    }
}
