package Visitor;

public class Main {
    public static void main(String[] args) {
        Directory root = new Directory("root");
        Directory docs = new Directory("documents");
        Directory pics = new Directory("pictures");

        File file1 = new File("resume.docx", 1);
        File file2 = new File("photo.jpg", 5);
        File file3 = new File("notes.txt", 2);
        File file4 = new File("budget.xlsx", 3);

        docs.add(file1);
        docs.add(file3);
        pics.add(file2);
        root.add(docs);
        root.add(pics);
        root.add(file4);

        System.out.println("--- Size Calculation ---");
        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        root.accept(sizeVisitor);
        System.out.println("Total size: " + sizeVisitor.getTotalSize() + " MB");

        System.out.println("\n--- Search for .txt Files ---");
        SearchVisitor searchVisitor = new SearchVisitor(".txt");
        root.accept(searchVisitor);
        for (File f : searchVisitor.getFoundFiles()) {
            System.out.println("Found: " + f.getName());
        }
    }
}
