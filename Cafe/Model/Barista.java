package Model;

import Cafe.Observer.observer;

public class Barista implements observer {
        private String nombre;
        private String id;

    public Barista(String nombre, String id){
        this.nombre = nombre;
        this.id = id;
    }
    @Override
    public void update(Lote lote) {
        System.out.println("Notificacion para" + nombre + ":");
        System.out.println("¡¡Nuevo lote disponible!!" + lote);
    }
    @Override
    public String toString(){
        return "Barista{" + "nombre: " + nombre + "," + "id: " + id + "}.";
    }
    
}
