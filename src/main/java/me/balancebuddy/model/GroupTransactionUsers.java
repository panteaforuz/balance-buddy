package me.balancebuddy.model;


import ch.qos.logback.core.model.NamedModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "GROUP_TRANSACTION_USERS")
public class GroupTransactionUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    private Transaction transaction;

    @ManyToOne
    @JoinColumn(name = "INVOLVED_USER_ID")
    private User user;

    @ManyToOne
    private Group group;

}
