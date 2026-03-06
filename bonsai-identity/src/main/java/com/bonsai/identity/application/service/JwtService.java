package com.bonsai.identity.application.service;

import com.bonsai.identity.domain.model.User;

public interface JwtService {
  String issueAccessToken(User user);
}
