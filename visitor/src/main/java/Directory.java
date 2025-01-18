import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystemItem {
    private final String name;

    public List<FileSystemItem> getChildren() {
        return childItems;
    }

    private final List<FileSystemItem> childItems;

    public Directory(final String name) {
        this.name = name;
        this.childItems = new ArrayList<>();
    }

    public void add(final FileSystemItem item) {
        this.childItems.add(item);
    }

    public Object accept(FileSystemVisitor visitor) {
      return visitor.visit(this);
    }

    @Override
    public int getDepth() {
        return this.childItems.stream().mapToInt(FileSystemItem::getDepth).max().orElse(0) + 1;
    }

    public void remove(final FileSystemItem item) {
        this.childItems.remove(item);
    }

    public FileSystemItem get(final int index) {
        return this.childItems.get(index);
    }

    @Override
    public int getSize() {
        return this.childItems.stream().mapToInt(FileSystemItem::getSize).sum();
    }

    @Override
    public String getName() {
        return this.name;
    }

    public String getNameWithIndentation(int level) {
        String indentation = "\t".repeat(level);
        StringBuilder nameBuilder = new StringBuilder(indentation + this.name + "\n");
        for (FileSystemItem item : this.childItems) {
            nameBuilder.append(item.getNameWithIndentation(level + 1));
        }
        return nameBuilder.toString();
    }
}
