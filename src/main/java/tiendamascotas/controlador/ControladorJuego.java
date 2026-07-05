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

//Esta Clase conecta la interfaz con la logica.
public class ControladorJuego {
    private TiendaMascotas tienda;
    private VentanaPrincipal ventana;
    private Random random= new Random();
    private Timer timerClientes;

    public ControladorJuego(TiendaMascotas tienda, VentanaPrincipal ventana){
        this.tienda=tienda;
        this.ventana=ventana;

        conectarEventos();
        refrescarPantalla();
        iniciarLlegadaClienteAleatorio();
    }

    //metodo que contiene todos los listeners para cada acción
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

    //metodo para poder comprar una mascota en el ActionEvent con un factory
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

    //metodo para comprar suministros de tipo correspondiente
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

    //metodo para obtener la mascota seleccionada para todos los metodos que lo necesiten
    private Mascota obtenerMascotaSeleccionada(){
        int indice = ventana.getInventarioPanel().getIndiceMascotaSeleccionada();

        if(indice == -1){
            mostrarError("Debe seleccionar una mascota del inventario");
            return null;
        }
        return tienda.getMascotas().get(indice);
    }

    //metodo alimenta a la mascota seleccionada
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

    //metodo juega con la mascota seleccionada
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

    //metodo limpia el habitat de la mascota seleccionada
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

    //metodo da medicina a la mascota seleccionada
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

    //metodo vende mascota seleccionada
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

    //metodo usado para refrescar la pantalla después de cualquier acción
    private void refrescarPantalla(){
        ventana.actualizarPresupuesto(tienda.getPresupuesto());

        ventana.getInventarioPanel().actualizarStockSuministros(tienda.getInventario().getSuministros());

        ventana.getInventarioPanel().refrescarListaMascotas(tienda.getMascotas());
    }

    //metodo para mostrar un mensaje de error formateado
    private void mostrarError(String mensaje){
        JOptionPane.showMessageDialog(
                ventana,
                mensaje,
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }

    //metodo para registrar cada acción, se utiliza después de cada acción ejecutada correctamente
    private void registrarAccion(String tipoAccion, String mensaje){
        ventana.getPanelAlertas().actualizarAlerta("Sistema", tipoAccion, mensaje);
    }

    /**
     * Inicia la llegada de clientes al ejecutar
     */
    private void  iniciarLlegadaClienteAleatorio(){
        programarLlegadaClienteNuevo();
    }

    /**
     * Obtiene el precio de cada mascota
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
     * Procesa los datos del cliente al llegar, decide
     * aleatoriamente si quiere comprar o no
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
     * Esta parte se encarga de programar cada cuanto llega un nuevo cliente
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
     * se genera un cliente con alguno de los nombres dentro de la lista,
     * tambien elige aleatoriamente una mascota la cual decida comprar el
     * cliente y su presupuesto
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