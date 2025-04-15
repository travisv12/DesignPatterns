package Proxy;

import java.time.LocalDate;
import java.util.HashMap;

public class Library {
    private HashMap<String, Document> documents = new HashMap<>();

    public void addUnprotectedDocument(String id, String content) {
        RealDocument doc = new RealDocument(id, LocalDate.now(), content);
        documents.put(id, doc);
    }

    public void addProtectedDocument(String id, String content) {
        RealDocument realDoc = new RealDocument(id, LocalDate.now(), content);
        DocumentProxy proxy = new DocumentProxy(id, realDoc.getCreationDate(), realDoc);
        documents.put(id, proxy);
    }

    public Document getDocument(String id) {
        return documents.get(id);
    }
}

