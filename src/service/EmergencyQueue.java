package service;

import java.util.LinkedList;
import java.util.Queue;

public class EmergencyQueue {
    private Queue<String> emergencyRequests = new LinkedList<>();

    // Add a new emergency request
    public void addRequest(String request) {
        emergencyRequests.add(request);
    }

    // Process the oldest request
    public String processRequest() {
        return emergencyRequests.poll();
    }

    public boolean isEmpty() {
        return emergencyRequests.isEmpty();
    }
}
