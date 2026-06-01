// Interfaz base para la exportación de documentos
interface ExportadorDocumento {
    void exportar(String contenido);
}

// 1. Clase inicial que maneja la exportación a PDF
class ExportadorPDF implements ExportadorDocumento {
    @Override
    public void exportar(String contenido) {
        System.out.println("Exportando el documento a formato PDF...");
        System.out.println("Contenido PDF: " + contenido);
    }
}

// 2. Extensión: agregamos formato Word sin modificar el código de PDF
class ExportadorWord implements ExportadorDocumento {
    @Override
    public void exportar(String contenido) {
        System.out.println("Exportando el documento a formato Word (.docx)...");
        System.out.println("Contenido Word: " + contenido);
    }
}

// Extensión adicional: agregamos formato Excel
class ExportadorExcel implements ExportadorDocumento {
    @Override
    public void exportar(String contenido) {
        System.out.println("Exportando el documento a formato Excel (.xlsx)...");
        System.out.println("Contenido Excel: " + contenido);
    }
}

// Clase de prueba
public class MainDocumentosOCP {
    public static void main(String[] args) {
        String informe = "Reporte de ventas del segundo semestre.";

        // Usando el exportador inicial (PDF)
        ExportadorDocumento docPdf = new ExportadorPDF();
        docPdf.exportar(informe);

        System.out.println();

        // Usando las extensiones (Word y Excel) sin haber roto el código previo
        ExportadorDocumento docWord = new ExportadorWord();
        docWord.exportar(informe);

        ExportadorDocumento docExcel = new ExportadorExcel();
        docExcel.exportar(informe);
    }
}
