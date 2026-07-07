package tiendamascotas.logica.patrones.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase base que mantiene una lista de observadores y facilita la notificación
 * de alertas emitidas por sujetos observables.
 */
public abstract class SujetoObservable {
    /** Lista de observadores registrados. */
    private List<ObservadorMascotas> observadores = new ArrayList<>();

    /**
     * Registra un observador para recibir alertas.
     * @param observador observador a registrar; no debe ser null
     */
    public void agregarObservador(ObservadorMascotas observador) {
        observadores.add(observador);
    }

    /**
     * Elimina un observador registrado para que deje de recibir alertas.
     * @param observador observador a eliminar
     */
    public void eliminarObservador(ObservadorMascotas observador) {
        observadores.remove(observador);
    }

    /**
     * Notifica a todos los observadores registrados sobre una alerta emitida por el sujeto.
     * @param nombreMascota nombre de la mascota que generó la alerta
     * @param tipoAlerta tipo de alerta generada
     * @param mensaje mensaje adicional con detalles de la alerta
     */
    protected void notificarObservadores(String nombreMascota, String tipoAlerta, String mensaje) {
        for (ObservadorMascotas obs : observadores) {
            obs.actualizarAlerta(nombreMascota, tipoAlerta, mensaje);
        }
    }
}