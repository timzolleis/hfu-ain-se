public class PrintVisitor implements FileSystemVisitor {
    private int indentLevel = 0;

    private void printIndent() {
        for (int i = 0; i < indentLevel; i++) {
            System.out.print("  ");
        }
    }

    @Override
    public Object visit(TextFile file) {
        printIndent();
        System.out.println("- File: " + file.getName());
        return null;
    }

    @Override
    public Object visit(ImageFile file) {
        printIndent();
        System.out.println("- File: " + file.getName());
        return null;
    }

    @Override
    public Object visit(Directory directory) {
        printIndent();
        System.out.println("+ Directory: " + directory.getName());
        indentLevel++;
        for (FileSystemItem element : directory.getChildren()) {
            element.accept(this);
        }
        indentLevel--;

        return null;
    }
}