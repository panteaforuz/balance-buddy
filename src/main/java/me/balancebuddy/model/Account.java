package me.balancebuddy.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.balancebuddy.base.BaseEntity;

import java.util.Set;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "ACCOUNTS")
public class Account extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_number", unique = true, nullable = false)
    private String accountNumber;

    @OneToMany(mappedBy = "account")
    private Set<UserAccount> userAccounts;

//    @OneToMany(mappedBy = "account")
//    private List<Transaction> transactions;
}
