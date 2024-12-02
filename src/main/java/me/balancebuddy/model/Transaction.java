package me.balancebuddy.model;

import io.hypersistence.utils.hibernate.type.money.MonetaryAmountType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.balancebuddy.base.BaseEntity;
import me.balancebuddy.model.enums.TransactionType;
import me.balancebuddy.model.enums.TransmissionType;
import org.hibernate.annotations.CompositeType;
import javax.money.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "TRANSACTION")
public class Transaction extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "SOURSE_ACCOUNT_ID")
    private Account sourceAccount;

    @ManyToOne
    @JoinColumn(name = "DESTINATION_ACCOUNT_ID")
    private Account destinationAccount;

    @Column(name = "ORIGIN_CARD_NUMBER")
    private String originCardNumber;

    @Column(name = "DESTINATION_CARD_NUMBER")
    private String sourceCardNumber;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @Enumerated(EnumType.STRING)
    private TransmissionType transmissionType;

    @AttributeOverride(
            name = "AMOUNT",
            column = @Column(name = "PRICE_AMOUNT")
    )
    @AttributeOverride(
            name = "CURRENCY",
            column = @Column(name = "PRICE_CURRENCY")
    )
    @CompositeType(MonetaryAmountType.class)
    private MonetaryAmount price;

    @OneToMany(mappedBy = "Transaction")
    private Set<Account> involvedAccounts;
}
