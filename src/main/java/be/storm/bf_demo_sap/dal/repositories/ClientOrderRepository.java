package be.storm.bf_demo_sap.dal.repositories;

import be.storm.bf_demo_sap.dl.entities.order.ClientOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientOrderRepository extends JpaRepository<ClientOrder, UUID> {
}
