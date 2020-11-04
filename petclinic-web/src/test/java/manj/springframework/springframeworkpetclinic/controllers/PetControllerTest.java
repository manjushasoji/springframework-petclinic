package manj.springframework.springframeworkpetclinic.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import manj.springframework.springframeworkpetclinic.model.Owner;
import manj.springframework.springframeworkpetclinic.model.Pet;
import manj.springframework.springframeworkpetclinic.model.PetType;
import manj.springframework.springframeworkpetclinic.services.OwnerService;
import manj.springframework.springframeworkpetclinic.services.PetService;
import manj.springframework.springframeworkpetclinic.services.PetTypeService;

@ExtendWith(MockitoExtension.class)
class PetControllerTest {

	@Mock
	PetService petService;

	@Mock
	OwnerService ownerService;

	@Mock
	PetTypeService petTypeService;

	@InjectMocks
	PetController petController;

	MockMvc mockMvc;
	Owner owner;
	Set<PetType> petTypes;

	@BeforeEach
	void setUp() throws Exception {
		owner = Owner.builder().id(1l).build();

		petTypes = new HashSet<>();
		petTypes.add(PetType.builder().id(1L).name("Dog").build());
		petTypes.add(PetType.builder().id(2L).name("Cat").build());

		mockMvc = MockMvcBuilders.standaloneSetup(petController).build();

	}

	@Test
	void testInitCreationForm() throws Exception {
		when(ownerService.findById(anyLong())).thenReturn(owner);
		when(petTypeService.findAll()).thenReturn(petTypes);

		mockMvc.perform(get("/owners/1/pets/new")).andExpect(status().isOk())
				.andExpect(model().attributeExists("owner")).andExpect(model().attributeExists("pet"))
				.andExpect(view().name("pets/createOrUpdatePetForm"));
	}

	@Test
	void testProcessCreationForm() throws Exception {
		when(ownerService.findById(anyLong())).thenReturn(owner);
		when(petTypeService.findAll()).thenReturn(petTypes);

		mockMvc.perform(post("/owners/1/pets/new")).andExpect(status().is3xxRedirection())
				.andExpect(view().name("redirect:/owners/1"));

		verify(petService).save(any());
	}

	@Test
	void testInitUpdateForm() throws Exception {
		when(ownerService.findById(anyLong())).thenReturn(owner);
		when(petTypeService.findAll()).thenReturn(petTypes);
		when(petService.findById(anyLong())).thenReturn(Pet.builder().id(2L).build());

		mockMvc.perform(get("/owners/1/pets/2/edit")).andExpect(status().isOk())
				.andExpect(model().attributeExists("owner")).andExpect(model().attributeExists("pet"))
				.andExpect(view().name("pets/createOrUpdatePetForm"));
	}

	@Test
	void testProcessUpdateForm() throws Exception {
		when(ownerService.findById(anyLong())).thenReturn(owner);
		when(petTypeService.findAll()).thenReturn(petTypes);

		mockMvc.perform(post("/owners/1/pets/2/edit")).andExpect(status().is3xxRedirection())
				.andExpect(view().name("redirect:/owners/1"));

		verify(petService).save(any());
	}

}
