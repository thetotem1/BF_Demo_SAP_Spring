package be.storm.bf_demo_sap.dl.entities.order;

import be.storm.bf_demo_sap.dl.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "order_")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
public class Order extends BaseEntity {

    @Column(nullable = false)
    private LocalDateTime orderDate;
    @Column(nullable = true, length = 255)
    private String comment;

    public Order(UUID id, LocalDateTime orderDate, String comment) {
        super(id);
        this.orderDate = orderDate;
        this.comment = comment;
    }
}
