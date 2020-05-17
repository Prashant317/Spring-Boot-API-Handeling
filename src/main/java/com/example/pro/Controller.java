package com.example.pro;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.pro.extras.Students;
import com.example.pro.extras.StudentsService;

@RestController
@RequestMapping("example/v1/insertStudents") //default url not become this.
public class Controller {

	@Autowired
	StudentsService stuservice;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public ArrayList<Students> viewStudents(){
		return stuservice.getAllStudents();
	}
	
	
	
	//controlling the add entry function
	@RequestMapping(value="", method=RequestMethod.POST)
	public void  addStudents(@RequestBody Students stu){
		stuservice.addStu(stu);
	}
	
	
	/*
	 //same method as above to add entry but having some extended things like http status,
	 //response status, attaching header with http, location of api etc...
	 
	 
	 
	 @RequestMapping(value="", method=RequestMethod.POST)
	 @ResponseStatus(value=HttpStatus.CREATED)
	 public void  addStudents(@RequestBody Students stu, HTTPServletRequest req, HTTPServletResponse resp){
		Students stuPerticular = stuservice.addStu(stu);
		resp.setHeader("Location",req.getRequestURL().append(/).append(StuPerticular.getId()).toString());
	 }
	 
	 
	 */
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public Optional<Students> viewOne(@PathVariable("id") int id) {
		return this.stuservice.find(id); 
		
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	//@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateStudent(@PathVariable("id") int id, @RequestBody Students std) {
		this.stuservice.Updated(std);
		
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteStudent(@PathVariable("id") int id) {
		this.stuservice.delete(id);
	}
	
}
