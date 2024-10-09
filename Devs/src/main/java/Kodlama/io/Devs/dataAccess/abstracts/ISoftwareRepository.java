package Kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;

import Kodlama.io.Devs.entities.concretes.Software;

public interface ISoftwareRepository {
	public List<Software> getAllSoftwareNames();
	public void addSoftware(Software software);
	public void deleteSoftware(String name);
	public void updateSoftware(Software updateName);

}
