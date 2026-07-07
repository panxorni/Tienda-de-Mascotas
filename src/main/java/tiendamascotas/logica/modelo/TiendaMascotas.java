package tiendamascotas.logica.modelo;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import tiendamascotas.logica.modelo.suministros.Inventario;
import tiendamascotas.logica.modelo.suministros.TipoSuministro;

/**
 * Clase principal del modelo que representa la tienda de mascotas.
 * Administra el presupuesto disponible, el inventario de suministros y
 * la lista de mascotas que se encuentran disponibles para la venta.
 */
public class TiendaMascotas {
    private int presupuesto;
    private List<Mascota> mascotas;
    private Inventario inventario;

    /**
     * Se inicializa una tienda con un presupuesto inicial, un inventario vacío y
     * una lista de mascotas sin elementos.
     * @param presupuestoInicial El dinero inicial disponible para comprar mascotas y suministros.
     */
    public TiendaMascotas(int presupuestoInicial){
        if (presupuestoInicial< 0){
            throw new IllegalArgumentException("El presupuesto no puede ser negativo");
        }
        this.presupuesto= presupuestoInicial;
        this.inventario= new Inventario();
        this.mascotas= new ArrayList<>();
    }

    /**
     * Se busca la primera mascota disponible que coincida con el tipo solicitado.
     * @param tipoMascota El tipo de mascota que se desea encontrar en la tienda.
     * @return La mascota encontrada, o null si no existe una mascota de ese tipo.
     */
    public Mascota buscarMascota(TipoMascota tipoMascota){
        if( tipoMascota== null){
            throw new IllegalArgumentException("el tipo de mascota no puede ser nulo");
        }
        for(Mascota mascota: mascotas){
            if(mascota.getTipo()== tipoMascota){
                return mascota;
            }
        }
        return null;
    }

    /**
     * Se intenta vender una mascota a un cliente virtual.
     * La venta se realiza solo si el cliente tiene presupuesto suficiente,
     * existe una mascota del tipo solicitado y su estado permite venderla.
     * @param clienteVirtual El cliente que desea comprar una mascota.
     * @param precioVenta El precio por el cual se venderá la mascota.
     * @return true si la venta fue exitosa, o false si no se cumplen las condiciones.
     */
    public boolean venderMascotaACliente(ClienteVirtual clienteVirtual, int precioVenta){
        if(clienteVirtual== null){
            throw  new IllegalArgumentException("el cliente no puede ser nulo");
        }
        if(precioVenta< 0){
            throw  new IllegalArgumentException("el precio de venta no puede ser negativo");
        }
        if (clienteVirtual.getPresupuesto()< precioVenta){
            return false;
        }
        Mascota mascota= buscarMascota(clienteVirtual.getTipoMascotaNecesitada());

        if (mascota== null){
            return false;
        }

        if(!mascota.getEstado().puedeVenderse()){
            return false;
        }
        venderMascota(mascota, precioVenta);
        return true;
    }

    /**
     * Se obtiene el presupuesto actual de la tienda.
     * @return El dinero disponible actualmente.
     */
    public int getPresupuesto(){
        return  presupuesto;
    }

    /**
     * Se obtiene la lista de mascotas disponibles en la tienda.
     * @return Una lista no modificable con las mascotas registradas.
     */
    public List<Mascota> getMascotas(){
        return Collections.unmodifiableList(mascotas);
    }

    /**
     * Se obtiene el inventario de suministros de la tienda.
     * @return El objeto Inventario utilizado para administrar los suministros.
     */
    public Inventario getInventario(){
        return inventario;
    }

    /**
     * Se valida que la tienda tenga presupuesto suficiente para cubrir un monto.
     * @param monto La cantidad de dinero que se desea comparar con el presupuesto actual.
     */
    public void validarSaldo(int monto){
        if(presupuesto< monto){
            throw new IllegalArgumentException("no hay presupuesto suficiente");
        }
    }

    /**
     * Se compra una mascota para agregarla al inventario de animales de la tienda.
     * El precio de compra se descuenta del presupuesto disponible.
     * @param mascota La mascota que se agregará a la tienda.
     * @param precioCompra El precio pagado por la mascota.
     */
    public void comprarMascota(Mascota mascota, int precioCompra){
        if(mascota== null){
            throw  new IllegalArgumentException("la mascota no puede ser nula");
        }
        if(precioCompra<0){
            throw  new IllegalArgumentException("no puede comprar o que te regalen una mascota por un número negativo ");
        }
        validarSaldo(precioCompra);
        mascotas.add(mascota);
        presupuesto= presupuesto- precioCompra;
    }

    /**
     * Se vende una mascota registrada en la tienda y se agrega el precio de venta
     * al presupuesto disponible.
     * @param mascota La mascota que será retirada de la tienda.
     * @param precioVenta El dinero recibido por la venta.
     */
    public void venderMascota(Mascota mascota, int precioVenta){
        if(mascota== null){
            throw  new IllegalArgumentException("la mascota no puede ser nula");
        }

        if(!mascotas.contains(mascota)){
            throw new IllegalArgumentException("la mascota no pertenece a la tienda");
        }
        if(precioVenta<0){
            throw  new IllegalArgumentException("no puede vender o regalar una mascota por un número negativo ");
        }
        mascotas.remove(mascota);
        presupuesto= presupuesto+ precioVenta;
    }

    /**
     * Se consume una cantidad específica de suministros desde el inventario.
     * @param tipo El tipo de suministro que se utilizará.
     * @param cantidad La cantidad de unidades que se descontará del inventario.
     */
    public void usarSuministro(TipoSuministro tipo, int cantidad ){
        inventario.usarSuministro(tipo, cantidad);
    }

    /**
     * Se compran suministros para la tienda y se descuenta su costo total del presupuesto.
     * Luego, las unidades compradas se agregan al inventario.
     * @param tipo El tipo de suministro que se comprará.
     * @param cantidad La cantidad de unidades que se desea comprar.
     * @param precioPorUnidad El precio individual de cada unidad de suministro.
     */
    public void comprarSuministro(TipoSuministro tipo, int cantidad, int precioPorUnidad){
        if (cantidad<=0){
            throw new IllegalArgumentException("la cantidad tiene que ser mayor que 0");
        }
        if (precioPorUnidad<=0){
            throw new IllegalArgumentException("el precio por unidad tiene que ser mayor que 0");
        }
        int costoTotal= cantidad * precioPorUnidad;
        validarSaldo(costoTotal);
        presupuesto=presupuesto- costoTotal;
        inventario.agregarSuministro(tipo, cantidad);
    }

    /**
     * Se alimenta una mascota de la tienda.
     * Al ejecutarse, consume una unidad del tipo de comida correspondiente a la mascota.
     * @param mascota La mascota que recibirá alimento.
     */
    public void alimentarMascota(Mascota mascota){
        validarMascotaEnTienda(mascota);
        inventario.usarSuministro(mascota.getTipoComida(), 1);
        mascota.alimentar();
    }

    /**
     * Se juega con una mascota de la tienda.
     * @param mascota La mascota con la que se realizará la interacción.
     */
    public void jugarConMascota(Mascota mascota){
        validarMascotaEnTienda(mascota);
        mascota.jugar();
    }

    /**
     * Se limpia el hábitat de una mascota registrada en la tienda.
     * @param mascota La mascota cuyo hábitat será limpiado.
     */
    public void limpiarHabitat(Mascota mascota){
        validarMascotaEnTienda(mascota);
        mascota.limpiarHabitat();
    }

    /**
     * Se entrega medicina a una mascota de la tienda.
     * Al ejecutarse, consume una unidad de medicamentos del inventario.
     * @param mascota La mascota que recibirá el tratamiento.
     */
    public void darMedicina(Mascota mascota){
        validarMascotaEnTienda(mascota);
        inventario.usarSuministro(TipoSuministro.MEDICAMENTOS, 1);
        mascota.darMedicina();
    }

    /**
     * Se valida que una mascota no sea nula y que pertenezca a la tienda.
     * @param mascota La mascota que se desea validar antes de interactuar con ella.
     */
    private void validarMascotaEnTienda(Mascota mascota){
        if (mascota == null){
            throw new IllegalArgumentException("La mascota no puede ser nula");
        }
        if (!mascotas.contains(mascota)){
            throw new IllegalArgumentException("La mascota no pertenece a la tienda");
        }
    }
}
