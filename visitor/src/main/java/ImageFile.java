import java.util.List;

public class ImageFile implements FileSystemItem {
    @Override
    public int getSize() {
        return 100;
    }

    @Override
    public List<FileSystemItem> getChildren() {
        return List.of();
    }

    @Override
    public Object accept(FileSystemVisitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public int getDepth() {
        return 0;
    }

    @Override
    public String getName() {
        return getClass().getSimpleName() + ".img";
    }

    public String getNameWithIndentation(int level) {
        return "\t".repeat(level) + getName() + "\n";
    }
}
