package manj.springframework.springframeworkpetclinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import manj.springframework.springframeworkpetclinic.model.Pet;
import manj.springframework.springframeworkpetclinic.services.PetService;

@Service
@Profile({ "default", "map" })
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {

	@Override
	public Set<Pet> findAll() {

		return super.findAll();
	}

	@Override
	public Pet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Pet save(Pet object) {

		return super.save(object);
	}

	@Override
	public void delete(Pet object) {
		super.delete(object);

	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);

	}

}
