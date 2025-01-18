import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GeneralResourceTest {


    @Test
    public void testSelfRegistration() {
        final GeneralResource generalResource = new GeneralResource();
        final List<Observer> observers = List.of(new ResourceObserver(), new ResourceObserver());
        for (Observer observer : observers) {
            observer.registerAt(generalResource);
        }
        generalResource.setState(new GeneralResourceState("State 1"));
        for (Observer observer : observers) {
            assertEquals("State 1", observer.getState().toString());
        }
        generalResource.setState(new GeneralResourceState("State 2"));
        for (Observer observer : observers) {
            assertEquals("State 2", observer.getState().toString());
        }
        //Unregister second observer
        observers.get(1).unregisterAt(generalResource);
        generalResource.setState(new GeneralResourceState("State 3"));
        assertEquals("State 3", observers.get(0).getState().toString());
        assertEquals("State 2", observers.get(1).getState().toString());
    }

    @Test
    public void testFactory() {
        final ResourceFactory generalResourceFactory = new GeneralResourceFactory();
        final Observable generalResource = generalResourceFactory.create();
        final ResourceFactory newsResourceFactory = new NewsResourceFactory();
        final Observable newsResource = newsResourceFactory.createResource();

        final List<Observer> observers = List.of(new ResourceObserver(), new ResourceObserver());
        for (Observer observer : observers) {
            observer.registerAt(generalResource);
            observer.registerAt(newsResource);
        }
        generalResource.setState(new GeneralResourceState("State 1"));
        for (Observer observer : observers) {
            assertEquals("State 1", observer.getState().toString());
        }
        newsResource.setState(new NewsState("News 1"));
        for (Observer observer : observers) {
            assertEquals("News 1", observer.getState().toString());
        }


    }

}