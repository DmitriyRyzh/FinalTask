package com.rdm.rdm.service;

import com.rdm.rdm.entity.StatusDb;
import com.rdm.rdm.repo.StatusDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StatusDbService {

    @Autowired
    private StatusDbRepository statusDbRepository;

    public Optional<StatusDb> findById(Long id){
        return statusDbRepository.findById(id);
    }

    public StatusDb findByStatusCode(String code){
        return statusDbRepository.findByStatusCode(code);
    }
}
