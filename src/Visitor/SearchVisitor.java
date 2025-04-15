package Visitor;

import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {
    private String extension;
    private List<File> foundFiles = new ArrayList<>();

    public SearchVisitor(String extension) {
        this.extension = extension;
    }

    @Override
    public void visit(File file) {
        if (file.getName().endsWith(extension)) {
            foundFiles.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
        System.out.println("Searching in directory: " + directory.getName());
    }

    public List<File> getFoundFiles() {
        return foundFiles;
    }
}

