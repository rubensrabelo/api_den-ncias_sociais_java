package com.platform.reporting.controller;

import com.platform.reporting.domain.Tag;
import com.platform.reporting.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/tags")
public class TagController {

    public final TagService service;

    public TagController(TagService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Tag>> searchTags(@RequestParam String name) {
        List<Tag> objects = service.findByNameContainingIgnoreCase(name);
        return ResponseEntity.ok().body(objects);
    }
}
