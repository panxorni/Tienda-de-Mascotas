package tiendamascotas.logica.patrones.state;

/**
 * Estado que representa una mascota en buena condición general.
 * En este estado la mascota puede jugar y puede venderse.
 */
public class EstadoSaludable implements EstadoMascota {
    @Override
    /**
     * Indica si la mascota puede jugar estando en este estado.
     * @return true si puede jugar
     */
    public boolean puedeJugar() {
        return true;
    }

    @Override
    /**
     * Descripción breve del estado.
     * @return descripción del estado
     */
    public String getDescripcion() {
        return "La mascota esta en una buena condición";
    }

    @Override
    /**
     * Indica si la mascota puede ser vendida estando en este estado.
     * @return true si puede venderse
     */
    public boolean puedeVenderse() {
        return true;
    }

    @Override
    /**
     * Nombre legible del estado.
     * @return "Saludable"
     */
    public String getNombre() {
        return "Saludable";
    }
}