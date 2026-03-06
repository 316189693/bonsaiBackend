package com.bonsai.app.websocket;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class PushService {
  private final SimpMessagingTemplate messagingTemplate;

  public PushService(SimpMessagingTemplate messagingTemplate) {
    this.messagingTemplate = messagingTemplate;
  }

  public void broadcast(String type, String payload) {
    messagingTemplate.convertAndSend("/topic/notifications", new Notification(type, payload));
  }

  public record Notification(String type, String payload) {}
}
