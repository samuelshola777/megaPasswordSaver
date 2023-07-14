package com.example.megaPassworkSaver.data.repository;

import com.example.megaPassworkSaver.data.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token,Long> {
}
