package Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.ISoftwareService;
import Kodlama.io.Devs.dataAccess.abstracts.ISoftwareRepository;
import Kodlama.io.Devs.dataAccess.concretes.InMemorySoftwareRepository;
import Kodlama.io.Devs.entities.concretes.Software;

@Service
public class SoftwareService implements ISoftwareService {
	
	private ISoftwareRepository ınMemorySoftwareRepository;
	
	@Autowired
	public SoftwareService (ISoftwareRepository ınMemorySoftwareRepository) {
		this.ınMemorySoftwareRepository=ınMemorySoftwareRepository;
	}
	
	

	@Override
	public List<Software> getAllSoftwareNames() {
		
		return ınMemorySoftwareRepository.getAllSoftwareNames();
	}

	@Override
	public void addSoftware(Software software) {
		if(software.getName() == null ||  software.getName().isEmpty()) {
			throw new IllegalArgumentException("Programlama Dili Boş Bırakılamaz");
		}
		
		for (Software language: ınMemorySoftwareRepository.getAllSoftwareNames()) {
			if(language.getId().equals(software.getId())) {
				throw new IllegalArgumentException("Aynı Kimliğe Sahip Programlama Dili Yazılamaz ");
			}
			if(language.getName().equalsIgnoreCase(software.getName())) {
				throw new IllegalArgumentException("Programlama Dili Tekrar Edemez");
			}
		}
		
		ınMemorySoftwareRepository.addSoftware(software);
		
		
		
	}

	@Override
	public void deleteSoftware(String name) {
		ınMemorySoftwareRepository.deleteSoftware(name);		
	}

	@Override
	public void updateSoftware(Software updateName) {
		ınMemorySoftwareRepository.updateSoftware(updateName);
		
	}

}
