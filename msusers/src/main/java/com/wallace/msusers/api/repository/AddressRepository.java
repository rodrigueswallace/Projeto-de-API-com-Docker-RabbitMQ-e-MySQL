package com.wallace.msusers.api.repository;

import com.wallace.msusers.domain.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AddressRepository extends JpaRepository<Address, String> {
}
