package com.InventoryManagementSystem.Service;

import com.InventoryManagementSystem.Entity.Customer;

import java.util.List;

public interface CustomerService {

    Customer createUser(Customer user);

    Customer getUserById(Long id);

    List<Customer> getAllUsers();

    Customer updateUser(Long id, Customer user);

    void deleteUser(Long id);
}
