package com.example.contactmanager.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.util.HashSet;
import java.util.Set;

public class ContactRequest {
    @NotBlank(message = "Name is mandatory")
    @Size(max = 100, message = "Name must be less than 100 characters")
    private String name;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    @Valid
    private Set<PhoneRequest> phones = new HashSet<>();

    // Getters e setters explícitos
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

    public Set<PhoneRequest> getPhones() {
        return phones;
    }

    public void setPhones(Set<PhoneRequest> phones) {
        this.phones = phones;
    }
}