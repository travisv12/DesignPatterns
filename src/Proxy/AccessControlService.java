package Proxy;

import java.util.HashSet;
import java.util.Set;

public class AccessControlService {
    private static AccessControlService instance;
    private Set<String> allowedPairs;

    private AccessControlService() {
        allowedPairs = new HashSet<>();
    }

    public static AccessControlService getInstance() {
        if (instance == null) {
            instance = new AccessControlService();
        }
        return instance;
    }

    public void allowAccess(String docId, String username) {
        allowedPairs.add(username + ":" + docId);
    }

    public boolean isAllowed(String docId, String username) {
        return allowedPairs.contains(username + ":" + docId);
    }
}
