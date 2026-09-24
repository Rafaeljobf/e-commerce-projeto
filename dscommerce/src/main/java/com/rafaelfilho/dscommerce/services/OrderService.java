package com.rafaelfilho.dscommerce.services;

import com.rafaelfilho.dscommerce.dto.OrderDTO;
import com.rafaelfilho.dscommerce.entities.Order;
import com.rafaelfilho.dscommerce.repositories.OrderRepository;
import com.rafaelfilho.dscommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id){
        Order order = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado."));
        return new OrderDTO(order);
    }
}
