package com.platform.reporting.service;

import com.platform.reporting.domain.Tag;
import com.platform.reporting.repository.TagRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TagService {

    private final TagRepository repository;

    public TagService(TagRepository repository) {
        this.repository = repository;
    }

    public List<Tag> findByNameContainingIgnoreCase(String name){
        return repository.findByNameContainingIgnoreCase(name);
    }

    public Set<Tag> findOrCreateTags(Set<String> names) {
        Set<Tag> result = new HashSet<>();

        for(String name : names){
            Tag tag = repository.findByName(name)
                    .orElseGet(() -> {
                        Tag newTag = new Tag();
                        newTag.setName(name);
                        return repository.insert(newTag);
                    });
            result.add(tag);
        }

        return result;
    }
}
