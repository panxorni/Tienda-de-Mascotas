package logica.patrones.observer;

public interface ObservadorMascotas {

     //Este método se ejecutará automáticamente cada vez que una mascota lance una alerta
    void actualizarAlerta(String nombreMascota, String tipoAlerta, String mensaje);
}