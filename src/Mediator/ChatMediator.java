package Mediator;

public interface ChatMediator {
    void registerClient(String username, ChatClient client);
    void sendMessage(String sender, String recipient, String message);
}

