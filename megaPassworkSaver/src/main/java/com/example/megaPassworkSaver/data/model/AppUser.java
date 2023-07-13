package com.example.megaPassworkSaver.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class AppUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToMany( cascade = CascadeType.ALL, mappedBy = "appUser", orphanRemoval = true)
    private  Set<Password> listOfPasswords = new HashSet<>();
    private String userName;
    private String unlockPassword;
    private String emailAddress;
    private Role role;
private  int numberOfPasswords = listOfPasswords.size();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
     return    List.of(new SimpleGrantedAuthority((role.name())));
    }
    @Override
    public String getPassword() {
        return unlockPassword;
    }
    @Override
    public String getUsername() {
        return emailAddress;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
}
