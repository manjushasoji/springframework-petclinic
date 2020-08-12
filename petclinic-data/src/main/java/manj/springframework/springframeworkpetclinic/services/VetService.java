package manj.springframework.springframeworkpetclinic.services;

import java.util.Set;

import org.hibernate.internal.util.type.PrimitiveWrapperHelper.LongDescriptor;

import manj.springframework.springframeworkpetclinic.model.Vet;

public interface VetService {

	Vet findById(Long id);
	
	Set<Vet> findAll();
	
	Vet save(Vet vet); 
}
