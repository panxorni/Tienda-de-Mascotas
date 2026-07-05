package tiendamascotas.interfaz;

import javax.swing.*;
import java.awt.*;

/**
 * Panel gráfico encargado de representar visualmente el mercado proveedor de la tienda.
 * Contiene los catálogos y botones interactivos necesarios para la adquisición
 * tanto de nuevas mascotas como de suministros (alimento y medicamentos).
 */
public class MercadoPanel extends JPanel {

    // 1. Se declaran los botones de las Mascotas
    private JButton btnComprarPerro;
    private JButton btnComprarGato;
    private JButton btnComprarPajaro;
    private JButton btnComprarPez;

    // 2. Se declaran los botones de los Suministros
    private JButton btnComprarComidaPerro;
    private JButton btnComprarComidaGato;
    private JButton btnComprarComidaPajaro;
    private JButton btnComprarComidaPez;
    private JButton btnComprarMedicina;

    /**
     * Se inicializa el panel del mercado.
     * Se configura el diseño principal (BorderLayout) y se invocan los métodos
     * internos encargados de construir las secciones de mascotas y suministros.
     */
    public MercadoPanel() {
        // Se configura el panel principal del mercado
        setLayout(new BorderLayout(0, 10));
        setBorder(BorderFactory.createTitledBorder("Mercado Proveedor"));

        // Se construyen las dos mitades del mercado
        crearSeccionMascotas();
        crearSeccionSuministros();
    }

    /**
     * Se construye la sección superior del panel, la cual contiene un catálogo
     * estructurado en cuadrícula con botones interactivos para la compra de
     * los diferentes tipos de animales disponibles.
     */
    private void crearSeccionMascotas() {
        JPanel panelMascotas = new JPanel(new GridLayout(2, 2, 5, 5));
        panelMascotas.setBorder(BorderFactory.createTitledBorder("Catálogo de Animales"));

        btnComprarPerro = new JButton("Perro ($500)");
        btnComprarGato = new JButton("Gato ($450)");
        btnComprarPajaro = new JButton("Pájaro ($300)");
        btnComprarPez = new JButton("Pez ($150)");

        panelMascotas.add(btnComprarPerro);
        panelMascotas.add(btnComprarGato);
        panelMascotas.add(btnComprarPajaro);
        panelMascotas.add(btnComprarPez);

        // Se agrega esta sección a la parte superior (Norte) del MercadoPanel
        add(panelMascotas, BorderLayout.NORTH);
    }

    /**
     * Se construye la sección central del panel, destinada al catálogo de suministros.
     * Contiene una cuadrícula con botones interactivos para adquirir alimento
     * específico para cada animal, así como medicamentos generales.
     */
    private void crearSeccionSuministros() {
        JPanel panelSuministros = new JPanel(new GridLayout(3, 2, 5, 5));
        panelSuministros.setBorder(BorderFactory.createTitledBorder("Catálogo de Suministros"));

        btnComprarComidaPerro = new JButton("Comida Perro");
        btnComprarComidaGato = new JButton("Comida Gato");
        btnComprarComidaPajaro = new JButton("Comida Pájaro");
        btnComprarComidaPez = new JButton("Comida Pez");
        btnComprarMedicina = new JButton("Medicamento");

        panelSuministros.add(btnComprarComidaPerro);
        panelSuministros.add(btnComprarComidaGato);
        panelSuministros.add(btnComprarComidaPajaro);
        panelSuministros.add(btnComprarComidaPez);
        panelSuministros.add(btnComprarMedicina);

        // Se agrega esta sección al Centro del MercadoPanel
        add(panelSuministros, BorderLayout.CENTER);
    }

    // --- GETTERS ---
    // Se utilizan para que la ventana principal exponga estos botones al Controlador

    /**
     * Se obtiene el botón para la compra de un perro.
     * @return El componente JButton correspondiente a la adquisición de un perro.
     */
    public JButton getBtnComprarPerro() { return btnComprarPerro; }

    /**
     * Se obtiene el botón para la compra de un gato.
     * @return El componente JButton correspondiente a la adquisición de un gato.
     */
    public JButton getBtnComprarGato() { return btnComprarGato; }

    /**
     * Se obtiene el botón para la compra de un pájaro.
     * @return El componente JButton correspondiente a la adquisición de un pájaro.
     */
    public JButton getBtnComprarPajaro() { return btnComprarPajaro; }

    /**
     * Se obtiene el botón para la compra de un pez.
     * @return El componente JButton correspondiente a la adquisición de un pez.
     */
    public JButton getBtnComprarPez() { return btnComprarPez; }

    /**
     * Se obtiene el botón para la compra de alimento para perros.
     * @return El componente JButton correspondiente a la adquisición de comida de perro.
     */
    public JButton getBtnComprarComidaPerro() { return btnComprarComidaPerro; }

    /**
     * Se obtiene el botón para la compra de alimento para gatos.
     * @return El componente JButton correspondiente a la adquisición de comida de gato.
     */
    public JButton getBtnComprarComidaGato() { return btnComprarComidaGato; }

    /**
     * Se obtiene el botón para la compra de alimento para pájaros.
     * @return El componente JButton correspondiente a la adquisición de comida de pájaro.
     */
    public JButton getBtnComprarComidaPajaro() { return btnComprarComidaPajaro; }

    /**
     * Se obtiene el botón para la compra de alimento para peces.
     * @return El componente JButton correspondiente a la adquisición de comida de pez.
     */
    public JButton getBtnComprarComidaPez() { return btnComprarComidaPez; }

    /**
     * Se obtiene el botón para la compra de medicamentos generales.
     * @return El componente JButton correspondiente a la adquisición de medicina.
     */
    public JButton getBtnComprarMedicina() { return btnComprarMedicina; }
}