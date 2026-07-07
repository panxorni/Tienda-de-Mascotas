package tiendamascotas.logica.patrones.state;


/**
 * Estado que representa una mascota satisfecha y en buen ánimo.
 * En este estado la mascota no tiene hambre, puede jugar y puede venderse.
 */
public class EstadoFeliz implements EstadoMascota {

    /**
     * Nombre legible del estado.
     * @return "Feliz"
     */
    @Override
    public String getNombre(){
        return "Feliz";
    }

    /**
     * Indica si la mascota puede ser vendida estando en este estado.
     * @return true si puede venderse
     */
    @Override
    public boolean puedeVenderse() {
        return true;
    }

    /**
     * Descripción breve del estado.
     * @return descripción del estado
     */
    @Override
    public String getDescripcion() {
        return "La mascota esta feliz";
    }

    /**
     * Indica si la mascota puede jugar estando en este estado.
     * @return true si puede jugar
     */
    @Override
    public boolean puedeJugar() {
        return true;
    }

}