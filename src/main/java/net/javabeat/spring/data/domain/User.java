package net.javabeat.spring.data.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	private long id;
	@Column(name="login")
	private String login;
	@Column(name="password")
	private String password;
	@Column(name="name")
	private String name;
	@Column(name="email")
	private String email;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User(long id, String login, String password, String name, String email) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.name = name;
		this.email = email;
	}

	public User() {
	}
}
