package tiendamascotas.logica.modelo;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import tiendamascotas.logica.modelo.suministros.Inventario;
import tiendamascotas.logica.modelo.suministros.TipoSuministro;


public class TiendaMascotas {
    private int presupuesto;
    private List<Mascota> mascotas;
    private Inventario inventario;
    public TiendaMascotas(int presupuestoInicial){
        if (presupuestoInicial< 0){
            throw new IllegalArgumentException("El presupuesto no puede ser negativo");
        }
        this.presupuesto= presupuestoInicial;
        this.inventario= new Inventario();
        this.mascotas= new ArrayList<>();
    }

    public int getPresupuesto(){
        return  presupuesto;
    }
    public List<Mascota> getMascotas(){
        return Collections.unmodifiableList(mascotas);
    }
    public Inventario getInventario(){
        return inventario;
    }
    public void validarSaldo(int monto){
        if(presupuesto< monto){
            throw new IllegalArgumentException("no hay presupuesto suficiente");
        }
    }

    public void comprarMascota(Mascota mascota, int precioCompra){
        if(mascota== null){
            throw  new IllegalArgumentException("la mascota no puede ser nula");
        }
        if(precioCompra<0){
            throw  new IllegalArgumentException("no puede comprar o que te regalen una mascota por un número negativo ");
        }
        validarSaldo(precioCompra);
        mascotas.add(mascota);
        presupuesto= presupuesto- precioCompra;
    }

    public void venderMascota(Mascota mascota, int precioVenta){
        if(mascota== null){
            throw  new IllegalArgumentException("la mascota no puede ser nula");
        }

        if(!mascotas.contains(mascota)){
            throw new IllegalArgumentException("la mascota no pertenece a la tienda");
        }
        if(precioVenta<0){
            throw  new IllegalArgumentException("no puede vender o regalar una mascota por un número negativo ");
        }
        mascotas.remove(mascota);
        presupuesto= presupuesto+ precioVenta;
    }

    public void usarSuministro(TipoSuministro tipo, int cantidad ){
        inventario.usarSuministro(tipo, cantidad);
    }

    public void comprarSuministro(TipoSuministro tipo, int cantidad, int precioPorUnidad){
        if (cantidad<=0){
            throw new IllegalArgumentException("la cantidad tiene que ser mayor que 0");
        }
        if (precioPorUnidad<=0){
            throw new IllegalArgumentException("el precio por unidad tiene que ser mayor que 0");
        }
        int costoTotal= cantidad * precioPorUnidad;
        validarSaldo(costoTotal);
        presupuesto=presupuesto- costoTotal;
        inventario.agregarSuministro(tipo, cantidad);
    }
}
