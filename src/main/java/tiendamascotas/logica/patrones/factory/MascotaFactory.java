package tiendamascotas.logica.patrones.factory;

import tiendamascotas.logica.modelo.Mascota;
import tiendamascotas.logica.patrones.observer.ObservadorMascotas;

/**
 * Clase abstracta que define el cómo crear mascotas mediante
 * el patrón Factory.
 * Permite construir distintos tipos de mascotas sin acoplar el controlador
 * a las clases concretas.
 */
public abstract class MascotaFactory {

    /**
     * Se crea una mascota concreta con el nombre indicado y, si existe,
     * se conecta con un observador para recibir alertas.
     * @param nombre El nombre asignado a la nueva mascota.
     * @param panel El observador que recibirá las alertas de la mascota.
     * @return La mascota concreta creada por la fábrica.
     */
    public abstract Mascota crearMascota(String nombre, ObservadorMascotas panel);
}
