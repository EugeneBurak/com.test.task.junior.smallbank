package com.test.task.junior.smallbank.repository;

import com.test.task.junior.smallbank.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    @Query("select b from Client b where b.client_id = :client_id")
    Client findById(@Param("client_id") int id);
}
