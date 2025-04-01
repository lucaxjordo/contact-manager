package com.example.contactmanager.dto;

import jakarta.validation.constraints.*;

public class PhoneRequest {
    @NotBlank(message = "Phone number is mandatory")
    @Pattern(regexp = "^\\(\\d{2}\\) \\d{4,5}-\\d{4}$",
            message = "Phone number must be in format (XX) XXXX-XXXX or (XX) XXXXX-XXXX")
    private String number;

    // Getters e setters explícitos
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}