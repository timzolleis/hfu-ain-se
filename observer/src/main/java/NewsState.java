public class NewsState implements State {
    private final String value;

    public NewsState(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
