package Mediator;

import java.util.HashMap;
import java.util.Map;

public class ChatServer implements ChatMediator {

    private Map<String, ChatClient> clients = new HashMap<>();

    @Override
    public void registerClient(String username, ChatClient client) {
        clients.put(username, client);
    }

    @Override
    public void sendMessage(String sender, String recipient, String message) {
        ChatClient client = clients.get(recipient);
        if (client != null) {
            client.receiveMessage(sender, message);
        }
    }
}
