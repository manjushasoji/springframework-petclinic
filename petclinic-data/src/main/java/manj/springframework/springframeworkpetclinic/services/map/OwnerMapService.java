package manj.springframework.springframeworkpetclinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import manj.springframework.springframeworkpetclinic.model.Owner;
import manj.springframework.springframeworkpetclinic.model.Pet;
import manj.springframework.springframeworkpetclinic.services.OwnerService;
import manj.springframework.springframeworkpetclinic.services.PetService;
import manj.springframework.springframeworkpetclinic.services.PetTypeService;

@Service
@Profile({ "default", "map" })
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

	private final PetTypeService petTypeService;
	private final PetService petService;

	public OwnerMapService(PetTypeService petTypeService, PetService petService) {
		this.petTypeService = petTypeService;
		this.petService = petService;
	}

	@Override
	public Set<Owner> findAll() {
		return super.findAll();
	}

	@Override
	public Owner findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Owner save(Owner object) {
		if (object != null) {
			if (object.getPets() != null) {
				object.getPets().forEach(pet -> {
					if (pet.getPetType() != null) {
						if (pet.getPetType().getId() == null) {
							pet.setPetType(petTypeService.save(pet.getPetType()));
						}
					} else {
						throw new RuntimeException("PetType is Required");
					}

					if (pet.getId() == null) {
						Pet savedpet = petService.save(pet);
						pet.setId(savedpet.getId());
					}
				});
			}
			return super.save(object);
		} else {
			return null;
		}

	}

	@Override
	public void delete(Owner object) {
		super.delete(object);

	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);

	}

	@Override
	public Owner findByLastName(String firstName) {
		return this.findAll()
				.stream()
				.filter(owner-> owner.getLastName().equalsIgnoreCase(firstName))
				.findFirst()
				.orElse(null);
	}

}
