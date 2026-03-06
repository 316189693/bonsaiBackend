package com.bonsai.identity.domain.repository;

import com.bonsai.identity.domain.model.Email;
import com.bonsai.identity.domain.model.User;

import java.util.Optional;

public interface UserRepository {
  Optional<User> findByEmail(Email email);

  User save(User user);
}
