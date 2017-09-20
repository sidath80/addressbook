package com.myassignment.addressbook.repository;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.log4j.Logger;
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
	
	private static final Logger logger = Logger.getLogger(AddressBookRepositoryTest.class);

	@Autowired
	private AddressBookRepository addressBookRepository;

	@Autowired
	private ContactRepository contactRepository;

	@Test
	public void contextLoads()
	{
		
    }
	

	@Test
	public void addContacts() {
		
		logger.info("$$$$$$$$$$$$$$$$$$$ Test 1 addContacts$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

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
		AddressBook testAddressBookNew=addressBookRepository.save(testAddressBook);
		assertEquals(testAddressBook.getName(), testAddressBookNew.getName());
	}
	
	@Test
	public void removeContact() {
		logger.info("$$$$$$$$$$$$$$$$$$$ Test 2 removeContact$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		List<Contact> contacts=contactRepository.findByName("Sidath");
		Contact contact=null;
		if(contacts != null && contacts.size()>0){
		   contact=contacts.get(0);
		   contactRepository.delete(contact);
		}
	}
	
	@Test
	public void printAllContactsInAddressBook() {
		logger.info("$$$$$$$$$$$$$$$$$$ Test 3 printAllContactsInAddressBook$$$$$$$$$$$$$$$$$$");
		List<AddressBook> addressBooks=addressBookRepository.findByName("Personal");
		AddressBook addressBook=null;
		Set<Contact>  contacts=null;
		if(addressBooks != null && addressBooks.size()>0){
		   addressBook=addressBooks.get(0);
		   contacts=addressBook.getContacts();
		   contacts.forEach(System.out::println);
		}
		assertNotNull("printAllContactsInAddressBook failed", contacts);
	}
	
	@Test
	public void addMultipleAddressBook() {
		logger.info("$$$$$$$$$$$$$$$$$$ Test 4 addMultipleAddressBook$$$$$$$$$$$$$$$$$$$$$$$$$$$");
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
		
		AddressBook testAddressBook2 = new AddressBook("TestAddressBook2");
		Contact testContact2 = new Contact("TestContact2", testAddressBook2);
		PhoneNumber num12 = new PhoneNumber(246887022, testContact2);
		PhoneNumber num22 = new PhoneNumber(246887032, testContact2);
		testContact2.setPhoneNumbers(new HashSet<PhoneNumber>() {
			{
				add(num12);
				add(num22);
			}
		});
		testAddressBook2.setContacts(new HashSet<Contact>() {
			{
				add(testContact2);
			}
		});
		AddressBook testAddressBookNew =addressBookRepository.save(testAddressBook);
		AddressBook testAddressBook2New =addressBookRepository.save(testAddressBook2);
		assertEquals(testAddressBook.getName(), testAddressBookNew.getName());
		assertEquals(testAddressBook2.getName(), testAddressBook2New.getName());
	}
	
	@Test
	public void printUniqueContacts() {
		logger.info("$$$$$$$$$$$$$$$$$$$$$$$$ Test 5 printUniqueContacts$$$$$$$$$$$$$$$$$$$$$$$");
		List<Contact> contacts=contactRepository.findAll();
		if(contacts != null && contacts.size()>0){
		   contacts.forEach(System.out::println);
		}
		
	}
}


