package com.example.megaPassworkSaver.dto.request;

import com.example.megaPassworkSaver.data.model.Password;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.Set;
@Data
public class AppUserRequest {
    private String userName;
    private String emailAddress;
}
