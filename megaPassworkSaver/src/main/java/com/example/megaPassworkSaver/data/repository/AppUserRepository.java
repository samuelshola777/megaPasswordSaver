package com.example.megaPassworkSaver.data.repository;

import com.example.megaPassworkSaver.data.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,Long> {
}
