package net.javabeat.spring.data.domain;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Canoe implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	private long id;
	@Column(name="size")
	private String size;
	@Column(name="number")
	private Integer number;
	@Column(name="url")
	private String url;
	@Column(name="status")
	private Integer status;

	public Canoe() {
	}

	public Canoe(long id, String size, Integer number, String Url, Integer status) {
		this.id = id;
		this.size = size;
		this.number = number;
		this.url = Url;
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String Url) {
		this.url = Url;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
