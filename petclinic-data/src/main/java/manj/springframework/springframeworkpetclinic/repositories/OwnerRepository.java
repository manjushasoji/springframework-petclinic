package manj.springframework.springframeworkpetclinic.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import manj.springframework.springframeworkpetclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
	
	Owner findByLastName(String lastName);

	List<Owner> findAllByLastNameLike(String lastName);
}
