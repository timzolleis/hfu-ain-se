public class ImageFile implements FileSystemItem {
    @Override
    public int getSize() {
        return 100;
    }

    @Override
    public String getName() {
        return getClass().getSimpleName() + ".img";
    }
    public String getNameWithIndentation(int level) {
        return "\t".repeat(level) + getName() + "\n";
    }
}
