public class NewsResourceFactory extends ResourceFactory {
    protected Observable createResource() {
        return new NewsResource();
    }
}
