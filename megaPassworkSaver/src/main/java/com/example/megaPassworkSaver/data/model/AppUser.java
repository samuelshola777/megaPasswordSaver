package com.example.megaPassworkSaver.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.*;


@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToMany( cascade = CascadeType.ALL, mappedBy = "appUser", orphanRemoval = true)
    private List<Password> listOfPasswords = new ArrayList<>();
    private String userName;
    private String unlockPassword;
    private String emailAddress;
    private String token;
private  int numberOfPasswords ;

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
