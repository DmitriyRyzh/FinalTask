package com.rdm.rdm.service;

import com.rdm.rdm.entity.OrderDb;
import com.rdm.rdm.entity.StoredItemsDb;
import com.rdm.rdm.repo.StoredItemsDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StoredItemsDbDbService {

    @Autowired
    private StoredItemsDbRepository itemDbRepository;

    public Optional<StoredItemsDb> findById(Long id){
        return itemDbRepository.findById(id);
    }

    public Optional<StoredItemsDb> findByItemCode(String itemCode){
        return itemDbRepository.findByItemCode(itemCode);
    }

    public StoredItemsDb save(StoredItemsDb storedItemsDb) {
        return itemDbRepository.save(storedItemsDb);
    }
}
