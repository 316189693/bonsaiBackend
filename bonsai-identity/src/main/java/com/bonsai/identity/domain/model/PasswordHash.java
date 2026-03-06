package com.bonsai.identity.domain.model;

import java.util.Objects;

public record PasswordHash(String value) {
  public PasswordHash {
    Objects.requireNonNull(value, "value");
    if (value.isBlank()) {
      throw new IllegalArgumentException("password hash is blank");
    }
  }
}
