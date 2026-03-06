package com.bonsai.identity.domain.model;

import java.time.Instant;
import java.util.Objects;

public final class User {
  private final UserId id;
  private final Email email;
  private final PasswordHash passwordHash;
  private final Instant createdAt;

  public User(UserId id, Email email, PasswordHash passwordHash, Instant createdAt) {
    this.id = Objects.requireNonNull(id, "id");
    this.email = Objects.requireNonNull(email, "email");
    this.passwordHash = Objects.requireNonNull(passwordHash, "passwordHash");
    this.createdAt = Objects.requireNonNull(createdAt, "createdAt");
  }

  public UserId id() {
    return id;
  }

  public Email email() {
    return email;
  }

  public PasswordHash passwordHash() {
    return passwordHash;
  }

  public Instant createdAt() {
    return createdAt;
  }
}
