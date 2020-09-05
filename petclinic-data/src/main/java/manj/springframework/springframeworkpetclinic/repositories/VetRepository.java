package manj.springframework.springframeworkpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import manj.springframework.springframeworkpetclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {

}
