package com.rafaelfilho.dscommerce.repositories;

import com.rafaelfilho.dscommerce.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
