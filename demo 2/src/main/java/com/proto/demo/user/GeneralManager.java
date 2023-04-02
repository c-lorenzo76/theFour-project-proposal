package com.proto.demo.user;

import com.proto.demo.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 *
 * @author CollinHarris
 */
@Entity
@Table(name = "generalmanager")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GeneralManager extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userName;
    private String email;
    private String password;
    
    public GeneralManager(String userName,String email,String password){
        this.userName = userName;
        this.email = email;
        this.password = password;
    }
}