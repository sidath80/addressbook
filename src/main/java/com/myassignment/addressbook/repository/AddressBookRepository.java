package com.myassignment.addressbook.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.myassignment.addressbook.model.AddressBook;

public interface AddressBookRepository extends JpaRepository<AddressBook, Integer>{
	
	List<AddressBook> findByName(String name);
}