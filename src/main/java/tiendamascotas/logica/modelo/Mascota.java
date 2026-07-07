package tiendamascotas.logica.modelo;
import tiendamascotas.logica.modelo.suministros.TipoSuministro;
import tiendamascotas.logica.patrones.observer.SujetoObservable;
import tiendamascotas.logica.patrones.state.EstadoFeliz;
import tiendamascotas.logica.patrones.state.EstadoHambriento;
import tiendamascotas.logica.patrones.state.EstadoMascota;
import tiendamascotas.logica.patrones.state.EstadoSaludable;
/**
 * Clase abstracta que representa una mascota dentro de la tienda.
 * Administra sus atributos principales, como nombre, estado, felicidad,
 * salud y hambre. También actúa como sujeto observable para emitir alertas
 * cuando alguno de sus valores llega a una condición crítica.
 */
public abstract class Mascota extends SujetoObservable {
    private String nombre;
    private EstadoMascota estado;
    private int felicidad;
    private int salud;
    private int hambre;

    /**
     * Se inicializa una mascota con su nombre, estado saludable y valores
     * iniciales de felicidad, salud y hambre.
     * @param nombre El nombre asignado a la mascota.
     */
    public Mascota(String nombre){

        this.nombre=nombre;
        this.estado= new EstadoSaludable();
        this.felicidad = 100; // Nace feliz
        this.salud = 100;     // Nace con salud max
        this.hambre = 0;      // Nace sin hambre
    }

    /**
     * Se obtiene el tipo de comida que corresponde a la mascota concreta.
     * @return El tipo de suministro que debe consumir esta mascota.
     */
    public abstract TipoSuministro getTipoComida();

    /**
     * Se obtiene el tipo general de mascota.
     * @return El tipo de mascota representado por la clase concreta.
     */
    public abstract TipoMascota getTipo();

    /**
     * Se alimenta la mascota, reduciendo su hambre y aumentando su felicidad.
     */
    public void alimentar(){
        setHambre(hambre - 30);
        setFelicidad(felicidad + 10);
    }

    /**
     * Se juega con la mascota si su estado actual lo permite.
     * Si no puede jugar, se notifica a los observadores; si puede hacerlo,
     * aumenta su felicidad y también su hambre.
     */
    public void jugar(){
        if (!estado.puedeJugar()){
            notificarObservadores(nombre, "Juego", nombre + "no quiere jugar ahora.");
            return;
        }
        setFelicidad(felicidad + 15);
        setHambre(hambre + 10);
    }

    /**
     * Se limpia el hábitat de la mascota, aumentando su salud y felicidad.
     */
    public void limpiarHabitat(){
        setSalud(salud + 10);
        setFelicidad(felicidad + 5);
    }

    /**
     * Se entrega medicina a la mascota, aumentando su salud y reduciendo
     * ligeramente su felicidad.
     */
    public void darMedicina(){
        setSalud(salud + 25);
        setFelicidad(felicidad - 5);
    }

    /**
     * Se actualiza manualmente el estado actual de la mascota.
     * @param estado El nuevo estado que se asignará a la mascota.
     */
    public void setEstado(EstadoMascota estado){
        this.estado=estado;
    }

    /**
     * Se obtiene el estado actual de la mascota.
     * @return El estado que define el comportamiento actual de la mascota.
     */
    public EstadoMascota getEstado(){
        return estado;
    }

    /**
     * Se obtiene el nombre de la mascota.
     * @return El nombre asignado a la mascota.
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * Se obtiene el nivel actual de felicidad de la mascota.
     * @return Un valor entero entre 0 y 100 que representa la felicidad.
     */
    public int getFelicidad(){
        return felicidad;
    }

    /**
     * Se obtiene el nivel actual de salud de la mascota.
     * @return Un valor entero entre 0 y 100 que representa la salud.
     */
    public int getSalud(){
        return salud;
    }

    /**
     * Se obtiene el nivel actual de hambre de la mascota.
     * @return Un valor entero entre 0 y 100 que representa el hambre.
     */
    public int getHambre(){
        return hambre;
    }

    /**
     * Se asigna un nuevo valor de felicidad, limitado entre 0 y 100.
     * Si el valor queda en nivel crítico, se notifica una alerta de aburrimiento.
     * @param felicidad El nuevo valor de felicidad que se desea asignar.
     */
    public void setFelicidad(int felicidad){
        this.felicidad = limitar(felicidad);
        actualizarEstado();
        // Detonante de aburrimiento/tristeza
        if (this.felicidad < 30) {
            notificarObservadores(this.nombre, "Aburrimiento", "¡" + this.nombre + " está muy triste y necesita jugar!");
        }
    }

    /**
     * Se asigna un nuevo valor de salud, limitado entre 0 y 100.
     * Si el valor queda en nivel crítico, se notifica una alerta de enfermedad.
     * @param salud El nuevo valor de salud que se desea asignar.
     */
    public void setSalud(int salud){
        this.salud = limitar(salud);
        actualizarEstado();
        // Detonante de enfermedad
        if (this.salud < 40) {
            notificarObservadores(this.nombre, "Enfermedad", "¡La salud de " + this.nombre + " está bajando! Necesita medicina.");
        }
    }

    /**
     * Se asigna un nuevo valor de hambre, limitado entre 0 y 100.
     * Si el valor queda en nivel crítico, se notifica una alerta de hambre.
     * @param hambre El nuevo valor de hambre que se desea asignar.
     */
    public void setHambre(int hambre){
        this.hambre = limitar(hambre);
        actualizarEstado();
        // Detonante de hambre
        if (this.hambre > 80) {
            notificarObservadores(this.nombre, "Hambre", "¡" + this.nombre + " tiene mucha hambre!");
        }
    }

    /**
     * Se actualiza el estado de la mascota según sus niveles actuales
     * de hambre, felicidad y salud.
     */
    private void actualizarEstado(){
        if(hambre>70){
            estado = new EstadoHambriento();
        } else if (felicidad > 75 && salud > 60) {
            estado = new EstadoFeliz();
        } else {
            estado = new EstadoSaludable();
        }
    }

    /**
     * Se limita un valor numérico para que se mantenga dentro del rango válido.
     * @param valor El valor que se desea ajustar.
     * @return El valor ajustado dentro del rango de 0 a 100.
     */
    private int limitar(int valor) {
        if (valor < 0){
            return 0;
        }
        if (valor > 100){
            return 100;
        }
        return valor;
    }
}
