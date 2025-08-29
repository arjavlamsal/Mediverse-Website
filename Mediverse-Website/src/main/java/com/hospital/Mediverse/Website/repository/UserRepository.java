package com.hospital.Mediverse.Website.repository;

import com.hospital.Mediverse.Website.model.User;
import com.hospital.Mediverse.Website.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    Optional<User> findByEmailAndPassword(String email, String password);

    Optional<User> findByEmailAndPasswordAndRole(String email, String password, Role role);
}