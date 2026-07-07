package tiendamascotas.logica.modelo.suministros;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class InventarioTest {
    private Inventario inventario;

    /**
     * Antes de cada test se crea un inventario nuevo.
     */

    @BeforeEach
    void setUp() {
        inventario= new Inventario();
    }

    @Test
    void inventarioDebeComenzarEnCero() {
        assertEquals(0,inventario.consultarCantidad(TipoSuministro.COMIDA_PERRO));
    }

    @Test
    void agregarSuministroDebeAumentarElStock() {
        inventario.agregarSuministro(TipoSuministro.COMIDA_PERRO, 5);

        assertEquals(5, inventario.consultarCantidad(TipoSuministro.COMIDA_PERRO));
    }

    @Test
    void usarSuministroDebeDisminuirElStock() {
        inventario.agregarSuministro(TipoSuministro.COMIDA_GATO, 5);
        inventario.usarSuministro(TipoSuministro.COMIDA_GATO, 2);

        assertEquals(3, inventario.consultarCantidad(TipoSuministro.COMIDA_GATO));
    }

    @Test
    void agregarCantidadCeroDebeLanzarExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> inventario.agregarSuministro(TipoSuministro.COMIDA_PEZ, 0));
    }

    @Test
    void agregarCantidadNegativaDebeLanzarExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> inventario.agregarSuministro(TipoSuministro.COMIDA_PAJARO, -2));
    }

    @Test
    void usarMasStockDelDisponibleDebeLanzarExcepcion() {
        inventario.agregarSuministro(TipoSuministro.MEDICAMENTOS, 2);

        assertThrows(IllegalStateException.class, () -> inventario.usarSuministro(TipoSuministro.MEDICAMENTOS, 5));
    }

    @Test
    void getSuministrosDebeDevolverUnaCopia() {
        inventario.agregarSuministro(TipoSuministro.COMIDA_PERRO, 5);

        Map<TipoSuministro , Integer>copia= inventario.getSuministros();
        copia.put(TipoSuministro.COMIDA_PERRO, 100);
        assertEquals(5, inventario.consultarCantidad(TipoSuministro.COMIDA_PERRO));
    }
}