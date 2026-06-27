package tiendamascotas.logica.patrones.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class SujetoObservable {
    // Lista donde se guarda quién está escuchando las alertas
    private List<ObservadorMascotas> observadores = new ArrayList<>();

    // Método para conectar un observador (el panel) con la mascota
    public void agregarObservador(ObservadorMascotas observador) {
        observadores.add(observador);
    }

    // Método por si se necesita desconectar un observador
    public void eliminarObservador(ObservadorMascotas observador) {
        observadores.remove(observador);
    }

    // Método para notificar al observador cuando los atributos de las mascotas bajem
    protected void notificarObservadores(String nombreMascota, String tipoAlerta, String mensaje) {
        for (ObservadorMascotas obs : observadores) {
            obs.actualizarAlerta(nombreMascota, tipoAlerta, mensaje);
        }
    }
}