package tiendamascotas.interfaz;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;
import tiendamascotas.logica.modelo.Mascota;
import tiendamascotas.logica.modelo.suministros.TipoSuministro;

public class InventarioPanel extends JPanel {

    // 1. Se declaran los componentes visuales del inventario
    private JLabel lblStockSuministros;
    private DefaultListModel<String> modeloListaMascotas;
    private JList<String> listaMascotas;

    public InventarioPanel() {
        // Se configura el panel principal del inventario
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Inventario General de la Tienda"));
        setPreferredSize(new Dimension(100, 170));

        // Se construyen las dos secciones internas
        crearSeccionSuministros();
        crearSeccionMascotas();
    }

    private void crearSeccionSuministros() {
        // Se crea un panel superior para el stock
        JPanel panelStock = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 5));

        lblStockSuministros = new JLabel("Almacén: Cargando suministros...");
        lblStockSuministros.setFont(new Font("Arial", Font.BOLD, 12));
        lblStockSuministros.setForeground(new Color(70, 70, 70));

        panelStock.add(lblStockSuministros);

        // Se agrega a la parte superior (Norte) del InventarioPanel
        add(panelStock, BorderLayout.NORTH);
    }

    private void crearSeccionMascotas() {
        // Se inicializa el modelo y la lista para los animales
        modeloListaMascotas = new DefaultListModel<>();
        listaMascotas = new JList<>(modeloListaMascotas);

        // Se configura para que solo se pueda seleccionar un animal a la vez
        listaMascotas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Se añade una barra de desplazamiento por si la lista crece mucho
        JScrollPane scroll = new JScrollPane(listaMascotas);

        // Se agrega la lista al Centro del InventarioPanel
        add(scroll, BorderLayout.CENTER);
    }

    // --- MÉTODOS DE ACTUALIZACIÓN ---
    // El Controlador usará estos métodos a través de la Ventana Principal

    public void actualizarStockSuministros(Map<TipoSuministro, Integer> stock) {
        StringBuilder sb = new StringBuilder("📦 STOCK EN ALMACÉN -> ");

        // Se recorre el mapa de suministros y se formatea el texto
        for (Map.Entry<TipoSuministro, Integer> entry : stock.entrySet()) {
            sb.append(entry.getKey().name())
                    .append(": ")
                    .append(entry.getValue())
                    .append(" uds.  |  ");
        }

        // Se actualiza la etiqueta visual
        lblStockSuministros.setText(sb.toString());
    }

    public void refrescarListaMascotas(List<Mascota> lista) {
        // Se limpia la lista visual antes de recargarla
        modeloListaMascotas.clear();

        // Se recorre la lista real de la tienda y se agregan los textos formateados
        for (Mascota m : lista) {
            String datos = String.format("%s - %s [Hambre: %d%% | Salud: %d%% | Felicidad: %d%% | Estado: %s]",
                    m.getNombre(),
                    m.getClass().getSimpleName(),
                    m.getHambre(),
                    m.getSalud(),
                    m.getFelicidad(),
                    m.getEstado().getClass().getSimpleName());

            modeloListaMascotas.addElement(datos);
        }
    }

    //metodo para obtener la mascota seleccionada
    public int getIndiceMascotaSeleccionada(){
        return listaMascotas.getSelectedIndex();
    }
}
