package com.myassignment.addressbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.myassignment.addressbook.model.PhoneNumber;

public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Integer>{
}
