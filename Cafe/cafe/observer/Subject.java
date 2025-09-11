package cafe.observer;

import cafe.modelo.Lote;

public interface Subject {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers(Lote lote);
}
