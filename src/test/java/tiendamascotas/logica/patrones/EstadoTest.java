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
}