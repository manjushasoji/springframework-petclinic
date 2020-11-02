package manj.springframework.springframeworkpetclinic.services;

import java.util.List;

import manj.springframework.springframeworkpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

	Owner findByLastName(String lastName);

	List<Owner> findAllByLastNameLike(String lastName);
}
