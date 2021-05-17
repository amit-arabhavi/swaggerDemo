package com.dev.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dev.model.Contact;

@RestController
public class ContactApi {

	ConcurrentHashMap<String, Contact> contacts =new ConcurrentHashMap<String, Contact>();
	
	@GetMapping(value ="/{id}")
	public Contact getContact(@PathVariable String id){
		return contacts.get(id);
	}
	
	@PostMapping(value="/")
	public  Contact addContact(@RequestBody Contact contact){
		return contacts.put(contact.getId(), contact); 
	}
	
	@GetMapping(value="/")
	public List<Contact> getAllContacts(){
		return new ArrayList<Contact>(contacts.values());
	}
	
}
