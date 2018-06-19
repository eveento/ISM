package net.javabeat.spring.data.service;

import net.javabeat.spring.data.domain.Canoe;
import net.javabeat.spring.data.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CanoeServiceImpl implements CanoeService {
	@Autowired
	CanoeRepository canoeRepository;
	@Autowired
	CanoeOwnRepository canoeOwnRepository;

	@Override
	public List<Canoe> getCanoeBySize(String size) {
		return canoeOwnRepository.getCanoeBySize(size);
	}
	
	@Override
	public Canoe createCanoe(Canoe canoe) {
		return canoeRepository.save(canoe);
	}

	@Override
	public Canoe getCanoeById(long id) {
		return canoeOwnRepository.getCanoeById(id);
	}

	@Override
	public List<Canoe> getAllCanoes() {
		return canoeOwnRepository.getAllCanoes();
	}

	@Override
	public List<Canoe> getCanoeByStatus(int status) {
		return canoeOwnRepository.getCanoeByStatus(status);
	}

	@Override
	public void uploadCanoeImage(long id, String href) {
		canoeOwnRepository.uploadCanoeImage(id, href);
	}

	@Override
	public void updateStatus(long id, int status) {
		canoeOwnRepository.updateStatus(id, status);
	}

	@Override
	public void deleteCanoe(long id) {
		canoeRepository.deleteById(id);
	}
}
