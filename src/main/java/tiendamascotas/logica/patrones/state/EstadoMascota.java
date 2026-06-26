package tiendamascotas.logica.patrones.state;

import tiendamascotas.logica.modelo.Mascota;

public interface EstadoMascota {
    void alimentar(Mascota mascota);
    void jugar(Mascota mascota);
    String getNombre();
    String getDescripcion();
    boolean puedeJugar();
    boolean puedeVenderse();
}
