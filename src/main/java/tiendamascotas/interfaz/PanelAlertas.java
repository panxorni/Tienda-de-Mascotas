package tiendamascotas.interfaz;
import tiendamascotas.logica.patrones.observer.ObservadorMascotas;
import javax.swing.*;
import java.awt.*;

public class PanelAlertas extends JPanel implements ObservadorMascotas {

    // Componente visual donde se veran los mensajes
    private JTextArea areaTextoAlertas;

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

    @Override
    public void actualizarAlerta(String nombreMascota, String tipoAlerta, String mensaje) {
        //agrega el texto a la interfaz visual
        String alertaFormateada = "[!] " + tipoAlerta.toUpperCase() + " | " + nombreMascota + "\n    " + mensaje + "\n\n";
        areaTextoAlertas.append(alertaFormateada);

        // scrollbar bajada a la ultima alerta automaticamente
        areaTextoAlertas.setCaretPosition(areaTextoAlertas.getDocument().getLength());
    }
}
