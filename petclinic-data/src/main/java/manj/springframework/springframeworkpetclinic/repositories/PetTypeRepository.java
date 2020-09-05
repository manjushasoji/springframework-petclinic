package manj.springframework.springframeworkpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import manj.springframework.springframeworkpetclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
