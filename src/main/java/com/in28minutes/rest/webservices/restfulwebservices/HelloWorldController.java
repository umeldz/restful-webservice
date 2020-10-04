package com.in28minutes.rest.webservices.restfulwebservices;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@RequestMapping(path = "/helloworld")
	public String helloWorld() {
		
		return "Hello world!!";
	}
	
	
	//hello-world-bean
	@RequestMapping(path = "/helloworld-bean")
	public HelloWorldBean helloWorldBean() {
		
		return new HelloWorldBean("Hello world!!");
	}
	
	@RequestMapping(path = "/helloworld/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		
		return new HelloWorldBean("Hello world "+ name);
	}
}
