package com.platform.reporting.service;

import com.platform.reporting.domain.Tag;
import com.platform.reporting.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagService {

    @Autowired
    private TagRepository repository;

    public boolean create(Tag tag) {
        if(repository.findByName(tag.getName()).isPresent())
            return false;

        repository.save(tag);
        return true;
    }
}
