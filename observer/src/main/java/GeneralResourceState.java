public class GeneralResourceState implements State {
    private final String value;

    public GeneralResourceState(String value) {
        this.value = value;
    }

    public final String toString() {
        return this.value;
    }
}
