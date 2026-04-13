package com.devsuperior.clientsp.repositories;

import com.devsuperior.clientsp.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
