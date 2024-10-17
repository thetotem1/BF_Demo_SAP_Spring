package be.storm.bf_demo_sap.dl.entities;

import be.storm.bf_demo_sap.dl.enums.VAT;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Article extends BaseEntity {

    @Column(nullable = false, unique = true, length = 80)
    @Getter @Setter
    private String designation;

    @Column(nullable = false)
    @Min(0L)
    @Getter @Setter
    private long unitPriceExcludingTax; // on est en centimes

    @Column(nullable = true)
    @Getter @Setter
    private String picture;

    @Column(nullable = false)
    @Getter @Setter
    @Enumerated(EnumType.STRING)
    private VAT vat;

    @ManyToOne(fetch = FetchType.EAGER)
    @Getter @Setter
    private Category category;

    public Article(UUID id, String designation, long unitPriceExcludingTax, String picture, VAT vat, Category category) {
        super(id);
        this.designation = designation;
        this.unitPriceExcludingTax = unitPriceExcludingTax;
        this.picture = picture;
        this.vat = vat;
        this.category = category;
    }

    public long getUnitPriceIncludingTax() {
        return getAddedValue() + unitPriceExcludingTax;
    }

    public long getAddedValue() {
        BigDecimal vat = BigDecimal.valueOf(this.vat.value, 2);
        BigDecimal priceTTE = BigDecimal.valueOf(this.unitPriceExcludingTax);
        BigDecimal addedValue = priceTTE.multiply(vat);
        return addedValue.setScale(0, RoundingMode.HALF_UP).longValue();
    }
}
