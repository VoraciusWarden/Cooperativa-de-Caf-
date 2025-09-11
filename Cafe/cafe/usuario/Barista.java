package cafe.usuario;

import cafe.cooperativacafe.CooperativaCafe;
import cafe.modelo.Lote;
import cafe.observer.Observer;

public class Barista implements Observer {
    private int id;
    private String nombre;

    public Barista(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void update(Lote lote) {
        System.out.println("\nNotificación para el barista " + nombre + ": ¡¡¡Nuevo lote disponible!!!\n");
        System.out.println(lote);
    }

    public void suscribirse(CooperativaCafe cooperativa) {
        cooperativa.addObserver(this);
        System.out.println(nombre + " ahora está suscrito a la cooperativa.");
    }

    public void anularSuscripcion(CooperativaCafe cooperativa) {
        cooperativa.removeObserver(this);
        System.out.println(nombre + " ha anulado su suscripción a la cooperativa.");
    }
}
