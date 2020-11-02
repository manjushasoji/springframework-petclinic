package manj.springframework.springframeworkpetclinic.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import manj.springframework.springframeworkpetclinic.model.Owner;
import manj.springframework.springframeworkpetclinic.services.OwnerService;

@RequestMapping("/owners")
@Controller
public class OwnerController {

	private final OwnerService ownerService;

	public OwnerController(OwnerService ownerService) {
		this.ownerService = ownerService;
	}

	/*@RequestMapping({ "", "/", "/index", "index.html" })
	public String listOwners(Model model) {

		model.addAttribute("owners", ownerService.findAll());
		return "owners/index";
	}*/
	
	@InitBinder
	public void setAllowedFields(WebDataBinder webDataBinder) {
		webDataBinder.setDisallowedFields("id");
		
	}

	@RequestMapping("/find")
	public String findOwners(Model model) {
		model.addAttribute("owner",Owner.builder().build());
		return "owners/findOwners";
	}
	
	@GetMapping
	public String processFindForm(Owner owner, BindingResult result, Model model) {
		// allow parameterless GET request for /owners to return all records
		if (owner.getLastName() == null) {
            owner.setLastName(""); // empty string signifies broadest possible search
        }
		List<Owner> owners = ownerService.findAllByLastNameLike("%"+owner.getLastName()+"%");
		if (owners.isEmpty()) {
			//no owners found
			result.rejectValue("lastName", "notfound","Owner Not Found"); //field, errorCode, defaultMessage
			return "owners/findOwners";
		}else if (owners.size() == 1) {
			//one owner found
			owner = owners.get(0);
			return "redirect:/owners/"+owner.getId();
		}else {
			//multiple owners found
			model.addAttribute("selections",owners);
			return "owners/ownerList";
		}
		
	}

	@GetMapping("/{ownerId}")
	public ModelAndView showOwner(@PathVariable Long ownerId) {
		ModelAndView mav = new ModelAndView("owners/ownerDetails");
		mav.addObject(ownerService.findById(ownerId));
		return mav;
	}

}
