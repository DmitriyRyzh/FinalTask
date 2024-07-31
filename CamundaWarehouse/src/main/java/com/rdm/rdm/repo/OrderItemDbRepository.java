package com.rdm.rdm.repo;

import com.rdm.rdm.entity.OrderItemDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderItemDbRepository  extends JpaRepository<OrderItemDb, Long> {
    Optional<OrderItemDb> findById(Long id);

}
