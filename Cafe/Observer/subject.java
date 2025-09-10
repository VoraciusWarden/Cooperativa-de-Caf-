package Cafe.Observer;

import Cafe.model.Lote;

public interface subject {
    void addObserver(Observer);
    void removeObserver(Observer);
    void notifyObervers(Lote lote);
    
}
