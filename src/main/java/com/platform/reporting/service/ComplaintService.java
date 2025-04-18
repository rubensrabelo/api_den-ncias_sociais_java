package com.platform.reporting.service;

import com.platform.reporting.domain.Complaint;
import com.platform.reporting.domain.Tag;
import com.platform.reporting.repository.ComplaintRepository;
import com.platform.reporting.repository.TagRepository;
import com.platform.reporting.service.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ComplaintService {

    private final ComplaintRepository complaintRepository;
    private final UserService userService;
    private final TagService tagService;

    public ComplaintService(
            ComplaintRepository complaintRepository,
            UserService userService,
            TagService tagService
    ) {
        this.complaintRepository = complaintRepository;
        this.userService = userService;
        this.tagService = tagService;
    }

    public List<Complaint> findAll() {
        return complaintRepository.findAll();
    }

    public Complaint findById(String id) {
        return complaintRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Complaint not found"));
    }

    public Complaint save(Complaint complaint) {
        Set<String> tagNames = complaint.getTags()
                .stream()
                .map(Tag::getName)
                .collect(Collectors.toSet());

        Set<Tag> tags = tagService.findOrCreateTags(tagNames);
        complaint.setTags(tags);

        var user = userService.findById(complaint.getUser().getId());
        complaint.setUser(user);

        complaint = complaintRepository.insert(complaint);

        return complaint;
    }
}
