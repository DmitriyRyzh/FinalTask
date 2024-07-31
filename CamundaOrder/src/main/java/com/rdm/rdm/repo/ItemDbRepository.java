package com.rdm.rdm.repo;

import com.rdm.rdm.entity.ItemDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemDbRepository extends JpaRepository<ItemDb, Long> {

    List<ItemDb> findByCode(String code);
    Optional<ItemDb> findById(Long id);
}
