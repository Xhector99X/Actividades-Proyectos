package practicat7;
import java.time.*;
import java.time.temporal.ChronoUnit;
public class Vehiculo {
    private String matricula;
    private String marca;
    private String modelo;
    private LocalDate fechaMatriculacion;
    private int cilindrada;
    private int potencia;
    private LocalTime horaLlegada;

    public Vehiculo(String matricula, String marca, String modelo, LocalDate fechaMatriculacion, int cilindrada, int potencia) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.fechaMatriculacion = fechaMatriculacion;
        this.cilindrada = cilindrada;
        this.potencia = potencia;
        this.horaLlegada = LocalTime.now();
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public LocalDate getFechaMatriculacion() {
        return fechaMatriculacion;
    }

    public void setFechaMatriculacion(LocalDate fechaMatriculacion) {
        this.fechaMatriculacion = fechaMatriculacion;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public LocalTime getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(LocalTime horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    @Override
    public String toString() {
        LocalTime horaActual = LocalTime.now();
        long tiempo = ChronoUnit.SECONDS.between(horaLlegada, horaActual);
        return  matricula + "-" + marca + "-" + modelo + "-" + fechaMatriculacion + "-" + cilindrada + "- " + potencia + "- " + tiempo+" seg.<br>";
    }
    
    
    

   
}
