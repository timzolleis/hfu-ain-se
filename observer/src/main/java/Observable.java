import java.util.ArrayList;
import java.util.List;

public class Observable {
    private final List<Observer> registeredObserverS = new ArrayList<>();

    private State state;

    public void addObserver(Observer observer) {
        this.registeredObserverS.add(observer);
    }

    public void removeObserver(Observer observer) {
        this.registeredObserverS.remove(observer);
    }

    private void notifyObservers() {
        for (Observer observer : registeredObserverS) {
            try {
                observer.update(this);
            } catch (Exception ignored) {

            }
        }
    }

    public State getState() {
        return this.state;
    }

    public void setState(final State state) {
        this.state = state;
        notifyObservers();
    }

}
