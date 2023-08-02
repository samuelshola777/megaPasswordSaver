package com.example.megaPassworkSaver.data.repository;

import com.example.megaPassworkSaver.data.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepositoryZ extends JpaRepository<AppUser,Long> {
    AppUser findByEmailAddress(String email);
    boolean existsByEmailAddress(String email );
}
