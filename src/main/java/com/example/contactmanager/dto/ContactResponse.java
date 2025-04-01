package com.example.contactmanager.dto;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class ContactResponse {
    private Long id;
    private String name;
    private String email;
    private Set<PhoneResponse> phones = new HashSet<>();
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Getters e setters explícitos
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<PhoneResponse> getPhones() {
        return phones;
    }

    public void setPhones(Set<PhoneResponse> phones) {
        this.phones = phones;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}