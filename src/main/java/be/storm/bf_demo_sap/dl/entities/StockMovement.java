package be.storm.bf_demo_sap.dl.entities;

import be.storm.bf_demo_sap.dl.enums.StockMovemenType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

    public StockMovement(UUID id, StockMovemenType stockMovemenType, int quantity, LocalDateTime movementDate) {
        super(id);
        this.stockMovemenType = stockMovemenType;
        this.quantity = quantity;
        this.movementDate = movementDate;
    }
}
