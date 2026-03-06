package com.bonsai.app.websocket;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestPushController {
  private final PushService pushService;

  public TestPushController(PushService pushService) {
    this.pushService = pushService;
  }

  @PostMapping("/api/push/test")
  public ResponseEntity<Void> test(@RequestParam String message) {
    pushService.broadcast("test", message);
    return ResponseEntity.ok().build();
  }
}
