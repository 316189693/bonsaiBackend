package com.bonsai.identity.infrastructure.security;

import com.bonsai.identity.application.service.JwtService;
import com.bonsai.identity.domain.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Component
public class JjwtService implements JwtService {
  private final String issuer;
  private final byte[] secret;
  private final long accessTokenMinutes;

  public JjwtService(
      @Value("${bonsai.security.jwt.issuer}") String issuer,
      @Value("${bonsai.security.jwt.secret}") String secret,
      @Value("${bonsai.security.jwt.accessTokenMinutes}") long accessTokenMinutes
  ) {
    this.issuer = issuer;
    this.secret = secret.getBytes(StandardCharsets.UTF_8);
    this.accessTokenMinutes = accessTokenMinutes;
  }

  @Override
  public String issueAccessToken(User user) {
    Instant now = Instant.now();
    return Jwts.builder()
        .issuer(issuer)
        .subject(user.id().value().toString())
        .claim("email", user.email().value())
        .issuedAt(java.util.Date.from(now))
        .expiration(java.util.Date.from(now.plus(accessTokenMinutes, ChronoUnit.MINUTES)))
        .signWith(Keys.hmacShaKeyFor(secret), Jwts.SIG.HS256)
        .compact();
  }
}
