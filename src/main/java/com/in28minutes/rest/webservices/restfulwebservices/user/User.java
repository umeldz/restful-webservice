package com.in28minutes.rest.webservices.restfulwebservices.user ;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Integer id;
	@Size(min=2,message="Name should at least have 2 characters")
	private String name;
	@Past(message="Date should be a past date")
	private Date birhtDate;
	
	@OneToMany(mappedBy = "user")
	private List<Post> posts;
	
	public User(Integer id, String name, Date birhtDate) {
		super();
		this.id = id;
		this.name = name;
		this.birhtDate = birhtDate;
	}
	protected User() {
		
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
	
	
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	

}
