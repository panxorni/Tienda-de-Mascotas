package tiendamascotas.logica;

public class GatoFactory extends MascotaFactory{
    @Override
    public Mascota crearMascota(String nombre) {
        Mascota gato = new Gato(nombre);
        /*Inicializar estados de la mascota aquí cuando este implementado el patron state
        Por ejemplo:
        gato.setState(new ...)
        gato.setFelicidad(...)
        gato.setSalud
        entre otros
        * */
        return gato;
    }
}
