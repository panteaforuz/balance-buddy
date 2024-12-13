package me.balancebuddy.model;

import io.hypersistence.utils.hibernate.type.money.MonetaryAmountType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.balancebuddy.base.BaseEntity;
import org.hibernate.annotations.CompositeType;

import javax.money.MonetaryAmount;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "ASSET")
public class Asset extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @AttributeOverride(
            name = "amount",
            column = @Column(name = "money_amount")
    )
    @AttributeOverride(
            name = "currency",
            column = @Column(name = "money_currency")
    )
    @CompositeType(MonetaryAmountType.class)
    private MonetaryAmount money;

    @Column(name = "CARD_NUMBER")
    private String cardNumber;

    @Column(name = "is_Default")
    private boolean isDefault;

    @ManyToOne
    private User user;
}
