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

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "source_account_id")
    private Account sourceAccount;

    @ManyToOne
    @JoinColumn(name = "destination_account_id")
    private Account destinationAccount;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @Enumerated(EnumType.STRING)
    private TransmissionType transmissionType;

    @AttributeOverride(
            name = "amount",
            column = @Column(name = "price_amount")
    )
    @AttributeOverride(
            name = "currency",
            column = @Column(name = "price_currency")
    )
    @CompositeType(MonetaryAmountType.class)
    private MonetaryAmount price;
}
