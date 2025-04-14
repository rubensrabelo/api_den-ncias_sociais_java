package com.platform.reporting.domain;

import com.platform.reporting.domain.embedded.Address;
import com.platform.reporting.domain.enums.StatusEnum;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Document(value = "complaints")
public class Complaint {

    @Id
    private String id;
    private String title;
    private String description;
    private Address address;
    private StatusEnum status;

    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate
    private Instant updatedAt;

    private String imageUrl;
    private Boolean isAnonymous;

    @DBRef(lazy = true)
    private User user;

    @DBRef(lazy = true)
    private Set<Tag> tags = new HashSet<>();

    public Complaint() {}

    public Complaint(String title, String description, Address address, String imageUrl, Boolean isAnonymous) {
        this.title = title;
        this.description = description;
        this.address = address;
        this.status = StatusEnum.PENDING;
        this.imageUrl = imageUrl;
        this.isAnonymous = isAnonymous;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Boolean getAnonymous() {
        return isAnonymous;
    }

    public void setAnonymous(Boolean anonymous) {
        isAnonymous = anonymous;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Complaint complaint = (Complaint) o;
        return Objects.equals(id, complaint.id) && Objects.equals(title, complaint.title) && Objects.equals(description, complaint.description) && Objects.equals(address, complaint.address) && status == complaint.status && Objects.equals(createdAt, complaint.createdAt) && Objects.equals(updatedAt, complaint.updatedAt) && Objects.equals(imageUrl, complaint.imageUrl) && Objects.equals(isAnonymous, complaint.isAnonymous);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, address, status, createdAt, updatedAt, imageUrl, isAnonymous);
    }
}
