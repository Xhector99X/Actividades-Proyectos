package practicat6ad;
public class Libro {

private int codLibro;
private String titulo;
private String autor;
private String editorial;
private String tema;
private String isbn;

    public Libro(int codLibro, String titulo, String autor, String editorial, String tema, String isbn) {
        this.codLibro = codLibro;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.tema = tema;
        this.isbn = isbn;
    }

    public int getCodLibro() {
        return codLibro;
    }

    public void setCodLibro(int codLibro) {
        this.codLibro = codLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Libro{" + "codLibro=" + codLibro + ", titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial + ", tema=" + tema + ", isbn=" + isbn + '}';
    }


    
}
