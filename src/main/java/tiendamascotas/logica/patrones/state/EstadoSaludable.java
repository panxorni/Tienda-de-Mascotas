package tiendamascotas.logica.patrones.state;

public class EstadoSaludable implements EstadoMascota {
    @Override
    public boolean puedeJugar() {
        return true;
    }

    @Override
    public String getDescripcion() {
        return "La mascota esta en una buena condición";
    }

    @Override
    public boolean puedeVenderse() {
        return true;
    }

    @Override
    public String getNombre() {
        return "Saludable";
    }
}
