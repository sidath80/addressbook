package com.myassignment.addressbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myassignment.addressbook.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer>{
}