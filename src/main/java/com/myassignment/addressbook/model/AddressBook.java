package com.myassignment.addressbook.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.json.JSONArray;
import org.json.JSONObject;

@Entity
@Table(name="addressbook")
public class AddressBook {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
    private String name;
    
    @OneToMany(mappedBy = "addressbook", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Contact> contacts;
    
    public AddressBook(){
    }
    
    public AddressBook(String name){
    	this.name = name;
    }
    
    // name
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    // products
    public void setContacts(Set<Contact> contacts){
    	this.contacts = contacts;
    }
    
    public Set<Contact> getContacts(){
    	return this.contacts;
    }
    
    public String toString(){
    	String info = "";
        JSONObject jsonInfo = new JSONObject();
        jsonInfo.put("addressbookname",this.name);
        
        JSONArray contactArray = new JSONArray();
        if(this.contacts != null){
            this.contacts.forEach(contact->{
            	JSONArray phoneArray = new JSONArray();
                JSONObject subJson = new JSONObject();
              
                contact.getPhoneNumbers().forEach(number->{
                    JSONObject subJson2 = new JSONObject();
                    subJson2.put("phonenumber", number.getNumber());
                    phoneArray.put(subJson2);
                });
                subJson.put("phonenumbers",phoneArray);
                subJson.put("contactname", contact.getName());
                contactArray.put(subJson);
            });
        }
        jsonInfo.put("contacts", contactArray);
        info = jsonInfo.toString();
        return info;
    }
}
