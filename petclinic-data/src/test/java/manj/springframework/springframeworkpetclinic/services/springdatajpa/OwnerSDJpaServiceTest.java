package manj.springframework.springframeworkpetclinic.services.springdatajpa;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import manj.springframework.springframeworkpetclinic.model.Owner;
import manj.springframework.springframeworkpetclinic.repositories.OwnerRepository;
import manj.springframework.springframeworkpetclinic.repositories.PetRepository;
import manj.springframework.springframeworkpetclinic.repositories.PetTypeRepository;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {
	
	private static final String LAST_NAME = "Smith";
	
	@Mock
	OwnerRepository ownerRepository;
	
	@Mock
	PetRepository petRepository;
	
	@Mock
	PetTypeRepository petTypeRepository;
	
	@InjectMocks
	OwnerSDJpaService ownerSDJpaService;
	
	Owner reuturnOwner;

	@BeforeEach
	void setUp() throws Exception {
		reuturnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
	}

	@Test
	void testFindAll() {
		Set<Owner> ownerset = new HashSet<>();
		ownerset.add(Owner.builder().id(1L).build());
		ownerset.add(Owner.builder().id(2L).build());
		when(ownerRepository.findAll()).thenReturn(ownerset);
		Set<Owner> returnOwnerSet = ownerSDJpaService.findAll();
		
		assertNotNull(returnOwnerSet);
		assertEquals(2, returnOwnerSet.size());
	}

	@Test
	void testFindById() {
		when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(reuturnOwner));
		Owner owner = ownerSDJpaService.findById(1L);
		assertNotNull(owner);
	}
	@Test
	void testFindByIdNotFound() {
		when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
		Owner owner = ownerSDJpaService.findById(1L);
		assertNull(owner);
	}

	@Test
	void testSave() {
		Owner ownerToSave = Owner.builder().id(1L).build();
		when(ownerRepository.save(any())).thenReturn(ownerToSave);
		Owner savedowner = ownerSDJpaService.save(ownerToSave);
		
		assertNotNull(savedowner);
		verify(ownerRepository).save(any());
	}

	@Test
	void testDelete() {
		ownerSDJpaService.delete(reuturnOwner);
		
		//default is 1 times
        verify(ownerRepository, times(1)).delete(any());
	}

	@Test
	void testDeleteById() {
		ownerSDJpaService.deleteById(1L);
		verify(ownerRepository).deleteById(anyLong());
	}

	@Test
	void testFindByLastName() {
		when(ownerRepository.findByLastName(anyString())).thenReturn(reuturnOwner);
		Owner owner = ownerSDJpaService.findByLastName(LAST_NAME);
		assertEquals(LAST_NAME, owner.getLastName());
		verify(ownerRepository).findByLastName(any());
	}

}
