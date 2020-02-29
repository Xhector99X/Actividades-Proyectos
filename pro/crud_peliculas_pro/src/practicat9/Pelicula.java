package practicat9;
public class Pelicula {
    private int idEmpleado;
    private String titulo;
    private String tema;
    private int duracion;
    private double precio;

    public Pelicula(int idEmpleado, String titulo, String tema, int duracion, double precio) {
        this.idEmpleado = idEmpleado;
        this.titulo = titulo;
        this.tema = tema;
        this.duracion = duracion;
        this.precio = precio;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return  idEmpleado + "\t"+  titulo +"\t"+  tema +"\t"+  duracion +"\t"+  precio ;
    }

    
    
    
}

