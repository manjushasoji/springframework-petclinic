package manj.springframework.springframeworkpetclinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import manj.springframework.springframeworkpetclinic.model.Visit;
import manj.springframework.springframeworkpetclinic.services.VisitService;

@Service
@Profile({ "default", "map" })
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

	@Override
	public Set<Visit> findAll() {
		return super.findAll();
	}

	@Override
	public Visit findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Visit save(Visit object) {
		return super.save(object);
	}

	@Override
	public void delete(Visit object) {
		super.delete(object);

	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);

	}

}
