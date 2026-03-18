package com.InventoryManagementSystem.serviceimpl;

import com.InventoryManagementSystem.entity.Order;
import com.InventoryManagementSystem.repository.OrderRepository;
import com.InventoryManagementSystem.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service   // 🔥 VERY IMPORTANT
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}