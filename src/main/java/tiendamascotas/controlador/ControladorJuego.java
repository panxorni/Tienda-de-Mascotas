package tiendamascotas.controlador;

import tiendamascotas.interfaz.VentanaPrincipal;
import tiendamascotas.logica.modelo.Mascota;
import tiendamascotas.logica.modelo.TiendaMascotas;
import tiendamascotas.logica.modelo.suministros.TipoSuministro;
import tiendamascotas.logica.patrones.factory.*;
import  tiendamascotas.logica.modelo.ClienteVirtual;
import  tiendamascotas.logica.modelo.TipoMascota;

import javax.swing.*;
import java.util.Random;

/**
 * Clase controladora que conecta la interfaz gráfica con la lógica de la tienda.
 * Registra los eventos de los botones, ejecuta las acciones sobre el modelo,
 * actualiza la pantalla y administra la llegada aleatoria de clientes virtuales.
 */
public class ControladorJuego {
    private TiendaMascotas tienda;
    private VentanaPrincipal ventana;
    private Random random= new Random();
    private Timer timerClientes;

    /**
     * Se inicializa el controlador principal del juego.
     * Conecta los eventos de la interfaz, actualiza la pantalla inicial y
     * comienza la programación de clientes aleatorios.
     * @param tienda El modelo principal que administra mascotas, suministros y presupuesto.
     * @param ventana La ventana principal que muestra la interfaz gráfica.
     */
    public ControladorJuego(TiendaMascotas tienda, VentanaPrincipal ventana){
        this.tienda=tienda;
        this.ventana=ventana;

        conectarEventos();
        refrescarPantalla();
        iniciarLlegadaClienteAleatorio();
    }

    /**
     * Se conectan los botones de la interfaz con las acciones correspondientes
     * del controlador.
     */
    private void conectarEventos(){
        ventana.getMercadoPanel().getBtnComprarPerro().addActionListener(e ->
                comprarMascotaConFactory(new PerroFactory(), "Perro", 500));

        ventana.getMercadoPanel().getBtnComprarGato().addActionListener(e ->
                comprarMascotaConFactory(new GatoFactory(), "Gato", 450));

        ventana.getMercadoPanel().getBtnComprarPajaro().addActionListener(e ->
                comprarMascotaConFactory(new PajaroFactory(), "Pajaro", 300));

        ventana.getMercadoPanel().getBtnComprarPez().addActionListener(e ->
                comprarMascotaConFactory(new PezFactory(), "Pez", 150));

        ventana.getMercadoPanel().getBtnComprarComidaPerro().addActionListener(e ->
                comprarSuministro(TipoSuministro.COMIDA_PERRO, 1, 100));

        ventana.getMercadoPanel().getBtnComprarComidaGato().addActionListener(e ->
                comprarSuministro(TipoSuministro.COMIDA_GATO, 1, 100));

        ventana.getMercadoPanel().getBtnComprarComidaPajaro().addActionListener(e ->
                comprarSuministro(TipoSuministro.COMIDA_PAJARO, 1, 80));

        ventana.getMercadoPanel().getBtnComprarComidaPez().addActionListener(e ->
                comprarSuministro(TipoSuministro.COMIDA_PEZ, 1, 50));

        ventana.getMercadoPanel().getBtnComprarMedicina().addActionListener(e ->
                comprarSuministro(TipoSuministro.MEDICAMENTOS, 1, 200));

        ventana.getBtnAlimentar().addActionListener(e -> alimentarMascota());

        ventana.getBtnJugar().addActionListener(e -> jugarConMascota());

        ventana.getBtnLimpiar().addActionListener(e -> limpiarHabitat());

        ventana.getBtnDarMedicina().addActionListener(e -> darMedicina());

        ventana.getBtnVender().addActionListener(e -> venderMascota());
    }

    /**
     * Se compra una mascota utilizando una fábrica concreta.
     * Solicita el nombre de la mascota, la crea, la agrega a la tienda y
     * registra la acción en el panel de alertas.
     * @param factory La fábrica encargada de crear el tipo concreto de mascota.
     * @param tipoMascota El nombre visible del tipo de mascota que se comprará.
     * @param precio El precio de compra que será descontado del presupuesto.
     */
    private void comprarMascotaConFactory(MascotaFactory factory, String tipoMascota, int precio){
        try{
            String nombre = JOptionPane.showInputDialog(
                    ventana,
                    "Ingrese el nombre del " + tipoMascota + ":"
            );

            if (nombre ==null || nombre.trim().isEmpty()){
                return;
            }

            Mascota mascota = factory.crearMascota(nombre.trim(), ventana.getPanelAlertas());

            tienda.comprarMascota(mascota, precio);

            registrarAccion(
                    "Compra",
                    "Compraste un " + tipoMascota + " llamado " + mascota.getNombre() + " por $" + precio + "."
            );

            refrescarPantalla();
        }catch (Exception e){
            mostrarError(e.getMessage());
        }
    }

    /**
     * Se compran suministros para la tienda y se actualiza la interfaz.
     * @param tipoSuministro El tipo de suministro que se comprará.
     * @param cantidad La cantidad de unidades que se agregará al inventario.
     * @param precioPorUnidad El precio individual de cada suministro.
     */
    private void comprarSuministro(TipoSuministro tipoSuministro, int cantidad, int precioPorUnidad){
        try{
            tienda.comprarSuministro(tipoSuministro, cantidad, precioPorUnidad);

            registrarAccion(
                    "Compra",
                    "Compraste " + cantidad + " unidad(es) de " + tipoSuministro.name() + "."
            );

            refrescarPantalla();
        }catch (Exception e){
            mostrarError(e.getMessage());
        }
    }

    /**
     * Se obtiene la mascota seleccionada en el panel de inventario.
     * Si no existe selección, se muestra un mensaje de error.
     * @return La mascota seleccionada, o null si no hay ninguna mascota seleccionada.
     */
    private Mascota obtenerMascotaSeleccionada(){
        int indice = ventana.getInventarioPanel().getIndiceMascotaSeleccionada();

        if(indice == -1){
            mostrarError("Debe seleccionar una mascota del inventario");
            return null;
        }
        return tienda.getMascotas().get(indice);
    }

    /**
     * Se alimenta la mascota seleccionada y se refresca la información visual.
     */
    private void alimentarMascota(){
        try{
            Mascota mascota = obtenerMascotaSeleccionada();

            if (mascota == null){
                return;
            }

            tienda.alimentarMascota(mascota);

            registrarAccion(
                    "Alimentar",
                    "Alimentaste a " + mascota.getNombre() + "."
            );

            refrescarPantalla();
        }catch (Exception e){
            mostrarError(e.getMessage());
        }
    }

    /**
     * Se juega con la mascota seleccionada y se refresca la información visual.
     */
    private void jugarConMascota(){
        try {
            Mascota mascota = obtenerMascotaSeleccionada();

            if (mascota == null){
                return;
            }

            tienda.jugarConMascota(mascota);

            registrarAccion(
                    "Jugar",
                    "Jugaste con " + mascota.getNombre() + "."
            );

            refrescarPantalla();
        } catch (Exception e) {
            mostrarError(e.getMessage());
        }
    }

    /**
     * Se limpia el hábitat de la mascota seleccionada y se refresca la información visual.
     */
    private void limpiarHabitat(){
        try{
            Mascota mascota = obtenerMascotaSeleccionada();

            if (mascota == null){
                return;
            }

            tienda.limpiarHabitat(mascota);

            registrarAccion(
                    "Limpieza",
                    "Limpiaste el habitat de " + mascota.getNombre() + "."
            );

            refrescarPantalla();
        }catch (Exception e){
            mostrarError(e.getMessage());
        }
    }

    /**
     * Se entrega medicina a la mascota seleccionada y se refresca la información visual.
     */
    private void darMedicina(){
        try{
            Mascota mascota = obtenerMascotaSeleccionada();

            if(mascota == null){
                return;
            }

            tienda.darMedicina(mascota);

            registrarAccion(
                    "Medicina",
                    "Le diste medicina a " + mascota.getNombre() + "."
            );

            refrescarPantalla();
        }catch (Exception e){
            mostrarError(e.getMessage());
        }
    }

    /**
     * Se vende la mascota seleccionada y se actualiza el presupuesto de la tienda.
     */
    private void venderMascota(){
        try{
            Mascota mascota = obtenerMascotaSeleccionada();

            if (mascota == null){
                return;
            }

            tienda.venderMascota(mascota, 700);

            registrarAccion(
                    "Venta",
                    "Vendiste a " + mascota.getNombre() + " por $700."
            );

            refrescarPantalla();
        }catch (Exception e){
            mostrarError(e.getMessage());
        }
    }

    /**
     * Se refrescan los datos principales de la interfaz después de una acción.
     * Actualiza presupuesto, stock de suministros y lista de mascotas.
     */
    private void refrescarPantalla(){
        ventana.actualizarPresupuesto(tienda.getPresupuesto());

        ventana.getInventarioPanel().actualizarStockSuministros(tienda.getInventario().getSuministros());

        ventana.getInventarioPanel().refrescarListaMascotas(tienda.getMascotas());
    }

    /**
     * Se muestra un mensaje de error en una ventana emergente.
     * @param mensaje El texto que se mostrará al usuario.
     */
    private void mostrarError(String mensaje){
        JOptionPane.showMessageDialog(
                ventana,
                mensaje,
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }

    /**
     * Se registra una acción del sistema dentro del panel de alertas.
     * @param tipoAccion La categoría de la acción realizada.
     * @param mensaje El detalle de la acción que se mostrará al usuario.
     */
    private void registrarAccion(String tipoAccion, String mensaje){
        ventana.getPanelAlertas().actualizarAlerta("Sistema", tipoAccion, mensaje);
    }

    /**
     * Se inicia el sistema de llegada aleatoria de clientes.
     */
    private void  iniciarLlegadaClienteAleatorio(){
        programarLlegadaClienteNuevo();
    }

    /**
     * Se obtiene el precio de venta asociado a cada tipo de mascota.
     * @param tipoMascota El tipo de mascota cuyo precio se desea consultar.
     * @return El precio de venta configurado para ese tipo de mascota.
     */
    private int obtenerPrecioAnimal(TipoMascota tipoMascota){
        return switch (tipoMascota){
            case PERRO -> 700;
            case GATO -> 650;
            case PAJARO -> 450;
            case PEZ -> 300;
        };
    }

    /**
     * Se procesa la llegada de un cliente virtual.
     * Genera el cliente, decide aleatoriamente si desea comprar y, si corresponde,
     * intenta realizar la venta de una mascota disponible.
     */
    private void procesarLlegadaCliente(){
        ClienteVirtual clienteVirtual= generarElClienteAleatorio();
        ventana.getClientePanel().mostrarCliente(clienteVirtual);
        registrarAccion("Cliente", "Llegó "+ clienteVirtual.getNombre()+ " quiere una mascota tipo "+ clienteVirtual.getTipoMascotaNecesitada()+ " con este presupuesto: $"+ clienteVirtual.getPresupuesto());
        boolean quiereComprar= random.nextBoolean();

        if(!quiereComprar){
            ventana.getClientePanel().actualizarResultados("No compró");
            registrarAccion("Cliente", clienteVirtual.getNombre()+ " decidio no comprar");
            return;
        }
        int precioVenta= obtenerPrecioAnimal(clienteVirtual.getTipoMascotaNecesitada());
        boolean ventaExitosa= tienda.venderMascotaACliente(clienteVirtual, precioVenta);

        if(ventaExitosa){
            ventana.getClientePanel().actualizarResultados("La compra ha sido exitosa");
            registrarAccion("Venta", clienteVirtual.getNombre()+ " ha comprado una mascota tipo "+ clienteVirtual.getTipoMascotaNecesitada()+ " por "+ precioVenta);
        }
        else {
            ventana.getClientePanel().actualizarResultados("No hubo compra");
            registrarAccion("Cliente", clienteVirtual.getNombre()+ " no pudo realizar su compra por falta de animales o presupuesto");
        }
        refrescarPantalla();
    }

    /**
     * Se programa la llegada del siguiente cliente con un tiempo aleatorio.
     * Cada vez que llega un cliente, se procesa su visita y se agenda uno nuevo.
     */
    private void programarLlegadaClienteNuevo(){
        int tiempoAleatorio= 30000+ random.nextInt(30001);

        timerClientes= new Timer(tiempoAleatorio, e ->{
            procesarLlegadaCliente();
            timerClientes.stop();
            programarLlegadaClienteNuevo();
        });
        timerClientes.setRepeats(false);
        timerClientes.start();
    }

    /**
     * Se genera un cliente virtual con nombre, tipo de mascota buscada y
     * presupuesto elegidos aleatoriamente.
     * @return Un nuevo ClienteVirtual listo para ser procesado por el controlador.
     */
    private ClienteVirtual generarElClienteAleatorio(){
        String[] nombres= { "Joaquin", "Alan", "Bastian", "Matias", "Gabriel", "Francisco", "Eduardo", "Maite", "Sergio", "Daniela", "Mirella", "Abelardo", "Maria", "Sebastian", "Mateo", "Simon", "Audilia", "Valentina", "Amanda", "Lucas"};

        TipoMascota[] tipos= TipoMascota.values();
        String nombre= nombres[random.nextInt(nombres.length)];
        TipoMascota tipoBuscado= tipos[random.nextInt(tipos.length)];
        int presupuestoCliente= 300+ random.nextInt(700);

        return new ClienteVirtual(nombre, tipoBuscado, presupuestoCliente);
    }
}
