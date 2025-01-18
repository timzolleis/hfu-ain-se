public abstract class ResourceFactory {
    public final Observable create() {
        return createResource();
    }

    protected abstract Observable createResource();
}
