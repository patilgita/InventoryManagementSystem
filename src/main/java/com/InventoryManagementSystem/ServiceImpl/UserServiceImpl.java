package com.InventoryManagementSystem.ServiceImpl;

import com.InventoryManagementSystem.Entity.Customer;
import com.InventoryManagementSystem.Repository.CustomerRepository;
import com.InventoryManagementSystem.Service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements CustomerService {

    private final CustomerRepository userRepository;

    public UserServiceImpl(CustomerRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Customer createUser(Customer user) {
        return userRepository.save(user);
    }

    @Override
    public Customer getUserById(Long id) {
        Optional<Customer> user = userRepository.findById(id);
        return user.orElse(null);
    }

    @Override
    public List<Customer> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Customer updateUser(Long id, Customer user) {
        Optional<Customer> existingUser = userRepository.findById(id);

        if (existingUser.isPresent()) {
            Customer existing = existingUser.get();

            existing.setName(user.getName());
            existing.setEmail(user.getEmail());
            existing.setPhone(user.getPhone());
            existing.setAddress(user.getAddress());
            existing.setCity(user.getCity());
            existing.setState(user.getState());
            existing.setPincode(user.getPincode());
            existing.setGstNumber(user.getGstNumber()); // new field

            return userRepository.save(existing);
        }

        return null;
    }

    @Override
    public void deleteUser(Long id) {
        Optional<Customer> existingUser = userRepository.findById(id);
        existingUser.ifPresent(userRepository::delete);
    }
}
