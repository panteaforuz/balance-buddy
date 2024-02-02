package me.balancebuddy.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.balancebuddy.base.BaseEntity;

import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(schema = "USERS")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "USERNAME", unique = true, nullable = false)
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "NATIONAL_ID", unique = true, nullable = false)
    private String nationalId;

    @Column(name = "PHONE_NUMBER", unique = true, nullable = false)
    private String phoneNumber;

    @OneToMany(mappedBy = "user")
    private Set<UserAccount> userAccounts;
}
