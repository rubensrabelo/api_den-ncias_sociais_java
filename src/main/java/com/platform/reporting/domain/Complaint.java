package com.platform.reporting.domain;

import com.platform.reporting.domain.embedded.Address;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
    private String imageUrl;
    private Boolean isAnonymous;

    private User user;
    private Set<Tag> tags = new HashSet<>();

    public Complaint() {}

    public Complaint(String title, String description, Address address, String imageUrl, Boolean isAnonymous) {
        this.title = title;
        this.description = description;
        this.address = address;
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

    // Falta adicionar o bidirecionamento nas tags


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Complaint complaint = (Complaint) o;
        return Objects.equals(id, complaint.id) && Objects.equals(title, complaint.title) && Objects.equals(description, complaint.description) && Objects.equals(address, complaint.address) && Objects.equals(imageUrl, complaint.imageUrl) && Objects.equals(isAnonymous, complaint.isAnonymous);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, address, imageUrl, isAnonymous);
    }
}
