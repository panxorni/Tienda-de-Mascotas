package tiendamascotas.logica.patrones.state;

import tiendamascotas.logica.modelo.Mascota;

/**
 * Interfaz que representa el estado interno de una mascota.
 * Las implementaciones modelan comportamientos específicos según el estado
 * (por ejemplo: hambrienta, feliz, saludable) y definen propiedades informativas
 * sobre la capacidad de la mascota para jugar o venderse.
 */
public interface EstadoMascota {

    /**
     * Nombre legible del estado.
     * @return nombre corto del estado (por ejemplo: "Hambriento", "Feliz")
     */
    String getNombre();

    /**
     * Descripción detallada del estado.
     * @return descripción breve del estado
     */
    String getDescripcion();

    /**
     * Indica si la mascota puede jugar estando en este estado.
     * @return true si puede jugar, false en caso contrario
     */
    boolean puedeJugar();

    /**
     * Indica si la mascota puede ser vendida estando en este estado.
     * @return true si puede venderse, false en caso contrario
     */
    boolean puedeVenderse();
}
