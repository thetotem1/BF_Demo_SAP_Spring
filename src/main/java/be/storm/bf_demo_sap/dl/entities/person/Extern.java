package be.storm.bf_demo_sap.dl.entities.person;

import be.storm.bf_demo_sap.dl.entities.Address;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "extern_type")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
public abstract class Extern extends Person {

    @Column(nullable = true, length = 17)
    private String phoneNumber;
    @Embedded
    private Address address;

    public Extern(UUID id, String firstName, String lastName, String email, String phoneNumber, Address address) {
        super(id, firstName, lastName, email);
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}
