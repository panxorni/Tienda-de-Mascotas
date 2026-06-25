package tiendamascotas.logica.patrones.state;

import tiendamascotas.logica.Mascota;

public class EstadoFeliz implements EstadoMascota{
    @Override
    public void alimentar(Mascota mascota){
        System.out.println(mascota.getNombre()+ " no tiene hambre.");
    }

    @Override
    public void jugar(Mascota mascota){
        System.out.println(mascota.getNombre()+ " juega.");
    }

    @Override
    public String getNombre(){
        return "Feliz";
    }
}