package com.wallace.msusers.api.repository;

import com.wallace.msusers.domain.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {

    public Optional<Users> findByUsername(String username);
    boolean existsByUsername(String username);
    Optional<Users> findByEmail(String email);
    boolean existsByEmail(String email);

}
