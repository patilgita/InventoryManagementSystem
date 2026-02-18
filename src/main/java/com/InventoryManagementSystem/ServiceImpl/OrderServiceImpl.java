package com.InventoryManagementSystem.ServiceImpl;

import com.InventoryManagementSystem.Entity.Customer;
import com.InventoryManagementSystem.Entity.Order;
import com.InventoryManagementSystem.Entity.OrderItem;
import com.InventoryManagementSystem.Entity.Product;
import com.InventoryManagementSystem.Enum.OrderStatus;
import com.InventoryManagementSystem.Repository.CustomerRepository;
import com.InventoryManagementSystem.Repository.OrderRepository;
import com.InventoryManagementSystem.Repository.ProductRepository;
import com.InventoryManagementSystem.Service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    public OrderServiceImpl(OrderRepository orderRepository,
                            CustomerRepository customerRepository,
                            ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Order createOrder(Order order) {
        // Check if customer exists
        Long customerId = order.getCustomer().getId();
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + customerId));
        order.setCustomer(customer);

        // Link OrderItems with Products and calculate totalPrice
        if (order.getOrderItems() != null) {
            for (OrderItem item : order.getOrderItems()) {
                Long productId = item.getProduct().getId();
                Product product = productRepository.findById(productId)
                        .orElseThrow(() -> new RuntimeException("Product not found with ID: " + productId));

                item.setProduct(product);
                item.setOrder(order);

                // Calculate GST and total
                double gstAmount = product.isGstApplicable() ? product.getPrice() * product.getGstPercentage() / 100 : 0;
                double totalPrice = (product.getPrice() + gstAmount) * item.getQuantity();

                item.setPrice(product.getPrice());
                item.setGstAmount(gstAmount);
                item.setTotalPrice(totalPrice);
            }
        }

        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + id));
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> getOrdersByCustomerId(Long customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

    @Override
    public Order updateOrderStatus(Long id, OrderStatus status) {
        Order existing = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + id));

        existing.setStatus(status);
        return orderRepository.save(existing);
    }

    @Override
    public void deleteOrder(Long id) {
        Order existing = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + id));
        orderRepository.delete(existing);
    }
}
