package com.InventoryManagementSystem.ServiceImpl;

import com.InventoryManagementSystem.Entity.User;
import com.InventoryManagementSystem.Repository.UserRepository;
import com.InventoryManagementSystem.Service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null); // Return null if not found
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long id, User user) {
        Optional<User> existingUser = userRepository.findById(id);

        if (existingUser.isPresent()) {
            User existing = existingUser.get();

            // Update fields
            existing.setName(user.getName());
            existing.setEmail(user.getEmail());
            existing.setPhone(user.getPhone());
            existing.setAddress(user.getAddress());
            existing.setCity(user.getCity());
            existing.setDistrict(user.getDistrict());
            existing.setState(user.getState());
            existing.setPincode(user.getPincode());

            return userRepository.save(existing);
        }

        return null; // Return null if user doesn't exist
    }

    @Override
    public void deleteUser(Long id) {
        Optional<User> existingUser = userRepository.findById(id);
        existingUser.ifPresent(userRepository::delete);
    }
}
