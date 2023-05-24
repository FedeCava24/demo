package com.example.demo.Service;

import com.example.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User getByUsername(String username);

    User getByActivationCode(String activationCode);
}
