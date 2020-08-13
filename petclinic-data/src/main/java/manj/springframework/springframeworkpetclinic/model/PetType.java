package manj.springframework.springframeworkpetclinic.model;

public class PetType extends BaseEntity{
	
	private String Name;

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

}
