package tiendamascotas.logica.patrones.factory;

import tiendamascotas.logica.modelo.Mascota;

public abstract class MascotaFactory {
    public abstract Mascota crearMascota(String nombre);
}
