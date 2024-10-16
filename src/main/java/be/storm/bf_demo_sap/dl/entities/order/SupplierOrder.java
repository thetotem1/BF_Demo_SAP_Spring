package be.storm.bf_demo_sap.dl.entities.order;

import be.storm.bf_demo_sap.dl.entities.person.Supplier;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter @Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true) @ToString(callSuper = true)
public class SupplierOrder extends Order {

    @ManyToOne
    private Supplier supplier;

    public SupplierOrder(UUID id, LocalDateTime orderDate, String comment, Supplier supplier) {
        super(id, orderDate, comment);
        this.supplier = supplier;
    }
}
