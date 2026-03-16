package com.codewithseth.khmerjava_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithseth.khmerjava_api.entity.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
