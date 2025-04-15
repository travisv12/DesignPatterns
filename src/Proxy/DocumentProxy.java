package Proxy;

import java.time.LocalDate;

public class DocumentProxy implements Document {
    private String id;
    private LocalDate creationDate;
    private RealDocument realDocument;
    private static AccessControlService acs = AccessControlService.getInstance();

    public DocumentProxy(String id, LocalDate creationDate, RealDocument realDocument) {
        this.id = id;
        this.creationDate = creationDate;
        this.realDocument = realDocument;
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
    public String getContent(User user) throws AccessDeniedException {
        if (acs.isAllowed(id, user.getUsername())) {
            return realDocument.getContent(user);
        } else {
            throw new AccessDeniedException("Access denied for user: " + user.getUsername());
        }
    }
}
