import java.io.File;

public class TextFile implements FileSystemItem {
    @Override
    public int getSize() {
        return 100;
    }

    @Override
    public String getName() {
        return getClass().getSimpleName() + ".txt";
    }

    public String getNameWithIndentation(int level) {
        return "\t".repeat(level) + getName() + "\n";
    }
}
