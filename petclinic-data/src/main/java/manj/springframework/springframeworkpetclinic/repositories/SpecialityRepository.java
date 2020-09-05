package manj.springframework.springframeworkpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import manj.springframework.springframeworkpetclinic.model.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {

}
