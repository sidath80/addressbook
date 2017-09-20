package com.myassignment.addressbook.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.json.JSONObject;

@Entity
@Table(name="phonenumber")
public class PhoneNumber {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int number;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "contact_id")
	private Contact contact;
	
	public PhoneNumber(){
	}
	    
	public PhoneNumber(int number,Contact contact){
	    	this.number = number;
	    	this.contact=contact;
	}
	    
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public String toString(){
    	String info = "";
    	
        JSONObject jsonInfo = new JSONObject();
        jsonInfo.put("phonenumber",this.number);
        
        JSONObject companyObj = new JSONObject();
        companyObj.put("contactname", this.contact.getName());
        jsonInfo.put("contactname", companyObj);
        
        info = jsonInfo.toString();
        return info;
    }

}
