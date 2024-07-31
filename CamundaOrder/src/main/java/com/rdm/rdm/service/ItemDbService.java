package com.rdm.rdm.service;

import com.rdm.rdm.entity.ItemDb;
import com.rdm.rdm.entity.OrderDb;
import com.rdm.rdm.repo.ItemDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemDbService {

    @Autowired
    private ItemDbRepository itemDbRepository;

    public Optional<ItemDb> findById(Long id){
        return itemDbRepository.findById(id);
    }

    public ItemDb saveItem(ItemDb itemDb) {
        return itemDbRepository.save(itemDb);
    }
}
