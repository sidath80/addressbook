package com.myassignment.addressbook.repository;

import java.util.HashSet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.myassignment.addressbook.AddressBookApplication;
import com.myassignment.addressbook.model.AddressBook;
import com.myassignment.addressbook.model.Contact;
import com.myassignment.addressbook.model.PhoneNumber;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AddressBookApplication.class)
public class AddressBookRepositoryTest {

	@Autowired
	private AddressBookRepository addressBookRepository;

	@Autowired
	private ContactRepository contactRepository;

	@Autowired
	private PhoneNumberRepository phoneNumberRepository;
	
	@Test
	public void contextLoads()
	{
		
    }
	

	@Test
	public void addContacts() {

		AddressBook testAddressBook = new AddressBook("TestAddressBook");
		Contact testContact = new Contact("TestContact", testAddressBook);
		PhoneNumber num1 = new PhoneNumber(424688702, testContact);
		PhoneNumber num2 = new PhoneNumber(424688703, testContact);
		testContact.setPhoneNumbers(new HashSet<PhoneNumber>() {
			{
				add(num1);
				add(num2);
			}
		});
		testAddressBook.setContacts(new HashSet<Contact>() {
			{
				add(testContact);
			}
		});
		addressBookRepository.save(testAddressBook);
	}
	
	@Test
	public void removeContact() {

		
	}
	
	@Test
	public void printContactInAddressBook() {

		
	}
	
	@Test
	public void addMultipleAddressBook() {

		
	}
	
	@Test
	public void printUniqueContacts() {

		
	}
}


