package tiendamascotas.interfaz;
import tiendamascotas.logica.patrones.observer.ObservadorMascotas;
import javax.swing.*;
import java.awt.*;

/**
 * Panel gráfico que actúa como observador concreto dentro del patrón Observer.
 * Se encarga de recibir y mostrar visualmente las notificaciones de estado
 * crítico (hambre, enfermedad, aburrimiento) emitidas por las mascotas.
 */
public class PanelAlertas extends JPanel implements ObservadorMascotas {

    // Componente visual donde se veran los mensajes
    private JTextArea areaTextoAlertas;

    /**
     * Se inicializa el panel de alertas.
     * Se configura el diseño principal con un borde titulado y se construye un
     * área de texto de solo lectura, con fuente monoespaciada y color rojo.
     * Además, se agrega una barra de desplazamiento (scroll) para manejar el
     * historial de notificaciones.
     */
    public PanelAlertas() {
        //config básica del panel
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("PANEL DE ALERTAS"));

        //config del area de texto
        areaTextoAlertas = new JTextArea(15, 30);
        areaTextoAlertas.setEditable(false); //evita que el jugador escriba aqui
        areaTextoAlertas.setForeground(Color.RED);
        areaTextoAlertas.setFont(new Font("Monospaced", Font.BOLD, 12));
        areaTextoAlertas.setText(">> Sistema de alertas iniciado...\n");

        // srollbar
        JScrollPane scrollPane = new JScrollPane(areaTextoAlertas);
        add(scrollPane, BorderLayout.CENTER);
    }

    /**
     * Se recibe, formatea y agrega el texto de una nueva alerta a la interfaz visual.
     * Se asegura también de que la barra de desplazamiento baje automáticamente
     * para visualizar siempre la alerta más reciente.
     * @param nombreMascota El nombre de la mascota que generó la alerta.
     * @param tipoAlerta La categoría de la advertencia (por ejemplo: Hambre, Enfermedad, Aburrimiento).
     * @param mensaje El texto detallado de la notificación que informa sobre el estado crítico del animal.
     */
    @Override
    public void actualizarAlerta(String nombreMascota, String tipoAlerta, String mensaje) {
        //agrega el texto a la interfaz visual
        String alertaFormateada = "[!] " + tipoAlerta.toUpperCase() + " | " + nombreMascota + "\n    " + mensaje + "\n\n";
        areaTextoAlertas.append(alertaFormateada);

        // scrollbar bajada a la ultima alerta automaticamente
        areaTextoAlertas.setCaretPosition(areaTextoAlertas.getDocument().getLength());
    }
}