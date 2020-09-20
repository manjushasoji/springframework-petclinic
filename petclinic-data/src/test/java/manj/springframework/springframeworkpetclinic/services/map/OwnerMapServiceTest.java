package manj.springframework.springframeworkpetclinic.services.map;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import manj.springframework.springframeworkpetclinic.model.Owner;

class OwnerMapServiceTest {

	OwnerMapService ownerMapService;

	@BeforeEach
	void setUp() throws Exception {
		ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
		ownerMapService.save(Owner.builder().id(1L).lastName("Smith").build());
	}

	@Test
	void testFindAll() {
		ownerMapService.save(Owner.builder().id(1L).lastName("Smith").build());
		Set<Owner> owners = ownerMapService.findAll();
		assertEquals(1, owners.size());
	}

	@Test
	void testFindByIdLong() {
		Owner owner = ownerMapService.findById(1L);
		assertEquals(1, owner.getId());
	}

	@Test
	void testSaveOwnerWithId() {
		Owner owner2 = ownerMapService.save(Owner.builder().id(2L).build());
		assertNotNull(owner2);
		assertNotNull(owner2.getId());
	}

	@Test
	void testSaveOwnerWithNoId() {
		Owner owner = ownerMapService.save(Owner.builder().build());
		assertNotNull(owner);
		assertNotNull(owner.getId());
	}

	@Test
	void testDeleteOwner() {
		ownerMapService.delete(ownerMapService.findById(1L));	
		assertEquals(0, ownerMapService.findAll().size());
	}

	@Test
	void testDeleteByIdLong() {
		ownerMapService.deleteById(1L);
		assertEquals(0, ownerMapService.findAll().size());
	}

	@Test
	void testFindByLastName() {
		Owner owner = ownerMapService.findByLastName("Smith");
		assertNotNull(owner);
		assertEquals(1, owner.getId());
	}

	@Test
	void testFindByLastNameNotFound() {
		Owner owner = ownerMapService.findByLastName("foo");
		assertNull(owner);
	}

}
