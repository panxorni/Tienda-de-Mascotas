package tiendamascotas.logica.patrones.factory;

import tiendamascotas.logica.modelo.Mascota;
import tiendamascotas.logica.patrones.observer.ObservadorMascotas;
public abstract class MascotaFactory {
    public abstract Mascota crearMascota(String nombre, ObservadorMascotas panel);
}
