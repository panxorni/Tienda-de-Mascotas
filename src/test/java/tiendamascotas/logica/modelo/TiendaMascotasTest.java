package tiendamascotas.logica.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tiendamascotas.logica.modelo.mascotas.Gato;
import tiendamascotas.logica.modelo.mascotas.Perro;
import tiendamascotas.logica.modelo.suministros.TipoSuministro;
import static org.junit.jupiter.api.Assertions.*;

public class TiendaMascotasTest {
    private TiendaMascotas tienda;

    /**
     * Antes de cada test se crea una tienda nueva
     * con un presupuesto de $10000.
     */
    @BeforeEach
    void setUp() {
        tienda= new TiendaMascotas(10000);
    }

    @Test
    void tiendaDebeComenzarConPresupuestoInicial() {
        assertEquals(10000 , tienda.getPresupuesto());
    }

    @Test
    void tiendaDebeComenzarSinMascotas() {
        assertTrue(tienda.getMascotas().isEmpty());
    }

    @Test
    void comprarMascotaDebeAgregarlaYDescontarPresupuesto() {
        Mascota perro= new Perro("Kota");

        tienda.comprarMascota(perro , 500);

        assertEquals(1 , tienda.getMascotas().size());
        assertEquals(9500 , tienda.getPresupuesto());
    }

    @Test
    void venderMascotaDebeEliminarlaYAumentarPresupuesto() {
        Mascota perro= new Perro("Kota");

        tienda.comprarMascota(perro , 500);
        tienda.venderMascota(perro , 700);

        assertTrue(tienda.getMascotas().isEmpty());
        assertEquals(10200, tienda.getPresupuesto());
    }

    @Test
    void comprarMascotaSinSaldoDebeLanzarExcepcion() {
        Mascota perro= new Perro("Kota");

        assertThrows(
                IllegalArgumentException.class,
                () -> tienda.comprarMascota(perro , 20000)
        );
    }

    @Test
    void buscarMascotaDebeEncontrarElTipoSolicitado() {
        Mascota perro= new Perro("Kota");
        Mascota gato= new Gato("Kira");

        tienda.comprarMascota(perro, 500);
        tienda.comprarMascota(gato, 450);

        Mascota mascotaEncontrada= tienda.buscarMascota(TipoMascota.GATO);
        assertEquals(gato, mascotaEncontrada);
    }

    @Test
    void buscarMascotaInexistenteDebeRetornarNull() {
        Mascota mascotaEncontrada= tienda.buscarMascota(TipoMascota.PEZ);

        assertNull(mascotaEncontrada);
    }

    @Test
    void clienteConPresupuestoSuficienteDebeComprarMascota() {
        Mascota perro= new Perro("Kota");
        tienda.comprarMascota(perro, 500);
        ClienteVirtual cliente= new ClienteVirtual("Camila", TipoMascota.PERRO, 1000);

        boolean ventaExitosa= tienda.venderMascotaACliente(cliente , 700);

        assertTrue(ventaExitosa);
        assertTrue(tienda.getMascotas().isEmpty());
        assertEquals(10200, tienda.getPresupuesto());
    }

    @Test
    void clienteSinPresupuestoSuficienteNoDebeComprar() {
        Mascota perro= new Perro("Kota");

        tienda.comprarMascota(perro, 500);

        ClienteVirtual cliente= new ClienteVirtual("Camila", TipoMascota.PERRO, 300);

        boolean ventaExitosa= tienda.venderMascotaACliente(cliente, 700);

        assertFalse(ventaExitosa);
        assertEquals(1, tienda.getMascotas().size());
    }

    @Test
    void clienteNoComprarSiNoExisteElTipoBuscado() {
        Mascota gato= new Gato("Kira");

        tienda.comprarMascota(gato, 450);

        ClienteVirtual cliente= new ClienteVirtual("Matias", TipoMascota.PERRO, 1000);

        boolean ventaExitosa= tienda.venderMascotaACliente(cliente, 700);

        assertFalse(ventaExitosa);
        assertEquals(1, tienda.getMascotas().size());
    }

    @Test
    void comprarSuministroDebeAumentarStockYDescontarPresupuesto() {
        tienda.comprarSuministro(TipoSuministro.COMIDA_PERRO, 5, 100);

        assertEquals(5, tienda.getInventario().consultarCantidad(TipoSuministro.COMIDA_PERRO));
        assertEquals(9500, tienda.getPresupuesto());
    }

    @Test
    void alimentarMascotaDebeConsumirUnaUnidadDeComida() {
        Mascota perro= new Perro("Kota");

        tienda.comprarMascota(perro, 500);
        tienda.comprarSuministro(TipoSuministro.COMIDA_PERRO, 5, 100);
        tienda.alimentarMascota(perro);

        assertEquals(4, tienda.getInventario().consultarCantidad(TipoSuministro.COMIDA_PERRO));
    }
}
