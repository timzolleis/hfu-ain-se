import java.io.IOException;

public class Observer {
    private State state;


    public void update(final Observable observable){
        this.state = observable.getState();
    }

    public void registerAt(final Observable observable) {
        observable.addObserver(this);
    }

    public void unregisterAt(final Observable observable) {
        observable.removeObserver(this);

    }

    public State getState() {
        return this.state;
    }
}

