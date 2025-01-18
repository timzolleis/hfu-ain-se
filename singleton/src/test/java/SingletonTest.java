import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingletonTest {

    @Test
    void getInstance() {
        final Singleton firstSingleton = Singleton.getInstance();
        //Wait 10ms
        try {
            Thread.sleep(10);
        } catch (InterruptedException ignored) {
        }
        final Singleton secondSingleton = Singleton.getInstance();
        assertEquals(firstSingleton, secondSingleton);
        assertEquals(firstSingleton.getCreatedAt(), secondSingleton.getCreatedAt());
    }


    @Test
    void testThreadSafe() throws InterruptedException {
        final Singleton[] singleton1 = new Singleton[1];
        final Singleton[] singleton2 = new Singleton[1];

        Thread thread1 = new Thread(() -> singleton1[0] = Singleton.getInstance());
        Thread thread2 = new Thread(() -> singleton2[0] = Singleton.getInstance());

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        assertNotNull(singleton1[0]);
        assertNotNull(singleton2[0]);
        assertEquals(singleton1[0], singleton2[0]);
    }
    @Test
    public void testMultipleInstances() {
        final Singleton firstSingleton = Singleton.getInstance();
        Singleton.configure(2);
        final Singleton secondSingleton = Singleton.getInstance();
        assertNotEquals(firstSingleton, secondSingleton);
    }


}