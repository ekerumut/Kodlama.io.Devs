package Kodlama.io.Devs.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.entities.concretes.Software;

public interface ISoftwareService {
	public List<Software> getAllSoftwareNames();
	public void addSoftware(Software software);
	public void deleteSoftware(String name);
	public void updateSoftware(Software updateName);

}
