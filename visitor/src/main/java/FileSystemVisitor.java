public interface FileSystemVisitor {
    public Object visit(Directory directory);

    public Object visit(TextFile textFile);

    public Object visit(ImageFile imageFile);
}
