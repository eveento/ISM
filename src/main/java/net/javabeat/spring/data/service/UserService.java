package net.javabeat.spring.data.service;

import net.javabeat.spring.data.domain.User;

import java.util.List;

public interface UserService {
	public User getUserById(long id);
	public List<User> getAllUsers();
	public User createUser(User user);
	public void deleteUser(long id);
	public User checkLogin(String login, String password);
}
