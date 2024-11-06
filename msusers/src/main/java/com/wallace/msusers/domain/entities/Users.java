package com.wallace.msusers.domain.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.mapping.ToOne;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String username;
    private String password;
    @Column(unique = true)
    private String email;

    @ManyToOne
    private Address address;



    public Users(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
