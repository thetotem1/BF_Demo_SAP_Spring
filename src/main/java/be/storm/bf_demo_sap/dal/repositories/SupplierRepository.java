package be.storm.bf_demo_sap.dal.repositories;

import be.storm.bf_demo_sap.dl.entities.person.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SupplierRepository extends JpaRepository<Supplier, UUID> {
}
