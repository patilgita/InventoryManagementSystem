package com.InventoryManagementSystem.ServiceImpl;

import com.InventoryManagementSystem.Entity.Order;
import com.InventoryManagementSystem.Entity.OrderItem;
import com.InventoryManagementSystem.Entity.Product;
import com.InventoryManagementSystem.Repository.OrderItemRepository;
import com.InventoryManagementSystem.Repository.OrderRepository;
import com.InventoryManagementSystem.Repository.ProductRepository;
import com.InventoryManagementSystem.Service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public OrderItem createOrderItem(Long orderId, OrderItem orderItem) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        Product product = productRepository.findById(orderItem.getProduct().getId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        orderItem.setOrder(order);
        orderItem.setProduct(product);

        return orderItemRepository.save(orderItem);
    }

    @Override
    public List<OrderItem> getItemsByOrderId(Long orderId) {
        return null;
    }

    @Override
    public void deleteOrderItem(Long id) {
        orderItemRepository.deleteById(id);
    }
}
