package com.bonsai.identity.infrastructure.persistence.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "users")
public class UserJpaEntity {
  @Id
  public UUID id;

  @Column(nullable = false, unique = true, length = 320)
  public String email;

  @Column(nullable = false, length = 200)
  public String passwordHash;

  @Column(nullable = false)
  public Instant createdAt;
}
