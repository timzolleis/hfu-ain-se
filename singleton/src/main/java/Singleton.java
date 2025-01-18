import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Singleton {
    private static int instanceCount = 1;
    private static final List<Singleton> instances = new ArrayList<>();
    private final String value;
    private final Long createdAt;

    private Singleton() {
        this.value = "I am a singleton";
        this.createdAt = System.currentTimeMillis();
    }

    public static synchronized Singleton getInstance() {
        if (instanceCount > instances.size()) {
            Singleton instance = new Singleton();
            instances.add(instance);
            return instance;
        }
        return instances.getFirst();
    }

    public static void configure(final int count) {
        instanceCount = count;
    }


    public Long getCreatedAt() {
        return createdAt;
    }

}
