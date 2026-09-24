package com.rafaelfilho.dscommerce.dto;

import com.rafaelfilho.dscommerce.entities.Order;
import com.rafaelfilho.dscommerce.entities.OrderItem;
import com.rafaelfilho.dscommerce.entities.OrderStatus;
import jakarta.validation.constraints.NotEmpty;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class OrderDTO {

    private Long id;
    private Instant moment;
    private OrderStatus status;

    private ClientDTO client;
    private PaymentDTO payment;

    @NotEmpty(message = "O pedido deve conter pelo menos um item")
    private List<OrderItemDTO> items = new ArrayList<>();

    public OrderDTO(Long id, OrderStatus status, Instant moment, ClientDTO client, PaymentDTO payment) {
        this.id = id;
        this.status = status;
        this.moment = moment;
        this.client = client;
        this.payment = payment;
    }

    public OrderDTO() {
    }

    public OrderDTO(Order entity) {
        this.id = entity.getId();
        this.status = entity.getStatus();
        this.moment = entity.getMoment();
        this.client = entity.getClient() != null ? new ClientDTO(entity.getClient()) : null;
        this.payment = entity.getPayment() != null ? new PaymentDTO(entity.getPayment()) : null;
        for (OrderItem item: entity.getItems()) {
            OrderItemDTO itemDto = new OrderItemDTO(item);
            items.add(itemDto);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }

    public PaymentDTO getPayment() {
        return payment;
    }

    public void setPayment(PaymentDTO payment) {
        this.payment = payment;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDTO> items) {
        this.items = items;
    }

    public Double getTotal(){
        double sum = 0;
        for (OrderItemDTO item : items) {
            sum += item.getSubTotal();
        }
        return sum;
    }
}
