package com.myassignment.addressbook;
 
import java.util.HashSet;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.myassignment.addressbook.model.AddressBook;
import com.myassignment.addressbook.model.Contact;
import com.myassignment.addressbook.model.PhoneNumber;
import com.myassignment.addressbook.repository.AddressBookRepository;
import com.myassignment.addressbook.repository.ContactRepository;
import com.myassignment.addressbook.repository.PhoneNumberRepository;
 
 
@SpringBootApplication
public class AddressBookApplication implements CommandLineRunner{
    
    @Autowired
    AddressBookRepository addressbookRepository;
     
    @Autowired
    ContactRepository contactRepository;
    
    @Autowired
    PhoneNumberRepository phoneNumberRepository;
 
    public static void main(String[] args) {
    	SpringApplication.run(AddressBookApplication.class, args);
    }
 
    
    @Override
    public void run(String... arg0) throws Exception {
    	clearData();
    	saveData();
    	showData();
    }
    
    @Transactional
    private void clearData(){
    	addressbookRepository.deleteAll();
        contactRepository.deleteAll();
        phoneNumberRepository.deleteAll();
    }
    
    /**
     * Save AddressBook objects that include Contacts list
     */
    @Transactional
    private void saveData(){
        AddressBook personal = new AddressBook("Personal");
        AddressBook official = new AddressBook("Official");
        
        
        
        Contact sidath = new Contact("Sidath", personal);
        Contact sihas = new Contact("Sihas", personal);
        
        Contact ruwini = new Contact("Ruwini", official);
        Contact dahamsa = new Contact("Dahamsa", official);
        
        PhoneNumber num1=new PhoneNumber(11111,sidath);
        PhoneNumber num2=new PhoneNumber(22222,sidath);
        PhoneNumber num3=new PhoneNumber(33333,sihas);
        PhoneNumber num4=new PhoneNumber(44444,sihas);
        PhoneNumber num5=new PhoneNumber(55555,ruwini);
        PhoneNumber num6=new PhoneNumber(66666,ruwini);
        PhoneNumber num7=new PhoneNumber(77777,dahamsa);
        PhoneNumber num8=new PhoneNumber(88888,dahamsa);
        
        
        sidath.setPhoneNumbers(new HashSet<PhoneNumber>(){{
            add(num1);
            add(num2);
        }});
        
        sihas.setPhoneNumbers(new HashSet<PhoneNumber>(){{
            add(num3);
            add(num4);
        }});
        
        ruwini.setPhoneNumbers(new HashSet<PhoneNumber>(){{
            add(num5);
            add(num6);
        }});
        
        dahamsa.setPhoneNumbers(new HashSet<PhoneNumber>(){{
            add(num7);
            add(num8);
        }});
       
        
        personal.setContacts(new HashSet<Contact>(){{
            add(sidath);
            add(sihas);
        }});
        
        official.setContacts(new HashSet<Contact>(){{
            add(ruwini);
            add(dahamsa);
        }});
        
        System.out.println("$$$$$$$$$$$$$$$$$S"+personal.toString());
        addressbookRepository.save(personal);
        addressbookRepository.save(official);
    }
    
    @Transactional
    private void showData(){
    	// get All data
    	List<AddressBook> addressBookList = addressbookRepository.findAll();
        System.out.println("===================Address Book List:==================");
        addressBookList.forEach(System.out::println);
    }
    
}