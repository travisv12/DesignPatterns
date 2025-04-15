package Proxy;

import java.time.LocalDate;

public class RealDocument implements Document {
    private String id;
    private LocalDate creationDate;
    private String content;

    public RealDocument(String id, LocalDate creationDate, String content) {
        this.id = id;
        this.creationDate = creationDate;
        this.content = content;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public LocalDate getCreationDate() {
        return creationDate;
    }

    @Override
    public String getContent(User user) {
        return content;
    }
}
