package com.example.crudrds.crudawsrds.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudrds.crudawsrds.dto.EmployeeDetails;
import com.example.crudrds.crudawsrds.service.EmployeeService;



@RestController
@RequestMapping("/employee")
public class Employeecontoller 
{
  
	@Autowired
	private EmployeeService service;
	
	
	@GetMapping(path="/get")
    public ResponseEntity<List<EmployeeDetails>> getAllStudents(){
       List<EmployeeDetails> list = service.getAllStudents();
       return new ResponseEntity<List<EmployeeDetails>>(list,HttpStatus.OK);
   }
	
	 @PostMapping(path="/add")
	    public void addStudent(@RequestBody List <EmployeeDetails> El){
	    service.addStudent(El);
	    }
	
	 @GetMapping(path="/{id}")
	    public ResponseEntity<EmployeeDetails> getStudentById(@PathVariable("id") Integer id) {
		 EmployeeDetails el= service.getStudentById(id);
	        return new ResponseEntity<EmployeeDetails>(el,HttpStatus.OK);
	        
	    }
	 
	 
	 @DeleteMapping(path="/{id}")
	    public ResponseEntity<EmployeeDetails> deleteStudentById(@PathVariable("id") Integer id){
		 EmployeeDetails el = service.deleteStudentById(id);
	        return new ResponseEntity<EmployeeDetails>(el,HttpStatus.OK);
	 }
	 
//	 @PutMapping(path="/modify/{id}")
//	    public ResponseEntity modifyStudentId(@PathVariable("id")Integer id, @RequestBody EmployeeDetails el){
//	        service.modifyStudentId(el.getId(), el.getName(),el.getPosition(),el.);
//	        return new ResponseEntity(HttpStatus.OK);
//	    }
	 
	 
	 
	 
	 
}
