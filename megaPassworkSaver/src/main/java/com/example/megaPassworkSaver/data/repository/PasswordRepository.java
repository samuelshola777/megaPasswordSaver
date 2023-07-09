package com.example.megaPassworkSaver.data.repository;

import com.example.megaPassworkSaver.data.model.Password;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordRepository extends JpaRepository<Password,Long> {
}
