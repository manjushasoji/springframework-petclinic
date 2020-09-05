package manj.springframework.springframeworkpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import manj.springframework.springframeworkpetclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

}
