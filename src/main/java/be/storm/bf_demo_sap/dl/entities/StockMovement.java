package be.storm.bf_demo_sap.dl.entities;

import be.storm.bf_demo_sap.dl.enums.StockMovemenType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class StockMovement extends BaseEntity {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StockMovemenType stockMovemenType;
    @Column(nullable = false)
    @Min(0)
    private int quantity;
    @Column(nullable = false)
    private LocalDateTime movementDate;

    @ManyToOne(fetch = FetchType.EAGER)
    private Article article;

    public StockMovement(UUID id, StockMovemenType stockMovemenType, int quantity, LocalDateTime movementDate, Article article) {
        super(id);
        this.stockMovemenType = stockMovemenType;
        this.quantity = quantity;
        this.movementDate = movementDate;
        this.article = article;
    }
}
