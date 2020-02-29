package controlador;

import modelo.Equipos;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class operaciones {
    
        public static void altaEquipo(SessionFactory conexion, Equipos miEquipo) {
// Abrimos la sesión para poder realizar una transacción
// con la base de datos
        Session sesion = conexion.openSession();
// Comenzamos la transacción
        Transaction tx = sesion.beginTransaction();
// Insertamos la instancia de pelicula en la base de datos
        sesion.save(miEquipo);
// Confirmamos la transacción
        tx.commit();
// Cerramos la sesión
        sesion.close();
// Mostramos mensaje indicando que se ha insertado el registro
        System.out.println("Registro Insertado");

    }

    public static Equipos consultaEquipo(SessionFactory conexion, int IdEquipo) {
// Declaramos una instancia de Pelicula
        Equipos miEquipo;
// Abrimos la sesión para poder realizar una transacción
// con la base de datos
        Session sesion = conexion.openSession();
// Comenzamos la transacción
        Transaction tx = sesion.beginTransaction();
// Almacenamos en la instancia el registro de la base de datos
        miEquipo = (Equipos) sesion.get(Equipos.class, IdEquipo);
// Confirmamos la transacción
        tx.commit();
// Cerramos la sesión
        sesion.close();
        return miEquipo;
        
    }
    
    
     public static List<Equipos> listarEquiposHp(SessionFactory conexion) {
        // Declaramos una instancia de Lista de Pelicula
        List<Equipos> lista;
        // Abrimos la sesión para poder realizar una transacción
        // con la base de datos
         
        Session sesion = conexion.openSession();
        // Comenzamos la transacción
        Transaction tx = sesion.beginTransaction();
        // Almacenamos en la instancia de lista de pelicula
        // los registros de la consulta de la base de datos
        Query registros = sesion.createQuery("select p from Equipos p where marca like'%hp%'");
        lista = registros.list();
        // Confirmamos la transacción
        tx.commit();
        // Cerramos la sesión
        sesion.close();
        // Retornamos la Lista de registros
        return lista;
    }
     
     
     
       public static List<Equipos> listarEquipos15P(SessionFactory conexion) {
        // Declaramos una instancia de Lista de Pelicula
        List<Equipos> lista;
        // Abrimos la sesión para poder realizar una transacción
        // con la base de datos
         
        Session sesion = conexion.openSession();
        // Comenzamos la transacción
        Transaction tx = sesion.beginTransaction();
        // Almacenamos en la instancia de lista de pelicula
        // los registros de la consulta de la base de datos
        Query registros = sesion.createQuery("select p from Equipos p where pulgadasPantalla < 15");
        lista = registros.list();
        // Confirmamos la transacción
        tx.commit();
        // Cerramos la sesión
        sesion.close();
        // Retornamos la Lista de registros
        return lista;
        
       }
        
        
         public static List<Equipos> listarEquipos4Gb(SessionFactory conexion) {
        // Declaramos una instancia de Lista de Pelicula
        List<Equipos> lista;
        // Abrimos la sesión para poder realizar una transacción
        // con la base de datos
         
        Session sesion = conexion.openSession();
        // Comenzamos la transacción
        Transaction tx = sesion.beginTransaction();
        // Almacenamos en la instancia de lista de pelicula
        // los registros de la consulta de la base de datos
        Query registros = sesion.createQuery("select p from Equipos p where gbMemoria > 4 and capacidadDisco > 500 ");
        lista = registros.list();
        // Confirmamos la transacción
        tx.commit();
        // Cerramos la sesión
        sesion.close();
        // Retornamos la Lista de registros
        return lista;
     
    }
         
         
         
         
         public static List<Equipos> listarEquipos1000E(SessionFactory conexion) {
        // Declaramos una instancia de Lista de Pelicula
        List<Equipos> lista;
        // Abrimos la sesión para poder realizar una transacción
        // con la base de datos
         
        Session sesion = conexion.openSession();
        // Comenzamos la transacción
        Transaction tx = sesion.beginTransaction();
        // Almacenamos en la instancia de lista de pelicula
        // los registros de la consulta de la base de datos
        Query registros = sesion.createQuery("select p from Equipos p where precio < 1000 or gbMemoria = 8 ");
        lista = registros.list();
        // Confirmamos la transacción
        tx.commit();
        // Cerramos la sesión
        sesion.close();
        // Retornamos la Lista de registros
        return lista;
     
    }
         
         
         
         
         
         
         
         
          public static List<Equipos> listarEquiposUltrabook(SessionFactory conexion) {
        // Declaramos una instancia de Lista de Pelicula
        List<Equipos> lista;
        // Abrimos la sesión para poder realizar una transacción
        // con la base de datos
         
        Session sesion = conexion.openSession();
        // Comenzamos la transacción
        Transaction tx = sesion.beginTransaction();
        // Almacenamos en la instancia de lista de pelicula
        // los registros de la consulta de la base de datos
        Query registros = sesion.createQuery("select p from Equipos p where descripcion like'%ultrabook%' ");
        lista = registros.list();
        // Confirmamos la transacción
        tx.commit();
        // Cerramos la sesión
        sesion.close();
        // Retornamos la Lista de registros
        return lista;
     
    }
 
}
