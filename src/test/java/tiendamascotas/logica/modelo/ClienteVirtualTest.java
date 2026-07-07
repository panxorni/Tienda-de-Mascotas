package tiendamascotas.logica.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClienteVirtualTest {
    @Test
    void crearClienteDebeGuardarSusDatosCorrectamente() {
        ClienteVirtual cliente= new ClienteVirtual("Camila", TipoMascota.PERRO, 800);
        assertEquals("Camila", cliente.getNombre());
        assertEquals(TipoMascota.PERRO, cliente.getTipoMascotaNecesitada());
        assertEquals(800, cliente.getPresupuesto());
    }

    @Test
    void nombreVacioDebeLanzarExcepcion() {
        assertThrows(IllegalArgumentException.class,() -> new ClienteVirtual("", TipoMascota.GATO, 700));
    }

    @Test
    void tipoMascotaNuloDebeLanzarExcepcion() {
        assertThrows(IllegalArgumentException.class,() -> new ClienteVirtual("Matias", null, 700));
    }

    @Test
    void presupuestoNegativoDebeLanzarExcepcion() {
        assertThrows(IllegalArgumentException.class,() -> new ClienteVirtual("Valentina", TipoMascota.PEZ, -100));
    }
}
