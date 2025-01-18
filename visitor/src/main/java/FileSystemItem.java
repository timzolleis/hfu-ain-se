import java.util.List;

public interface FileSystemItem {
    public int getSize();

    public int getDepth();

    public List<FileSystemItem> getChildren();

    public String getName();

    public String getNameWithIndentation(int level);

    public Object accept(FileSystemVisitor visitor);
}
