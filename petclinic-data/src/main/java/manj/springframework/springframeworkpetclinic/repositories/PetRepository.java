package manj.springframework.springframeworkpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import manj.springframework.springframeworkpetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
