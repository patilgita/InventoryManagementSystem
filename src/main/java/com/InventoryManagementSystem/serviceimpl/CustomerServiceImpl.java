package com.InventoryManagementSystem.serviceimpl;

import com.InventoryManagementSystem.entity.Customer;
import com.InventoryManagementSystem.repository.CustomerRepository;
import com.InventoryManagementSystem.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
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
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + id));
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        Customer existing = getCustomerById(id);

        existing.setCompanyName(customer.getCompanyName());
        existing.setOwnerName(customer.getOwnerName());

        existing.setLandmark(customer.getLandmark());
        existing.setCity(customer.getCity());
        existing.setTaluka(customer.getTaluka());
        existing.setState(customer.getState());
        existing.setPincode(customer.getPincode());

        existing.setEmail(customer.getEmail());
        existing.setPhone(customer.getPhone());

        return customerRepository.save(existing);
    }

    @Override
    public void deleteCustomer(Long id) {
        Customer existing = getCustomerById(id);
        customerRepository.delete(existing);
    }
}
