// Interfaz que define la acción de enviar mensajes de manera abstracta
interface CanalNotificacion {
    void enviar(String mensaje);
}

// 1. Clase inicial: maneja el envío de correos electrónicos
class EnvioCorreo implements CanalNotificacion {
    @Override
    public void enviar(String mensaje) {
        System.out.println("Enviando correo electrónico: " + mensaje);
    }
}

// 2. Refactorización/Extensión: agregamos canal SMS sin alterar EnvioCorreo
class EnvioSMS implements CanalNotificacion {
    @Override
    public void enviar(String mensaje) {
        System.out.println("Enviando mensaje de texto SMS: " + mensaje);
    }
}

// Extensión adicional: canal para notificaciones Push
class EnvioPush implements CanalNotificacion {
    @Override
    public void enviar(String mensaje) {
        System.out.println("Enviando notificación Push al celular: " + mensaje);
    }
}

// Clase de prueba
public class MainMensajeroOCP {
    public static void main(String[] args) {
        String alerta = "Su código de verificación es 4832.";

        // El sistema puede usar cualquier canal dinámicamente cumpliendo el OCP
        CanalNotificacion canal1 = new EnvioCorreo();
        canal1.enviar(alerta);

        CanalNotificacion canal2 = new EnvioSMS();
        canal2.enviar(alerta);

        CanalNotificacion canal3 = new EnvioPush();
        canal3.enviar(alerta);
    }
}