package com.myassignment.addressbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myassignment.addressbook.model.AddressBook;

public interface AddressBookRepository extends JpaRepository<AddressBook, Integer>{
}