package be.storm.bf_demo_sap.dl.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
public class Category extends BaseEntity {

    @Column(unique = true, nullable = false, length = 80)
    private String designation;

    public Category(UUID id, String designation) {
        super(id);
        this.designation = designation;
    }
}
