package tiendamascotas.logica.patrones.state;

import tiendamascotas.logica.Mascota;

public class EstadoHambriento implements EstadoMascota{
    @Override
    public void alimentar(Mascota mascota){
        mascota.setHambre(0);

        mascota.setFelicidad(mascota.getFelicidad()+10);

        mascota.setEstado(new EstadoFeliz());
    }

    @Override
    public void jugar(Mascota mascota){
        mascota.setFelicidad(mascota.getFelicidad()-5);
        System.out.println(mascota.getNombre()+ " no quiere jugar porque tiene hambre.");
    }

    @Override
    public String getNombre(){
        return "Hambriento";
    }
}
