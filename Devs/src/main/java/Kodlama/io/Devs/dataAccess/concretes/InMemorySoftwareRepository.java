package Kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import Kodlama.io.Devs.dataAccess.abstracts.ISoftwareRepository;
import Kodlama.io.Devs.entities.concretes.Software;


@Repository
public class InMemorySoftwareRepository implements ISoftwareRepository {

	private List<Software> programmingLanguages = new ArrayList<>();

	public InMemorySoftwareRepository() {

		programmingLanguages.add(new Software("1", "C"));
		programmingLanguages.add(new Software("2", "Java"));
		programmingLanguages.add(new Software("3", "Pyhon"));

	}

	@Override
	public List<Software> getAllSoftwareNames() {

		return programmingLanguages;
	}

	@Override
	public void addSoftware(Software software) {
		programmingLanguages.add(software);

	}

	@Override
	public void deleteSoftware(String name) {
	    
	    for (int i = 0; i < programmingLanguages.size(); i++) {
	        if (programmingLanguages.get(i).getName().equals(name)) {
	            programmingLanguages.remove(i);
	            return;
	        }
	    }
	    
	    throw new IllegalArgumentException("Silinecek programlama dili bulunamadı.");	
	}
	@Override
	public void updateSoftware(Software updatedSoftware) {
	    for (int i = 0; i < programmingLanguages.size(); i++) {
	        if (programmingLanguages.get(i).getId().equals(updatedSoftware.getId())) {
	            programmingLanguages.get(i).setName(updatedSoftware.getName());
	            return; 	        }
	    }
	  throw new IllegalArgumentException("Güncellenecek yazılım dili bulunamadı: " + updatedSoftware.getId());
	}

}