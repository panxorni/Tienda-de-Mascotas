package tiendamascotas.logica.patrones.state;

public interface EstadoMascota {
    String getNombre();
    String getDescripcion();
    boolean puedeJugar();
    boolean puedeVenderse();
}
