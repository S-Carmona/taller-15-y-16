// --- CÓDIGO REFACTORIZADO APLICANDO SRP ---

// 1. Clase que contiene exclusivamente los datos del perfil del usuario
class Usuario {
    private String nombreUsuario;
    private String correo;
    private String contrasena;

    public Usuario(String nombreUsuario, String correo, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public String getNombreUsuario() { return nombreUsuario; }
    public String getCorreo() { return correo; }
    public String getContrasena() { return contrasena; }
}

// 2. Clase con la responsabilidad única de validar formatos de datos
class ValidadorUsuarioService {
    public boolean validarCorreo(Usuario usuario) {
        // Simulación de validación de formato de correo electrónico
        System.out.println("Validando formato de correo: " + usuario.getCorreo());
        return usuario.getCorreo().contains("@");
    }
}

// 3. Clase con la responsabilidad única de gestionar los accesos y seguridad (Autenticación)
class AutenticacionService {
    public boolean iniciarSesion(Usuario usuario, String intentoUsuario, String intentoContrasena) {
        System.out.println("Procesando credenciales en el sistema de autenticación...");
        return usuario.getNombreUsuario().equals(intentoUsuario) && usuario.getContrasena().equals(intentoContrasena);
    }
}

// Clase de prueba unificada
public class MainUsuarioSRP {
    public static void main(String[] args) {
        Usuario user = new Usuario("scarmona", "carmona@utb.edu.co", "Admin123");

        ValidadorUsuarioService validador = new ValidadorUsuarioService();
        AutenticacionService auth = new AutenticacionService();

        // 1. Validar el formato
        if (validador.validarCorreo(user)) {
            System.out.println("Formato de correo válido.");
        }

        // 2. Intentar autenticación
        boolean acceso = auth.iniciarSesion(user, "scarmona", "Admin123");
        System.out.println("Resultado del ingreso: " + (acceso ? "Acceso Permitido" : "Credenciales Incorrectas"));
    }
}