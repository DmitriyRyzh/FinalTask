package com.rdm.rdm.repo;

import com.rdm.rdm.entity.ItemDb;
import com.rdm.rdm.entity.StatusDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StatusDbRepository extends JpaRepository<StatusDb, Long> {

    StatusDb findByStatusCode(String code);
    Optional<StatusDb> findById(Long id);
}
