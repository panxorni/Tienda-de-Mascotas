package tiendamascotas.logica.modelo;

import org.junit.jupiter.api.Test;
import tiendamascotas.logica.modelo.mascotas.Perro;
import tiendamascotas.logica.patrones.state.EstadoFeliz;
import tiendamascotas.logica.patrones.state.EstadoHambriento;
import tiendamascotas.logica.patrones.state.EstadoSaludable;

import static org.junit.jupiter.api.Assertions.*;

public class MascotaTest {

    @Test
    void mascotaNaceConValoresInicialesCorrectos(){
        Mascota mascota = new Perro("Firulais");

        assertEquals("Firulais", mascota.getNombre());
        assertEquals(100, mascota.getFelicidad());
        assertEquals(100, mascota.getSalud());
        assertEquals(0, mascota.getHambre());
        assertInstanceOf(EstadoSaludable.class, mascota.getEstado());
    }

    @Test
    void alimentarReduceHambreYAumentaFelicidadSinSalirDeLimites(){
        Mascota mascota = new Perro("Firulais");

        mascota.setHambre(20);
        mascota.setFelicidad(95);

        mascota.alimentar();

        assertEquals(0, mascota.getHambre());
        assertEquals(100, mascota.getFelicidad());
    }

    @Test
    void jugarAumentaFelicidadYAumentaHambreSiPuedeJugar(){
        Mascota mascota = new Perro("Firulais");

        mascota.setFelicidad(50);
        mascota.setHambre(20);

        mascota.jugar();

        assertEquals(65, mascota.getFelicidad());
        assertEquals(30, mascota.getHambre());
    }

    @Test
    void jugarNoCambiaValoresSiMascotaEstaHambrienta(){
        Mascota mascota = new Perro("Firulais");

        mascota.setFelicidad(50);
        mascota.setHambre(90);

        mascota.jugar();

        assertEquals(50, mascota.getFelicidad());
        assertEquals(90, mascota.getHambre());
        assertInstanceOf(EstadoHambriento.class, mascota.getEstado());
    }

    @Test
    void limpiarHabitatAumentaSaludYFelicidad(){
        Mascota mascota = new Perro("Firulais");

        mascota.setSalud(50);
        mascota.setFelicidad(50);

        mascota.limpiarHabitat();

        assertEquals(60, mascota.getSalud());
        assertEquals(55, mascota.getFelicidad());
    }

    @Test
    void darMedicinaAumentaSaludYReduceFelicidad(){
        Mascota mascota = new Perro("Firulais");

        mascota.setSalud(50);
        mascota.setFelicidad(50);

        mascota.darMedicina();

        assertEquals(75, mascota.getSalud());
        assertEquals(45, mascota.getFelicidad());
    }

    @Test
    void settersLimitanValoresEntreCeroYCien() {
        Mascota mascota = new Perro("Firulais");

        mascota.setFelicidad(150);
        mascota.setSalud(150);
        mascota.setHambre(150);

        assertEquals(100, mascota.getFelicidad());
        assertEquals(100, mascota.getSalud());
        assertEquals(100, mascota.getHambre());

        mascota.setFelicidad(-10);
        mascota.setSalud(-10);
        mascota.setHambre(-10);

        assertEquals(0, mascota.getFelicidad());
        assertEquals(0, mascota.getSalud());
        assertEquals(0, mascota.getHambre());
    }

    @Test
    void estadoCambiaAHambrientoCuandoHambreEsMayorASetenta() {
        Mascota mascota = new Perro("Firulais");

        mascota.setHambre(71);

        assertInstanceOf(EstadoHambriento.class, mascota.getEstado());
    }

    @Test
    void estadoCambiaAFelizCuandoFelicidadYSaludSonAltas() {
        Mascota mascota = new Perro("Firulais");

        mascota.setHambre(0);
        mascota.setFelicidad(90);
        mascota.setSalud(90);

        assertInstanceOf(EstadoFeliz.class, mascota.getEstado());
    }

    @Test
    void estadoCambiaASaludableCuandoNoEstaFelizNiHambrienta() {
        Mascota mascota = new Perro("Firulais");

        mascota.setHambre(20);
        mascota.setFelicidad(50);
        mascota.setSalud(50);

        assertInstanceOf(EstadoSaludable.class, mascota.getEstado());
    }
}
