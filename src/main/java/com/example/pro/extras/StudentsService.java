//retrieving any api in spring must follow MVC pattern 
//as we have out base format ready in student class now we need to write its business logic
//in this service class.

package com.example.pro.extras;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class StudentsService {

	@Autowired
	StudentRepo studentrepo;
	
	//method to get,print all students in database
	public ArrayList<Students> getAllStudents(){
		ArrayList<Students> allStudent = new ArrayList<Students>();
		for(Students stu : studentrepo.findAll()) {
			allStudent.add(stu);
		}
		return allStudent;
	}
	
	//method to insert the entry in database
	public void addStu(Students stu) {
		studentrepo.save(stu);
	}
	
	public Optional<Students> find(int id) {
		return studentrepo.findById(id);
	}
	
	public void Updated(Students stu) {
		studentrepo.save(stu);
	}
	
	public void delete(int id) {
		studentrepo.deleteById(id);
	}
}
