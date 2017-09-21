                                      README
							             ======
							
				              AddressBook API 0.0.1 release
	    		-------------------------------------------------------------
	    		
Welcome to the addressbookapp API 0.0.1 release!  This release includes versions of the 
addressbookapp API implementation.

JDK Version notes
=============================================================================================

The addressbookapp API supports JDK 1.8 or higher and Maven 3.0 or higher.  Note that I have currently tested this 
implementation with JDK 1.8

 To Run
==============================================================================================
			
	    1. To run the test, type "mvn test"
	       
	       AddressBookRepositoryTest.java : Which will run the following test cases accordingly,
	       
	       addContacts : Add a contact to a given addressbook
	       
	       removeContact : Remove a contact from a given addressbook
	       
	       printAllContactsInAddressBook : Print all contacts a given addressbook 
	       
	       addMultipleAddressBook : Add multiple address book with multiple contacts.
	       
	       printUniqueContacts : Print all unique contacts in the database.
		
		5. Latest version of the code available at the 
		
			Fetch URL: https://github.com/sidath80/addressbook.git
  			Push  URL: https://github.com/sidath80/addressbook.git
  			HEAD branch: master
  			Remote branch: master tracked
  
 Future		
==========================================================================================
		In future, following REST APIS will be develop with using Springboot/Swagger/mockmvc/
			
		Title : Create Contact.
       URL : /createcontact
       Method : POST 
       URL Params : NO
       Data Params : JSON
       Response Codes: Success (201 OK), Bad Request (400), Unauthorized (401)
       
       Title : Remove Contact.
       URL : /removecontact/{id}
       Method : DELETE  
       URL Params : Required: id=[integer]
       Data Params : NO
       Response Codes: Success (201 OK), Bad Request (400), Unauthorized (401)

		Title : Print Contacts in a given addressbook.
       URL : /addressbook/{id}/printcontacts/
       Method : GET  
       URL Params : Required: id=[integer]
       Data Params : NO
       Response Codes: Success (200 OK), Bad Request (400), Unauthorized (401)
		