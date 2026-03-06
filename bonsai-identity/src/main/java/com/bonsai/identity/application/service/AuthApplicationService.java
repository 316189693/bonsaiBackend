package com.bonsai.identity.application.service;

import com.bonsai.identity.application.command.LoginCommand;
import com.bonsai.identity.application.command.RegisterUserCommand;
import com.bonsai.identity.domain.model.Email;
import com.bonsai.identity.domain.model.PasswordHash;
import com.bonsai.identity.domain.model.User;
import com.bonsai.identity.domain.model.UserId;
import com.bonsai.identity.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class AuthApplicationService {
  private final UserRepository userRepository;
  private final PasswordHasher passwordHasher;
  private final JwtService jwtService;

  public AuthApplicationService(UserRepository userRepository, PasswordHasher passwordHasher, JwtService jwtService) {
    this.userRepository = userRepository;
    this.passwordHasher = passwordHasher;
    this.jwtService = jwtService;
  }

  public String register(RegisterUserCommand cmd) {
    Email email = Email.of(cmd.email());
    userRepository.findByEmail(email).ifPresent(u -> {
      throw new IllegalArgumentException("email already registered");
    });

    String hash = passwordHasher.hash(cmd.password());
    User user = new User(UserId.newId(), email, new PasswordHash(hash), Instant.now());
    userRepository.save(user);

    return jwtService.issueAccessToken(user);
  }

  public String login(LoginCommand cmd) {
    Email email = Email.of(cmd.email());
    User user = userRepository.findByEmail(email)
        .orElseThrow(() -> new IllegalArgumentException("invalid credentials"));

    if (!passwordHasher.matches(cmd.password(), user.passwordHash().value())) {
      throw new IllegalArgumentException("invalid credentials");
    }

    return jwtService.issueAccessToken(user);
  }
}
