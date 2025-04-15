package Proxy;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        AccessControlService acs = AccessControlService.getInstance();

        // Users
        User alice = new User("alice");
        User bob = new User("bob");

        // Add documents
        library.addUnprotectedDocument("doc1", "Public Announcement");
        library.addProtectedDocument("doc2", "Secret Military Plans");

        // Grant access
        acs.allowAccess("doc2", "alice");

        try {
            // Unprotected document
            Document doc1 = library.getDocument("doc1");
            System.out.println(doc1.getId() + " content: " + doc1.getContent(bob));

            // Protected document (allowed)
            Document doc2 = library.getDocument("doc2");
            System.out.println(doc2.getId() + " content: " + doc2.getContent(alice));

            // Protected document (denied)
            System.out.println(doc2.getId() + " content: " + doc2.getContent(bob));

        } catch (AccessDeniedException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}

