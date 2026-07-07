package tiendamascotas.logica.patrones.observer;

/**
 * Observador que recibe notificaciones de alertas emitidas por mascotas.
 * Implementaciones deberían actualizar su estado (por ejemplo, un panel de GUI)
 * cuando una mascota genera una alerta.
 */
public interface ObservadorMascotas {

    /**
     * Se invoca cuando una mascota emite una alerta.
     *
     * @param nombreMascota nombre de la mascota que genera la alerta
     * @param tipoAlerta tipo de alerta (por ejemplo: "hambre", "enfermedad")
     * @param mensaje mensaje adicional con detalles de la alerta
     */
    void actualizarAlerta(String nombreMascota, String tipoAlerta, String mensaje);
}