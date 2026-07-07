package tiendamascotas.logica.modelo;

/**
 * Representa un cliente que visita la tienda buscando una mascota.
 * Contiene el nombre del cliente, el tipo de mascota requerido y el
 * presupuesto disponible para la compra.
 */

public class ClienteVirtual {
    private String nombre;
    private TipoMascota tipoMascotaNecesitada;
    private int presupuesto;

    /**
     * Crea un cliente virtual.
     *
     * @param nombre nombre del cliente; no debe ser nulo ni vacío
     * @param tipoMascotaNecesitada tipo de mascota requerida; no debe ser nulo
     * @param presupuesto presupuesto disponible (entero); debe ser mayor o igual a 0
     */

    public ClienteVirtual(String nombre, TipoMascota tipoMascotaNecesitada, int presupuesto){
        if(nombre== null || nombre.trim().isEmpty()){
            throw new IllegalArgumentException("el nombre no puede ser vacio");
        }
        if (tipoMascotaNecesitada == null) {
            throw new IllegalArgumentException("debe existir un tipo de mascota que se requiere");
        }
        if (presupuesto < 0) {
            throw  new IllegalArgumentException("el presupuesto no puede ser negativo");
        }
        this.nombre= nombre;
        this.tipoMascotaNecesitada= tipoMascotaNecesitada;
        this.presupuesto= presupuesto;
    }

    /**
     * Obtiene el presupuesto disponible del cliente.
     * @return el presupuesto disponible (entero)
     */
    public int getPresupuesto() {
        return presupuesto;
    }

    /**
     * Obtiene el tipo de mascota requerido por el cliente.
     * @return el tipo de mascota requerida
     */
    public TipoMascota getTipoMascotaNecesitada() {
        return tipoMascotaNecesitada;
    }

    /**
     * Obtiene el nombre del cliente.
     * @return el nombre del cliente
     */
    public String getNombre() {
        return nombre;
    }
}