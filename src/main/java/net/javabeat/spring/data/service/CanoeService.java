package net.javabeat.spring.data.service;

import net.javabeat.spring.data.domain.Canoe;
import net.javabeat.spring.data.domain.User;

import java.util.List;

public interface CanoeService {
	public Canoe createCanoe(Canoe canoe);
	public Canoe getCanoeById(long id);
	public List<Canoe> getAllCanoes();
	public List<Canoe> getCanoeByStatus(int status);
	public List<Canoe> getCanoeBySize(String size);
	public void uploadCanoeImage(long id, String href);
	public void updateStatus(long id, int status);
	public void deleteCanoe(long id);
}
