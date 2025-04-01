package com.example.contactmanager.dto;

public class PhoneResponse {
    private Long id;
    private String number;

    // Getters e setters explícitos
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}