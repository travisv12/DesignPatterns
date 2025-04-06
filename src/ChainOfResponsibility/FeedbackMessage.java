package ChainOfResponsibility;

public class FeedbackMessage {
    private MessageType type;
    private String content;
    private String senderEmail;

    public FeedbackMessage(MessageType type, String content, String senderEmail) {
        this.type = type;
        this.content = content;
        this.senderEmail = senderEmail;
    }

    public MessageType getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public String getSenderEmail() {
        return senderEmail;
    }
}