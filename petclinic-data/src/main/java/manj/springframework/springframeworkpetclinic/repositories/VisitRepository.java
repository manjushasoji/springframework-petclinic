package manj.springframework.springframeworkpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import manj.springframework.springframeworkpetclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {

}
