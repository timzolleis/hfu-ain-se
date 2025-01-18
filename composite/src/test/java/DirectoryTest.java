import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectoryTest {

    @org.junit.jupiter.api.Test
    void getName() {
        final TextFile textFile1 = new TextFile();
        final ImageFile imageFile1 = new ImageFile();

        final Directory subdirectoy = new Directory("Subdirectory");
        subdirectoy.add(textFile1);
        subdirectoy.add(imageFile1);
        final Directory directory = new Directory("Directory");
        directory.add(subdirectoy);

        System.out.println(directory.getName());
    }

    @Test
    void testOperations() {
        final TextFile textFile1 = new TextFile();
        final ImageFile imageFile1 = new ImageFile();

        final Directory subdirectoy = new Directory("Subdirectory");
        subdirectoy.add(textFile1);
        subdirectoy.add(imageFile1);
        assertEquals(200, subdirectoy.getSize());
        final Directory directory = new Directory("Directory");
        directory.add(subdirectoy);
        directory.add(textFile1);
        assertEquals(300, directory.getSize());

    }
}