package be.storm.bf_demo_sap.dl.entities.order;

import be.storm.bf_demo_sap.dl.entities.Address;
import be.storm.bf_demo_sap.dl.entities.person.Client;
import be.storm.bf_demo_sap.dl.entities.person.Extern;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter @Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true) @ToString(callSuper = true)
public class ClientOrder extends Order {

    @ManyToOne(fetch = FetchType.EAGER)
    private Client client;

    public ClientOrder(UUID id, LocalDateTime orderDate, String comment, Client client) {
        super(id, orderDate, comment);
        this.client = client;
    }
}
