package com.mftplus.storage.controller.socket;

import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@ServerEndpoint(value = "/websocket", configurator = SessionConfigurator.class)
public class WebSocketEndPoint {

    public WebSocketEndPoint() {
        System.out.println("Socket request");
    }

    private static Set<Session> sessions = new HashSet<>();

    public static void broadcastMessage(String message) {
        for (Session session : sessions) {
            try {
                session.getBasicRemote().sendObject(message);
            } catch (IOException | EncodeException e) {
                e.printStackTrace();
            }
        }
    }

    @OnOpen
    public void onOpen(Session session,  EndpointConfig config) {
        System.out.println("WebSocket opened: " + session.getId());
        sessions.add(session);
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("Stock information received: " + message + " from " + session.getId());
        try {
            session.getBasicRemote().sendObject(message);
        } catch (IOException | EncodeException e) {
            e.printStackTrace();
        }
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        System.out.println("WebSocket error for " + session.getId() + " " + throwable.getMessage());
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        System.out.println("WebSocket closed for " + session.getId()
                + " with reason " + closeReason.getCloseCode());
        sessions.remove(session);
    }
}
