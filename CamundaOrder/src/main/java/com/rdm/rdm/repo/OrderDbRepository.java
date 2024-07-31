package com.rdm.rdm.repo;

import com.rdm.rdm.entity.ItemDb;
import com.rdm.rdm.entity.OrderDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderDbRepository  extends JpaRepository<OrderDb, Long> {
    Optional<OrderDb> findById(Long id);

}
