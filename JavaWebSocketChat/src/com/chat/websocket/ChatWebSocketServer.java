package com.chat.websocket;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/chat")
public class ChatWebSocketServer {

    // Thread-safe set of connected client sessions
    private static Set<Session> clients = Collections.synchronizedSet(new HashSet<>());

    @OnOpen
    public void onOpen(Session session) {
        clients.add(session);
        System.out.println("New client connected: " + session.getId());
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("Message from [" + session.getId() + "]: " + message);
        // Broadcast the message to all connected clients
        synchronized (clients) {
            for (Session client : clients) {
                if (client.isOpen()) {
                    try {
                        client.getBasicRemote().sendText(message);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @OnClose
    public void onClose(Session session) {
        clients.remove(session);
        System.out.println("Client disconnected: " + session.getId());
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        clients.remove(session);
        System.err.println("Error on session " + (session != null ? session.getId() : "null") + ": " + throwable.getMessage());
    }
}
