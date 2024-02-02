package me.balancebuddy.model;

import jakarta.persistence.*;
import me.balancebuddy.base.BaseEntity;

import java.util.List;

@Entity
@Table(name = "USER_ACCOUNTS")
public class UserAccount extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID", nullable = false)
    private Account account;

}