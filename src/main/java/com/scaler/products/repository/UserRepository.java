package com.scaler.products.repository;

import com.scaler.products.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    @Override
    Optional<User> findById(Long userId);

    Optional<User> findByName(String name);
}
