package com.InventoryManagementSystem.ServiceImpl;

import com.InventoryManagementSystem.Entity.Customer;
import com.InventoryManagementSystem.Repository.CustomerRepository;
import com.InventoryManagementSystem.Service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.orElse(null);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        Optional<Customer> existingCustomer = customerRepository.findById(id);
        if (existingCustomer.isPresent()) {
            Customer existing = existingCustomer.get();

            existing.setName(customer.getName());
            existing.setEmail(customer.getEmail());
            existing.setPhone(customer.getPhone());
            existing.setAddress(customer.getAddress());
            existing.setCity(customer.getCity());
            existing.setState(customer.getState());
            existing.setPincode(customer.getPincode());
            existing.setGstNumber(customer.getGstNumber());

            return customerRepository.save(existing);
        }
        return null;
    }

    @Override
    public void deleteCustomer(Long id) {
        Optional<Customer> existingCustomer = customerRepository.findById(id);
        existingCustomer.ifPresent(customerRepository::delete);
    }
}
