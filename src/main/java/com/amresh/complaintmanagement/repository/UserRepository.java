package com.amresh.complaintmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.amresh.complaintmanagement.model.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}

