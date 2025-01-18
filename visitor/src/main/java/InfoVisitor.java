public class InfoVisitor implements FileSystemVisitor {

    private int currentDepth = 0;
    private int maxDepth = 0;
    private int leafCount = 0;
    private int knotCount = 0;

    @Override
    public Object visit(Directory directory) {
        currentDepth++;
        knotCount++;
        directory.getChildren().forEach(child -> child.accept(this));
        maxDepth = Math.max(maxDepth, currentDepth);
        currentDepth--;
        return 0;
    }

    @Override
    public Object visit(TextFile textFile) {
        leafCount++;
        return 0;
    }

    @Override
    public Object visit(ImageFile imageFile) {
        leafCount++;
        return 0;
    }

    public void printStats() {
        System.out.println("Depth: " + maxDepth);
        System.out.println("Leaf count: " + leafCount);
        System.out.println("Knot count: " + knotCount);
    }
}