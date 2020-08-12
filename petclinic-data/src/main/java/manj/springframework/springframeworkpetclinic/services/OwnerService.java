package manj.springframework.springframeworkpetclinic.services;

import java.util.Set;

import manj.springframework.springframeworkpetclinic.model.Owner;

public interface OwnerService {
	
	Owner findById(Long id);
	
	Owner findByFirstName(String firstName);
	
	Set<Owner> findAll();
	
	Owner save(Owner owner);

} 
