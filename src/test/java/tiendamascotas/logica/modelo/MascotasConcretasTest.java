package tiendamascotas.logica.modelo;

import org.junit.jupiter.api.Test;
import tiendamascotas.logica.modelo.mascotas.*;
import tiendamascotas.logica.modelo.suministros.TipoSuministro;

import static org.junit.jupiter.api.Assertions.*;
public class MascotasConcretasTest {

    @Test
    void perroTieneTipoYComidaCorrecto(){
        Perro perro = new Perro("Firulais");

        assertEquals(TipoMascota.PERRO, perro.getTipo());
        assertEquals(TipoSuministro.COMIDA_PERRO, perro.getTipoComida());
    }

    @Test
    void gatoTieneTipoYComidaCorrectos() {
        Gato gato = new Gato("Michi");

        assertEquals(TipoMascota.GATO, gato.getTipo());
        assertEquals(TipoSuministro.COMIDA_GATO, gato.getTipoComida());
    }

    @Test
    void pezTieneTipoYComidaCorrectos() {
        Pez pez = new Pez("Nemo");

        assertEquals(TipoMascota.PEZ, pez.getTipo());
        assertEquals(TipoSuministro.COMIDA_PEZ, pez.getTipoComida());
    }

    @Test
    void pajaroTieneTipoYComidaCorrectos() {
        Pajaro pajaro = new Pajaro("Piolin");

        assertEquals(TipoMascota.PAJARO, pajaro.getTipo());
        assertEquals(TipoSuministro.COMIDA_PAJARO, pajaro.getTipoComida());
    }
}
