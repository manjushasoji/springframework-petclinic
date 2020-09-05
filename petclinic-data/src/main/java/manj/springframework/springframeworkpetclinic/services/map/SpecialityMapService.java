package manj.springframework.springframeworkpetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import manj.springframework.springframeworkpetclinic.model.Speciality;
import manj.springframework.springframeworkpetclinic.services.SpecialityService;

@Service
public class SpecialityMapService extends AbstractMapService<Speciality, Long> implements SpecialityService {

	@Override
	public Set<Speciality> findAll() {
		return super.findAll();
	}

	@Override
	public Speciality findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Speciality save(Speciality object) {
		return super.save(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Speciality object) {
		super.delete(object);
	}

}