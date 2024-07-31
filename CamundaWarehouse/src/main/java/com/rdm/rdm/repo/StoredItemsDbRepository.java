package com.rdm.rdm.repo;

import com.rdm.rdm.entity.StoredItemsDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StoredItemsDbRepository extends JpaRepository<StoredItemsDb, Long> {

    Optional<StoredItemsDb> findById(Long id);
    Optional<StoredItemsDb> findByItemCode(String itemCode);
}
