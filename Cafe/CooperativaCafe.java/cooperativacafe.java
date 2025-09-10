package CooperativaCafe;

import Cafe.model.Lote;
import Cafe.Observer.observer;
import Cafe.Observer.Subject;
import java.util.ArrayList;
import java.util.List;

public class cooperativacafe implements Subject {
    private List<Observer.observer> observers;
    public cooperativacafe() {
        observers = new ArrayList<>();
    }

    @Override
    public void addObserver (observer o) {
        observers.add(o);
    }

    public void removeObserver(observer o){
        observers.remove(o);
    }

    public void notifyObervers(Lote lote) for (observer o : observers){
        o.update(lote);
     
    }
    public void 
    
}
