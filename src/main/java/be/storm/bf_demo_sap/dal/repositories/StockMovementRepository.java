package be.storm.bf_demo_sap.dal.repositories;

import be.storm.bf_demo_sap.dl.entities.StockMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StockMovementRepository extends JpaRepository<StockMovement, UUID> {
}
