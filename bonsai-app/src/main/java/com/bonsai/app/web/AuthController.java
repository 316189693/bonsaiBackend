package com.bonsai.app.web;

import com.bonsai.identity.application.command.LoginCommand;
import com.bonsai.identity.application.command.RegisterUserCommand;
import com.bonsai.identity.application.service.AuthApplicationService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@Validated
public class AuthController {
  private final AuthApplicationService auth;

  public AuthController(AuthApplicationService auth) {
    this.auth = auth;
  }

  public record RegisterRequest(@Email @NotBlank String email, @NotBlank String password) {}

  public record LoginRequest(@Email @NotBlank String email, @NotBlank String password) {}

  public record TokenResponse(String accessToken) {}

  @PostMapping("/register")
  public ResponseEntity<TokenResponse> register(@Valid @RequestBody RegisterRequest req) {
    String token = auth.register(new RegisterUserCommand(req.email(), req.password()));
    return ResponseEntity.ok(new TokenResponse(token));
  }

  @PostMapping("/login")
  public ResponseEntity<TokenResponse> login(@Valid @RequestBody LoginRequest req) {
    String token = auth.login(new LoginCommand(req.email(), req.password()));
    return ResponseEntity.ok(new TokenResponse(token));
  }
}
