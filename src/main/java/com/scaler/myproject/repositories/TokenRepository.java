package com.scaler.myproject.repositories;

import com.scaler.myproject.models.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<com.scaler.myproject.models.Token, Long> {
    @Override
    Token save(Token token);

    Optional<Token> findByValueAndDeleted(String tokenValue, boolean deleted);

    /*

    select * from tokens where value = tokenValue and deleted = false and expiry_date > time.
     */
    Optional<Token> findByValueAndDeletedAndExpiryAtGreaterThan(String tokenValue, boolean deleted, Date currentTime);
}