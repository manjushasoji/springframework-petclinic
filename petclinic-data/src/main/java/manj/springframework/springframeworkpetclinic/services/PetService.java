package manj.springframework.springframeworkpetclinic.services;

import java.util.Set;

import manj.springframework.springframeworkpetclinic.model.Pet;

public interface PetService {
	
	Pet findById(Long id);
	
	Set<Pet> findAll();
	
	Pet save(Pet pet);
}
