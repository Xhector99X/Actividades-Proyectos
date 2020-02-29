package practicat3ad;

import controlador.NewHibernateUtil;
import modelo.Equipos;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.List;
import org.hibernate.SessionFactory;
import java.util.logging.*;

public class PracticaT3Ad {
    public static void main(String[] args) {
        
        SessionFactory conexion;
        
      /*
        //insertar
// Desactivamos los mensajes de hibérnate de la consola
        Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
// Creamos la conexión con la base de datos con SessionFactory()
         conexion = NewHibernateUtil.getSessionFactory();
// Creamos una instancia de Pelicula para insertarla en la tabla Peliculas
        BigDecimal precio = new BigDecimal(890.99);
        Equipos miEquipo = new Equipos(5, "asus", "zenbook","ultrabook pequeño y muy polivalente", 13,8,256 ,precio);
// Llamamos al método altaPelicula pasandole como parámetros
// la conexión y la instancia de Pelicula
        controlador.operaciones.altaEquipo(conexion, miEquipo);
// Cerramos la conexión del SessionFactory()
        conexion.close();
*/
      
       /*
        //consulta
// Desactivamos los mensajes de hibérnate de la consola
        Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
// Creamos la conexión con la base de datos con SessionFactory()
        conexion = NewHibernateUtil.getSessionFactory();
// Llamamos al método consultaPelicula pasandole como parámetros
// la conexión y el Id de la pelicula que queremos consultar
        System.out.println(controlador.operaciones.consultaEquipo(conexion, 3).toString());
// Cerramos la conexión del SessionFactory()
        conexion.close();
        
*/
        
        /*
        //Listado equipos hp
        // Desactivamos los mensajes de hibérnate de la consola
        Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
        // Creamos una cadena con la sentencia HQL que queremos ejecutar

        conexion = NewHibernateUtil.getSessionFactory();
// Llamamos al método listarPeliculas pasandole como parámetros
// la conexión y mostramos el resultado con un bucle iterator
        List miLista = controlador.operaciones.listarEquiposHp(conexion);
        Iterator iter = miLista.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
// Cerramos la conexión del SessionFactory()
        conexion.close();
        */
        
        
        
        
        /*
         //Listado equipos <15 pulgadas
        // Desactivamos los mensajes de hibérnate de la consola
        Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
        // Creamos una cadena con la sentencia HQL que queremos ejecutar

        conexion = NewHibernateUtil.getSessionFactory();
// Llamamos al método listarPeliculas pasandole como parámetros
// la conexión y mostramos el resultado con un bucle iterator
        List miLista2 = controlador.operaciones.listarEquipos15P(conexion);
        Iterator iter2 = miLista2.iterator();
        while (iter2.hasNext()) {
            System.out.println(iter2.next());
        }
// Cerramos la conexión del SessionFactory()
        conexion.close();
        */
        
        
        /*
         //Listado equipos mas de 4 gb
        // Desactivamos los mensajes de hibérnate de la consola
        Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
        // Creamos una cadena con la sentencia HQL que queremos ejecutar

        conexion = NewHibernateUtil.getSessionFactory();
// Llamamos al método listarPeliculas pasandole como parámetros
// la conexión y mostramos el resultado con un bucle iterator
        List miLista3 = controlador.operaciones.listarEquipos4Gb(conexion);
        Iterator iter3 = miLista3.iterator();
        while (iter3.hasNext()) {
            System.out.println(iter3.next());
        }
// Cerramos la conexión del SessionFactory()
        conexion.close();
*/
        
        
        
        
        //Listado equipos mas de <1000€
        // Desactivamos los mensajes de hibérnate de la consola
        Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
        // Creamos una cadena con la sentencia HQL que queremos ejecutar

        conexion = NewHibernateUtil.getSessionFactory();
// Llamamos al método listarPeliculas pasandole como parámetros
// la conexión y mostramos el resultado con un bucle iterator
        List miLista4 = controlador.operaciones.listarEquipos1000E(conexion);
        Iterator iter4 = miLista4.iterator();
        while (iter4.hasNext()) {
            System.out.println(iter4.next());
        }
// Cerramos la conexión del SessionFactory()
        conexion.close();
       
        
        
 /*      
        //Listado equipos que contenga ultrabook
        // Desactivamos los mensajes de hibérnate de la consola
        Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
        // Creamos una cadena con la sentencia HQL que queremos ejecutar

        conexion = NewHibernateUtil.getSessionFactory();
// Llamamos al método listarPeliculas pasandole como parámetros
// la conexión y mostramos el resultado con un bucle iterator
        List miLista5 = controlador.operaciones.listarEquiposUltrabook(conexion);
        Iterator iter5 = miLista5.iterator();
        while (iter5.hasNext()) {
            System.out.println(iter5.next());
        }
// Cerramos la conexión del SessionFactory()
        conexion.close();
      
        
        */
        

    }
    
}
