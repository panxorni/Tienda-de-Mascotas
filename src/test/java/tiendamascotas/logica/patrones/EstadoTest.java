package tiendamascotas.logica.patrones;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tiendamascotas.logica.modelo.Mascota;
import tiendamascotas.logica.modelo.mascotas.Perro;
import tiendamascotas.logica.patrones.state.EstadoFeliz;
import tiendamascotas.logica.patrones.state.EstadoHambriento;
import tiendamascotas.logica.patrones.state.EstadoSaludable;

import static org.junit.jupiter.api.Assertions.*;
public class EstadoTest {
    private Mascota mascota;

    /**
     * Antes de cada test se crea una mascota nueva.
     */
    @BeforeEach
    void setUp() {
        mascota= new Perro("Kota");
    }

    @Test
    void estadoFelizDebeEntregarDatosCorrectos() {
        EstadoFeliz estado= new EstadoFeliz();

        assertEquals("Feliz" , estado.getNombre());
        assertEquals("La mascota esta feliz", estado.getDescripcion());
        assertTrue(estado.puedeJugar());
        assertTrue(estado.puedeVenderse());
    }

    @Test
    void estadoHambrientoDebeEntregarDatosCorrectos() {
        EstadoHambriento estado= new EstadoHambriento();

        assertEquals("Hambriento", estado.getNombre());
        assertEquals("La mascota tiene hambre" , estado.getDescripcion());
        assertFalse(estado.puedeJugar());
        assertFalse(estado.puedeVenderse());
    }

    @Test
    void estadoSaludableDebeEntregarDatosCorrectos() {
        EstadoSaludable estado= new EstadoSaludable();

        assertEquals("Saludable" , estado.getNombre());
        assertEquals("La mascota esta en una buena condición", estado.getDescripcion());
        assertTrue(estado.puedeJugar());
        assertTrue(estado.puedeVenderse());
    }

    @Test
    void hambreAltaDebeCambiarElEstadoAHambriento() {
        mascota.setHambre(80);

        assertInstanceOf(EstadoHambriento.class , mascota.getEstado());
    }

    @Test
    void mascotaConAltaFelicidadYBuenaSaludDebeEstarFeliz() {
        mascota.setSalud(100);
        mascota.setFelicidad(100);
        mascota.setHambre(0);

        assertInstanceOf(EstadoFeliz.class, mascota.getEstado());
    }

    @Test
    void estadoInicialDebeSerSaludable() {
        // Al crearse una mascota, por defecto debe ser Saludable
        assertInstanceOf(EstadoSaludable.class, mascota.getEstado());
    }

    @Test
    void bajarHambreDesdeHambrientoDebeRegresarAFeliz() {
        // Poner hambre alta => Hambriento
        mascota.setHambre(90);
        assertInstanceOf(EstadoHambriento.class, mascota.getEstado());

        // Reducir el hambre por alimentarla => vuelve a evaluar y debe ser Feliz
        mascota.setHambre(20);
        assertInstanceOf(EstadoFeliz.class, mascota.getEstado());
    }

    @Test
    void hambreEn70NoEsHambriento() {
        // El umbral para Hambriento es > 70, por lo que 70 debe dejarla Feliz
        mascota.setHambre(70);
        assertInstanceOf(EstadoFeliz.class, mascota.getEstado());
    }

    @Test
    void hambreAltaTienePrecedenciaSobreSaludYFelicidad() {
        // Aunque salud y felicidad sean altas, el hambre >70 debe forzar Hambriento
        mascota.setSalud(100);
        mascota.setFelicidad(100);
        mascota.setHambre(75);

        assertInstanceOf(EstadoHambriento.class, mascota.getEstado());
    }

    @Test
    void saludIgual60ImpideEstadoFeliz() {
        // Salud debe ser > 60 para ser Feliz; con 60 no alcanza
        mascota.setSalud(60);
        mascota.setFelicidad(100);
        mascota.setHambre(0);

        assertInstanceOf(EstadoSaludable.class, mascota.getEstado());
    }
}
