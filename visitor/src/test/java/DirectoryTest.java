import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DirectoryTest {

    @Test
    void testPrintVisitor() {
        final Directory directory = new Directory("Directory");
        final Directory subdirectory1 = new Directory("Subdirectory1");
        final Directory subdirectory2 = new Directory("Subdirectory2");

        final TextFile textFile1 = new TextFile();

        subdirectory1.add(textFile1);
        directory.add(subdirectory1);
        directory.add(subdirectory2);
        final PrintVisitor infoVisitor = new PrintVisitor();
        directory.accept(infoVisitor);

    }

    @Test
    void testInfoVisitor() {
        final Directory directory = new Directory("Directory");
        final Directory subdirectory1 = new Directory("Subdirectory1");
        directory.add(subdirectory1);
        final TextFile textFile1 = new TextFile();
        subdirectory1.add(textFile1);
        final InfoVisitor infoVisitor = new InfoVisitor();
        directory.accept(infoVisitor);
        infoVisitor.printStats();

    }


}