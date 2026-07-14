package nz.fox.craig.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nz.fox.craig.order.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
