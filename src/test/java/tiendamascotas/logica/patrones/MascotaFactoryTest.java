package tiendamascotas.logica.patrones;

import org.junit.jupiter.api.Test;
import tiendamascotas.logica.modelo.Mascota;
import tiendamascotas.logica.modelo.TipoMascota;
import tiendamascotas.logica.modelo.mascotas.*;
import tiendamascotas.logica.patrones.factory.*;
import tiendamascotas.logica.patrones.observer.ObservadorMascotas;

import static org.junit.jupiter.api.Assertions.*;
public class MascotaFactoryTest {

    @Test
    void perroFactoryCreaPerro(){
        Mascota mascota = new PerroFactory().crearMascota("Firulais", null);

        assertInstanceOf(Perro.class, mascota);
        assertEquals("Firulais", mascota.getNombre());
        assertEquals(TipoMascota.PERRO, mascota.getTipo());
    }

    @Test
    void gatoFactoryCreaGato() {
        Mascota mascota = new GatoFactory().crearMascota("Michi", null);

        assertInstanceOf(Gato.class, mascota);
        assertEquals("Michi", mascota.getNombre());
        assertEquals(TipoMascota.GATO, mascota.getTipo());
    }

    @Test
    void pezFactoryCreaPez() {
        Mascota mascota = new PezFactory().crearMascota("Nemo", null);

        assertInstanceOf(Pez.class, mascota);
        assertEquals("Nemo", mascota.getNombre());
        assertEquals(TipoMascota.PEZ, mascota.getTipo());
    }

    @Test
    void pajaroFactoryCreaPajaro() {
        Mascota mascota = new PajaroFactory().crearMascota("Piolin", null);

        assertInstanceOf(Pajaro.class, mascota);
        assertEquals("Piolin", mascota.getNombre());
        assertEquals(TipoMascota.PAJARO, mascota.getTipo());
    }

    @Test
    void factoryAgregaObservadorCuandoNoEsNull() {
        ObservadorDePrueba observador = new ObservadorDePrueba();

        Mascota mascota = new PerroFactory().crearMascota("Firulais", observador);
        mascota.setHambre(90);

        assertEquals("Firulais", observador.nombreMascota);
        assertEquals("Hambre", observador.tipoAlerta);
        assertNotNull(observador.mensaje);
    }

    @Test
    void factoryPermiteObservadorNull() {
        assertDoesNotThrow(() -> {
            Mascota mascota = new PerroFactory().crearMascota("Firulais", null);
            mascota.setHambre(90);
        });
    }

    private static class ObservadorDePrueba implements ObservadorMascotas {
        private String nombreMascota;
        private String tipoAlerta;
        private String mensaje;

        @Override
        public void actualizarAlerta(String nombreMascota, String tipoAlerta, String mensaje) {
            this.nombreMascota = nombreMascota;
            this.tipoAlerta = tipoAlerta;
            this.mensaje = mensaje;
        }
    }
}
