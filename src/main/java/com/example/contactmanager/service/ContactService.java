package com.example.contactmanager.service;

import com.example.contactmanager.dto.*;
import com.example.contactmanager.exception.*;
import com.example.contactmanager.model.*;
import com.example.contactmanager.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ContactService {
    private final ContactRepository contactRepository;

    // Construtor explícito em vez de usar @RequiredArgsConstructor
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Transactional
    public ContactResponse createContact(ContactRequest contactRequest) {
        if (contactRepository.existsByEmail(contactRequest.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists");
        }

        Contact contact = new Contact();
        contact.setName(contactRequest.getName());
        contact.setEmail(contactRequest.getEmail());

        if (contactRequest.getPhones() != null) {
            contactRequest.getPhones().forEach(phoneRequest -> {
                Phone phone = new Phone();
                phone.setNumber(phoneRequest.getNumber());
                contact.addPhone(phone);
            });
        }

        Contact savedContact = contactRepository.save(contact);
        return mapToContactResponse(savedContact);
    }

    public List<ContactResponse> getAllContacts() {
        return contactRepository.findAll().stream()
                .map(this::mapToContactResponse)
                .collect(Collectors.toList());
    }

    public ContactResponse getContactById(Long id) {
        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contact not found"));
        return mapToContactResponse(contact);
    }

    @Transactional
    public ContactResponse updateContact(Long id, ContactRequest contactRequest) {
        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contact not found"));

        if (contactRepository.existsByEmailAndIdNot(contactRequest.getEmail(), id)) {
            throw new EmailAlreadyExistsException("Email already exists");
        }

        contact.setName(contactRequest.getName());
        contact.setEmail(contactRequest.getEmail());

        // Limpa os telefones existentes
        contact.getPhones().clear();

        // Adiciona os novos telefones
        if (contactRequest.getPhones() != null) {
            contactRequest.getPhones().forEach(phoneRequest -> {
                Phone phone = new Phone();
                phone.setNumber(phoneRequest.getNumber());
                contact.addPhone(phone);
            });
        }

        Contact updatedContact = contactRepository.save(contact);
        return mapToContactResponse(updatedContact);
    }

    @Transactional
    public void deleteContact(Long id) {
        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contact not found"));
        contactRepository.delete(contact);
    }

    public List<ContactResponse> searchContacts(String query) {
        return contactRepository.searchContacts(query).stream()
                .map(this::mapToContactResponse)
                .collect(Collectors.toList());
    }

    private ContactResponse mapToContactResponse(Contact contact) {
        ContactResponse response = new ContactResponse();
        response.setId(contact.getId());
        response.setName(contact.getName());
        response.setEmail(contact.getEmail());
        response.setCreatedAt(contact.getCreatedAt());
        response.setUpdatedAt(contact.getUpdatedAt());

        Set<PhoneResponse> phoneResponses = new HashSet<>();
        if (contact.getPhones() != null) {
            contact.getPhones().forEach(phone -> {
                PhoneResponse phoneResponse = new PhoneResponse();
                phoneResponse.setId(phone.getId());
                phoneResponse.setNumber(phone.getNumber());
                phoneResponses.add(phoneResponse);
            });
        }
        response.setPhones(phoneResponses);

        return response;
    }
}