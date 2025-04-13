package com.platform.reporting.service;

import com.platform.reporting.domain.Tag;
import com.platform.reporting.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    private final TagRepository repository;

    public TagService(TagRepository repository) {
        this.repository = repository;
    }

    public List<Tag> findByNameContainingIgnoreCase(String name){
        return repository.findByNameContainingIgnoreCase(name);
    }

    public boolean create(Tag tag) {
        if(repository.findByName(tag.getName()).isPresent())
            return false;

        repository.save(tag);
        return true;
    }
}
