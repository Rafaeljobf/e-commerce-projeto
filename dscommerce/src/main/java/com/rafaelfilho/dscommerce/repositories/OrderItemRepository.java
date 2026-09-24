package com.rafaelfilho.dscommerce.repositories;

import com.rafaelfilho.dscommerce.entities.OrderItem;
import com.rafaelfilho.dscommerce.entities.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}
