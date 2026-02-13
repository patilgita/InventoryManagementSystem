package com.InventoryManagementSystem.ServiceImpl;

import com.InventoryManagementSystem.Entity.Order;
import com.InventoryManagementSystem.Entity.OrderItem;
import com.InventoryManagementSystem.Repository.OrderRepository;
import com.InventoryManagementSystem.Service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order createOrder(Order order) {
        // calculate total before saving
        double total = calculateTotal(order.getOrderItems());
        order.setTotalAmount(total);

        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order updateOrder(Long id, Order order) {
        Order existing = getOrderById(id);

        if (existing != null) {
            existing.setOrderDate(order.getOrderDate());
            existing.setOrderTime(order.getOrderTime());
            existing.setStatus(order.getStatus());
            existing.setUser(order.getUser());

            double total = calculateTotal(order.getOrderItems());
            existing.setTotalAmount(total);

            existing.setOrderItems(order.getOrderItems());

            return orderRepository.save(existing);
        }

        return null;
    }

    @Override
    public void deleteOrder(Long id) {
        Order existing = getOrderById(id);
        if (existing != null) {
            orderRepository.delete(existing);
        }
    }

    // Discount + Subtotal Logic (GST removed)
    private double calculateTotal(List<OrderItem> items) {
        double total = 0;

        if (items != null) {
            for (OrderItem item : items) {
                double itemTotal = item.getUnitPrice() * item.getQuantity();

                // Apply discount
                itemTotal -= item.getDiscount();

                // set subtotal per item
                item.setSubtotal(itemTotal);

                total += itemTotal;
            }
        }
        return total;
    }
}
