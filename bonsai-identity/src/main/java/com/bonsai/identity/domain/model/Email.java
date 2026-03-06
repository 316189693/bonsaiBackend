package com.bonsai.identity.domain.model;

import java.util.Locale;
import java.util.Objects;

public final class Email {
  private final String value;

  private Email(String value) {
    this.value = value;
  }

  public static Email of(String raw) {
    Objects.requireNonNull(raw, "email");
    String v = raw.trim().toLowerCase(Locale.ROOT);
    if (v.isEmpty() || !v.contains("@")) {
      throw new IllegalArgumentException("invalid email");
    }
    return new Email(v);
  }

  public String value() {
    return value;
  }
}
