package manj.springframework.springframeworkpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import manj.springframework.springframeworkpetclinic.model.Owner;
import manj.springframework.springframeworkpetclinic.model.Pet;
import manj.springframework.springframeworkpetclinic.model.PetType;
import manj.springframework.springframeworkpetclinic.model.Speciality;
import manj.springframework.springframeworkpetclinic.model.Vet;
import manj.springframework.springframeworkpetclinic.services.OwnerService;
import manj.springframework.springframeworkpetclinic.services.PetTypeService;
import manj.springframework.springframeworkpetclinic.services.SpecialityService;
import manj.springframework.springframeworkpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialityService specialityService;

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
			SpecialityService specialityService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialityService = specialityService;
	}

	public void run(String... args) throws Exception {

		int count = petTypeService.findAll().size();
		if (count == 0) {
			loadData();
		}
	}

	private void loadData() {
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);

		PetType cat = new PetType();
		cat.setName("Cat");
		PetType savedCatPetType = petTypeService.save(cat);

		Owner owner1 = new Owner();
		owner1.setFirstName("Michael");
		owner1.setLastName("Weston");
		owner1.setAddress("addr 1");
		owner1.setCity("Austin");
		owner1.setTelephone("11111");

		Pet mikesPet = new Pet();
		mikesPet.setName("Doggy");
		mikesPet.setBirthDate(LocalDate.now());
		mikesPet.setOwner(owner1);
		mikesPet.setPetType(savedDogPetType);

		owner1.getPets().add(mikesPet);
		ownerService.save(owner1);

		Owner owner2 = new Owner();
		owner2.setFirstName("Fiona");
		owner2.setLastName("Glenanne");
		owner2.setAddress("Addr 2");
		owner2.setCity("woodland hills");
		owner2.setTelephone("22222");

		Pet fionasPet = new Pet();
		fionasPet.setName("Catty");
		fionasPet.setBirthDate(LocalDate.now());
		fionasPet.setOwner(owner2);
		fionasPet.setPetType(savedCatPetType);

		owner2.getPets().add(fionasPet);
		ownerService.save(owner2);

		System.out.println("Loaded Owners....");

		Speciality radiology = new Speciality();
		radiology.setDescription("Radiology");
		Speciality savedRadiology = specialityService.save(radiology);

		Speciality surgery = new Speciality();
		surgery.setDescription("Surgery");
		Speciality savedSurgery = specialityService.save(surgery);

		Speciality dentistry = new Speciality();
		dentistry.setDescription("Dentistry");
		Speciality savedDentistry = specialityService.save(dentistry);

		Vet vet1 = new Vet();
		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");
		vet1.getSpecialities().add(savedRadiology);

		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setFirstName("Jessie");
		vet2.setLastName("Porter");
		vet2.getSpecialities().add(savedSurgery);

		vetService.save(vet2);

		System.out.println("Loaded Vets....");
	}

}
