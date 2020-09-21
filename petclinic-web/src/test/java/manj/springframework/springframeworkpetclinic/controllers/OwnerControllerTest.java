package manj.springframework.springframeworkpetclinic.controllers;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
import manj.springframework.springframeworkpetclinic.services.OwnerService;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

	@Mock
	OwnerService ownerService;

	@InjectMocks
	OwnerController ownerController;

	Set<Owner> owners;

	MockMvc mockMvc;

	@BeforeEach
	void setUp() throws Exception {
		owners = new HashSet<Owner>();
		owners.add(Owner.builder().id(1L).build());
		owners.add(Owner.builder().id(2L).build());

		mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
	}

	@Test
	void testListOwners() throws Exception {

		mockMvc.perform(get("/owners")).andExpect(status().isOk()).andExpect(model().attributeExists("owners"))
				.andExpect(view().name("owners/index"));
	}

	@Test
	void testListOwnersByIndex() throws Exception {

		mockMvc.perform(get("/owners/index")).andExpect(status().isOk()).andExpect(model().attributeExists("owners"))
				.andExpect(view().name("owners/index"));
	}

	@Test
	void testFindOwners() throws Exception {
		mockMvc.perform(get("/owners/find")).andExpect(status().isOk()).andExpect(view().name("notimplemented"));
		verifyZeroInteractions(ownerService);

	}

}
