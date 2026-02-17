package com.InventoryManagementSystem.Controller;

import com.InventoryManagementSystem.Entity.Customer;
import com.InventoryManagementSystem.Service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class CustomerController {

    private final CustomerService userService;

    public CustomerController(CustomerService userService) {
        this.userService = userService;
    }

    // CREATE USER
    @PostMapping
    public ResponseEntity<Customer> createUser(@RequestBody Customer user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    // GET USER BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    // GET ALL USERS
    @GetMapping
    public ResponseEntity<List<Customer>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // UPDATE USER
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateUser(@PathVariable Long id,
                                               @RequestBody Customer user) {
        return ResponseEntity.ok(userService.updateUser(id, user));
    }

    // DELETE USER
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}
