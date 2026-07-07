package tiendamascotas.logica.patrones.state;

/**
 * Estado que representa una mascota con hambre.
 * Al alimentarla se restaura su hambre y cambia su estado a feliz.
 */
public class EstadoHambriento implements EstadoMascota {

    /**
     * Nombre legible del estado.
     * @return "Hambriento"
     */
    @Override
    public String getNombre(){
        return "Hambriento";
    }

    /**
     * Indica si la mascota puede ser vendida en este estado.
     * @return false porque una mascota hambrienta no puede venderse
     */
    @Override
    public boolean puedeVenderse() {
        return false;
    }

    /**
     * Descripción breve del estado.
     * @return descripción del estado
     */
    @Override
    public String getDescripcion() {
        return "La mascota tiene hambre";
    }

    /**
     * Indica si la mascota puede jugar estando hambrienta.
     * @return false porque no está en condiciones de jugar
     */
    @Override
    public boolean puedeJugar() {
        return false;
    }
}
