package com.example.megaPassworkSaver.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.*;

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
    private final List<Password> listOfPasswords = new ArrayList<>();
    @Column(unique = true)
    private String userName;
    private String unlockPassword;
    private String emailAddress;
    private String token;
    private boolean isEnabled;
private  int numberOfPasswords ;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
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

//@Bean
//@PostConstruct
//public void initializisation(){
//    this.listOfPasswords = new HashSet<>();
//}
//public Set<Password> getListOfPasswords(){
//    return listOfPasswords;
//}
//    @Bean
//    @PostConstruct
//    public void initializisation(){
//    this.listOfToken = new ArrayList<>();
//}
//    public List<ChurchTokenZ> getListOfToken() {
//        return listOfToken;
//    }

}
