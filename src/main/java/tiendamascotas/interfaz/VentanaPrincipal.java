package tiendamascotas.interfaz;

import javax.swing.*;
import java.awt.*;

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

    //Método constructor de ventana principal.
    //Al llamarlo ejecuta, la configuración de la ventana más la creacion y organizacion de componentes
    public VentanaPrincipal(){
        configurarVentana();
        crearComponentes();
        organizarComponentes();
    }

    //configuración inicial de la ventana
    private void configurarVentana(){
        setTitle("Simulador de Tienda de Mascotas Virtual");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 650);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
    }

    //crea los componentes (labels, paneles, botones)
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
    }

    //método para organizar componentes, modificar el layout mas adelante
    private void organizarComponentes(){
        //panelSuperior contiene el label presupuesto
        JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelSuperior.add(lblPresupuesto);

        //panelAcciones contiene los botones de las acciones para las mascotas
        JPanel panelAcciones = new JPanel(new GridLayout(5,1,5,5));
        panelAcciones.setBorder(BorderFactory.createTitledBorder("Acciones de mascota"));
        panelAcciones.add(btnAlimentar);
        panelAcciones.add(btnJugar);
        panelAcciones.add(btnLimpiar);
        panelAcciones.add(btnDarMedicina);
        panelAcciones.add(btnVender);

        //panelDerecho contiene al panelAcciones y panelAlertas
        JPanel panelDerecho = new JPanel(new BorderLayout(5,5));
        panelDerecho.add(panelAcciones, BorderLayout.NORTH);
        panelDerecho.add(panelAlertas, BorderLayout.CENTER);

        //agrega los paneles a la ventana
        add(panelSuperior, BorderLayout.NORTH);
        add(mercadoPanel, BorderLayout.WEST);
        add(inventarioPanel, BorderLayout.CENTER);
        add(panelDerecho, BorderLayout.EAST);
    }

    //método para actualizar el label presupuesto
    public void actualizarPresupuesto(int presupuesto){
        lblPresupuesto.setText("presupuesto: $" + presupuesto);
    }

    //Métodos getter para utilizar en ControladorJuego

    public MercadoPanel getMercadoPanel() {
        return mercadoPanel;
    }

    public InventarioPanel getInventarioPanel() {
        return inventarioPanel;
    }

    public PanelAlertas getPanelAlertas() {
        return panelAlertas;
    }

    public JButton getBtnAlimentar() {
        return btnAlimentar;
    }

    public JButton getBtnJugar() {
        return btnJugar;
    }

    public JButton getBtnLimpiar() {
        return btnLimpiar;
    }

    public JButton getBtnDarMedicina() {
        return btnDarMedicina;
    }

    public JButton getBtnVender() {
        return btnVender;
    }
}
