package com.codewithseth.khmerjava_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithseth.khmerjava_api.entity.Role;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(String name);
}
