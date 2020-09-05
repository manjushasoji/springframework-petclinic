package manj.springframework.springframeworkpetclinic.services;

import manj.springframework.springframeworkpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

	Owner findByLastName(String lastName);

}
