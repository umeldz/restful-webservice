package com.in28minutes.rest.webservices.restfulwebservices.user ;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class User {
	
	
	private Integer id;
	@Size(min=2,message="Name should at least have 2 characters")
	private String name;
	@Past(message="Date should be a past date")
	private Date birhtDate;
	
	public User(Integer id, String name, Date birhtDate) {
		super();
		this.id = id;
		this.name = name;
		this.birhtDate = birhtDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirhtDate() {
		return birhtDate;
	}

	public void setBirhtDate(Date birhtDate) {
		this.birhtDate = birhtDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
	

}
