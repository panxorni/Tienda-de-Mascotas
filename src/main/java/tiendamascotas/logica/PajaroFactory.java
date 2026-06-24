package tiendamascotas.logica;

public class PajaroFactory extends MascotaFactory{
    @Override
    public Mascota crearMascota(String nombre){
        Mascota pajaro=new Pajaro(nombre);
        /*Inicializar estados de la mascota aquí cuando este implementado el patron state
        Por ejemplo:
        pajaro.setState(new ...)
        pajaro.setFelicidad(...)
        pajaro.setSalud
        entre otros
        * */
        return pajaro;
    }
}
