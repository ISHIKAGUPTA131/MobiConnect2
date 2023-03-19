package com.company.MobiConnect2.repository;

import com.company.MobiConnect2.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}