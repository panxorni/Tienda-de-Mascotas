package tiendamascotas.interfaz;

import javax.swing.*;
import java.awt.*;

/**
 * Ventana principal de la aplicación gráfica de la tienda de mascotas.
 * Organiza los paneles de mercado, inventario, cliente y alertas, además
 * de exponer los botones de acción que serán conectados por el controlador.
 */
public class VentanaPrincipal extends JFrame {

    private JLabel lblPresupuesto;

    private MercadoPanel mercadoPanel;
    private InventarioPanel inventarioPanel;
    private PanelAlertas panelAlertas;

    private JButton btnAlimentar;
    private JButton btnJugar;
    private JButton btnLimpiar;
    private JButton btnDarMedicina;
    private JButton btnVender;

    private ClientePanel clientePanel;

    /**
     * Se inicializa la ventana principal.
     * Configura la ventana, crea sus componentes visuales y los organiza
     * dentro del layout principal.
     */
    public VentanaPrincipal(){
        configurarVentana();
        crearComponentes();
        organizarComponentes();
    }

    /**
     * Se configura la ventana principal con título, tamaño, cierre,
     * posición inicial y layout base.
     */
    private void configurarVentana(){
        setTitle("Simulador de Tienda de Mascotas Virtual");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 650);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
    }

    /**
     * Se crean los componentes visuales principales de la ventana,
     * incluyendo paneles, etiquetas y botones de acción.
     */
    private void crearComponentes(){
        lblPresupuesto = new JLabel("Presupuesto: 0");
        lblPresupuesto.setFont(new Font("Arial", Font.BOLD, 18));

        mercadoPanel = new MercadoPanel();
        inventarioPanel = new InventarioPanel();
        panelAlertas = new PanelAlertas();

        btnAlimentar = new JButton("Alimentar");
        btnJugar = new JButton("Jugar");
        btnLimpiar = new JButton("Limpiar habitat");
        btnDarMedicina = new JButton("Dar medicina");
        btnVender = new JButton("Vender mascota");

        clientePanel= new ClientePanel();
    }

    /**
     * Se organizan los componentes dentro de la ventana.
     * Distribuye el presupuesto, mercado, inventario, acciones, cliente y alertas
     * en las zonas correspondientes del BorderLayout.
     */
    private void organizarComponentes(){
        JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelSuperior.add(lblPresupuesto);

        JPanel panelAcciones = new JPanel(new GridLayout(5,1,5,5));
        panelAcciones.setBorder(BorderFactory.createTitledBorder("Acciones de mascota"));
        panelAcciones.add(btnAlimentar);
        panelAcciones.add(btnJugar);
        panelAcciones.add(btnLimpiar);
        panelAcciones.add(btnDarMedicina);
        panelAcciones.add(btnVender);

        JPanel panelDerecho = new JPanel(new BorderLayout(5,5));
        panelDerecho.setPreferredSize(new Dimension(340, 0));
        panelAlertas.setPreferredSize(new Dimension(340, 280));
        panelDerecho.add(panelAcciones, BorderLayout.NORTH);
        panelDerecho.add(clientePanel, BorderLayout.CENTER);
        panelDerecho.add(panelAlertas, BorderLayout.SOUTH);

        add(panelSuperior, BorderLayout.NORTH);
        add(mercadoPanel, BorderLayout.WEST);
        add(inventarioPanel, BorderLayout.CENTER);
        add(panelDerecho, BorderLayout.EAST);
    }

    /**
     * Se actualiza la etiqueta visual que muestra el presupuesto de la tienda.
     * @param presupuesto El presupuesto actual que se mostrará en pantalla.
     */
    public void actualizarPresupuesto(int presupuesto){
        lblPresupuesto.setText("presupuesto: $" + presupuesto);
    }

    /**
     * Se obtiene el panel del mercado proveedor.
     * @return El panel MercadoPanel utilizado para comprar mascotas y suministros.
     */
    public MercadoPanel getMercadoPanel() {
        return mercadoPanel;
    }

    /**
     * Se obtiene el panel del inventario general.
     * @return El panel InventarioPanel utilizado para mostrar stock y mascotas.
     */
    public InventarioPanel getInventarioPanel() {
        return inventarioPanel;
    }

    /**
     * Se obtiene el panel de alertas del sistema.
     * @return El panel PanelAlertas utilizado para mostrar mensajes y notificaciones.
     */
    public PanelAlertas getPanelAlertas() {
        return panelAlertas;
    }

    /**
     * Se obtiene el botón para alimentar una mascota.
     * @return El botón JButton correspondiente a la acción de alimentar.
     */
    public JButton getBtnAlimentar() {
        return btnAlimentar;
    }

    /**
     * Se obtiene el botón para jugar con una mascota.
     * @return El botón JButton correspondiente a la acción de jugar.
     */
    public JButton getBtnJugar() {
        return btnJugar;
    }

    /**
     * Se obtiene el botón para limpiar el hábitat de una mascota.
     * @return El botón JButton correspondiente a la acción de limpieza.
     */
    public JButton getBtnLimpiar() {
        return btnLimpiar;
    }

    /**
     * Se obtiene el botón para dar medicina a una mascota.
     * @return El botón JButton correspondiente a la acción de entregar medicina.
     */
    public JButton getBtnDarMedicina() {
        return btnDarMedicina;
    }

    /**
     * Se obtiene el botón para vender una mascota.
     * @return El botón JButton correspondiente a la acción de venta.
     */
    public JButton getBtnVender() {
        return btnVender;
    }

    /**
     * Se obtiene el panel que muestra la información del cliente virtual.
     * @return El panel ClientePanel utilizado para mostrar el cliente actual.
     */
    public ClientePanel getClientePanel(){
        return clientePanel;
    }
}
