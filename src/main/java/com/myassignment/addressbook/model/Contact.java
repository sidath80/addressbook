package com.myassignment.addressbook.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.json.JSONArray;
import org.json.JSONObject;

@Entity
@Table(name="contact")
public class Contact {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
    private String name;
    
    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<PhoneNumber> phoneNumbers;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "addressbook_id")
    private AddressBook addressbook;
    
    public Contact(){
    }
    
    public Contact(String name, AddressBook company){
    	this.name = name;
    	this.addressbook = company;
    }
    
    // name
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAddressBook(AddressBook company){
    	this.addressbook = company;
    }
    
    public AddressBook getAddressBook(){
    	return this.addressbook;
    }
    
    public Set<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(Set<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
    

	public String toString(){
    	String info = "";
    	
        JSONObject jsonInfo = new JSONObject();
        jsonInfo.put("name",this.name);
        
        JSONObject companyObj = new JSONObject();
        companyObj.put("name", this.addressbook.getName());
        jsonInfo.put("addressbook", companyObj);
        
        JSONArray phoneNumbers = new JSONArray();
        if(this.phoneNumbers != null){
            this.phoneNumbers.forEach(product->{
                JSONObject subJson = new JSONObject();
                subJson.put("phonenumber", product.getNumber());
                phoneNumbers.put(subJson);
            });
        }
        jsonInfo.put("phonenumbers", phoneNumbers);
        
        info = jsonInfo.toString();
        return info;
    }
}
