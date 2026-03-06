package com.bonsai.identity.infrastructure.persistence.jpa;

import com.bonsai.identity.domain.model.Email;
import com.bonsai.identity.domain.model.PasswordHash;
import com.bonsai.identity.domain.model.User;
import com.bonsai.identity.domain.model.UserId;
import com.bonsai.identity.domain.repository.UserRepository;
import com.bonsai.identity.infrastructure.persistence.jpa.entity.UserJpaEntity;
import com.bonsai.identity.infrastructure.persistence.jpa.repo.UserJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JpaUserRepository implements UserRepository {
  private final UserJpaRepository jpa;

  public JpaUserRepository(UserJpaRepository jpa) {
    this.jpa = jpa;
  }

  @Override
  public Optional<User> findByEmail(Email email) {
    return jpa.findByEmail(email.value()).map(this::toDomain);
  }

  @Override
  public User save(User user) {
    UserJpaEntity e = new UserJpaEntity();
    e.id = user.id().value();
    e.email = user.email().value();
    e.passwordHash = user.passwordHash().value();
    e.createdAt = user.createdAt();
    jpa.save(e);
    return user;
  }

  private User toDomain(UserJpaEntity e) {
    return new User(new UserId(e.id), Email.of(e.email), new PasswordHash(e.passwordHash), e.createdAt);
  }
}
