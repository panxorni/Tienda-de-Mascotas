package tiendamascotas.logica.patrones.observer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
// Utilizar Mockito para crear "dobles de prueba" (mocks) de la interfaz gráfica.
// Esto permite evaluar la lógica interna del patrón de forma completamente aislada,
// evitando instanciar paneles reales de Swing que harían la prueba lenta e inestable
public class SujetoObservableTest {

    /**
     * Proveer una clase concreta de prueba (Dummy) que hereda de SujetoObservable.
     * Al ser SujetoObservable abstracta, requiere esta clase interna
     * para poder instanciarla y exponer el método protegido notificarObservadores.
     */
    private static class DummyMascota extends SujetoObservable {
        public void emitirAlerta(String nombre, String tipo, String mensaje) {
            // Llamar al método protegido a evaluar
            notificarObservadores(nombre, tipo, mensaje);
        }
    }

    private DummyMascota mascotaPrueba;
    private ObservadorMascotas observadorMock1;
    private ObservadorMascotas observadorMock2;

    @BeforeEach
    void setUp() {
        // Inicializar el sujeto observable
        mascotaPrueba = new DummyMascota();

        // Crear los "dobles de prueba" (mocks) de los observadores
        // para evitar depender de la interfaz gráfica real
        observadorMock1 = mock(ObservadorMascotas.class);
        observadorMock2 = mock(ObservadorMascotas.class);
    }

    @Test
    void testAgregarObservadorYNotificar() {
        // 1. Preparar y ejecutar (Act)
        mascotaPrueba.agregarObservador(observadorMock1);
        mascotaPrueba.emitirAlerta("Firulais", "Hambre", "Quiero queque");

        // 2. Verificar (Assert)
        // Comprobar que, al emitir la alerta, el mock reciba el método actualizarAlerta
        // exactamente 1 vez con los parámetros correctos.
        verify(observadorMock1, times(1)).actualizarAlerta("Firulais", "Hambre", "Quiero queque");
    }

    @Test
    void testEliminarObservador() {
        // 1. Preparar y ejecutar (Act)
        mascotaPrueba.agregarObservador(observadorMock1);
        mascotaPrueba.eliminarObservador(observadorMock1);

        // Emitir la alerta DESPUÉS de eliminar al observador
        mascotaPrueba.emitirAlerta("Michi", "Salud", "Enfermo");

        // 2. Verificar (Assert)
        // Comprobar que el observador NUNCA reciba la notificación
        verify(observadorMock1, never()).actualizarAlerta(anyString(), anyString(), anyString());
    }

    @Test
    void testNotificarMultiplesObservadores() {
        // 1. Preparar y ejecutar (Act)
        mascotaPrueba.agregarObservador(observadorMock1);
        mascotaPrueba.agregarObservador(observadorMock2);
        mascotaPrueba.emitirAlerta("Pancho", "Salud", "No suben las notas de lógica");

        // 2. Verificar (Assert)
        // Comprobar que ambos observadores reciban el aviso
        verify(observadorMock1, times(1)).actualizarAlerta("Pancho", "Salud", "No suben las notas de lógica");
        verify(observadorMock2, times(1)).actualizarAlerta("Pancho", "Salud", "No suben las notas de lógica");
    }
}