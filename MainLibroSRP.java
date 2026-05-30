// --- CÓDIGO REFACTORIZADO APLICANDO SRP ---

// 1. Clase que se encarga ÚNICAMENTE de la información del Libro
class Libro {
    private String titulo;
    private String autor;
    private String isbn;

    public Libro(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getIsbn() { return isbn; }
}

// 2. Clase especializada ÚNICAMENTE en la generación de reportes del libro
class ReporteLibroService {
    public void generarReporteTextual(Libro libro) {
        System.out.println("Generando reporte: " + libro.getTitulo() + " escrito por " + libro.getAutor());
    }
}

// 3. Clase especializada ÚNICAMENTE en la persistencia (guardado) del libro
class LibroRepository {
    public void guardarEnBaseDeDatos(Libro libro) {
        System.out.println("Guardando el libro '" + libro.getTitulo() + "' en la base de datos...");
    }
}

// Clase de prueba unificada
public class MainLibroSRP {
    public static void main(String[] args) {
        // Crear el objeto de datos
        Libro miLibro = new Libro("Cien años de soledad", "Gabriel García Márquez", "978-0307474728");

        // Instanciar los servicios especializados
        ReporteLibroService reporteService = new ReporteLibroService();
        LibroRepository repositorio = new LibroRepository();

        // Cada clase ejecuta su única responsabilidad
        reporteService.generarReporteTextual(miLibro);
        repositorio.guardarEnBaseDeDatos(miLibro);
    }
}