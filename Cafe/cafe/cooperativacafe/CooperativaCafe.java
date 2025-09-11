package cafe.cooperativacafe;

import cafe.modelo.Lote;
import cafe.observer.Observer;
import cafe.observer.Subject;
import cafe.usuario.Barista;
import java.util.ArrayList;
import java.util.List;

public class CooperativaCafe implements Subject {
    private List<Observer> observers;  
    private List<Barista> baristasRegistrados; 
    private List<Lote> lotes; 

    public CooperativaCafe() {
        observers = new ArrayList<>();
        baristasRegistrados = new ArrayList<>();
        lotes = new ArrayList<>();
    }

    public void registrarBarista(Barista barista) {
        baristasRegistrados.add(barista);
        System.out.println("Barista registrado: " + barista.getNombre());
    }

    public List<Barista> getBaristasRegistrados() {
        return baristasRegistrados;
    }

    public List<Lote> getLotesRegistrados() {
    return lotes;
    }

    public void registrarLote(Lote lote) {
        lotes.add(lote);
        System.out.println("\n***** Nuevo lote registrado en la cooperativa *****\n");
        System.out.println(lote);
        notifyObservers(lote);
    }

    public void notificarLotesDisponibles() {
        for (Barista b : baristasRegistrados) {
            for (Lote lote : lotes) {
                b.update(lote);
            }
        }
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(Lote lote) {
        for (Observer o : observers) {
            o.update(lote);
        }
    }
}
