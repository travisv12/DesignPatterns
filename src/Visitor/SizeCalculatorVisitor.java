package Visitor;

public class SizeCalculatorVisitor implements FileSystemVisitor {
    private int totalSize = 0;

    @Override
    public void visit(File file) {
        totalSize += file.getSizeMB();
    }

    @Override
    public void visit(Directory directory) {
        // No size to add for the directory itself
        System.out.println("Entering directory: " + directory.getName());
    }

    public int getTotalSize() {
        return totalSize;
    }
}
