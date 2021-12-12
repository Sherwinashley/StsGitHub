package com.example.crudrds.crudawsrds.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crudrds.crudawsrds.dto.EmployeeDetails;
import com.example.crudrds.crudawsrds.repository.EmployeeRepo;




@Service
public class EmployeeService 
{
	@Autowired
	public EmployeeRepo er;
	
	
      //POST	
	  public void addStudent(List<EmployeeDetails> el)

	         {

	             er.saveAll(el);
	             
	            
	             
	         }
	  
	  //GET
	  public List<EmployeeDetails> getAllStudents() {
	        {
	            List<EmployeeDetails> El = er.findAll();

	            if(El.size() > 0) {
	                return El;
	            }
	            else {
	                return new ArrayList<EmployeeDetails>();
	            }
	        }
	    }
	  
	  //GET BY ID
	  public EmployeeDetails getStudentById(Integer id) 
	    {
	        Optional<EmployeeDetails> El = er.findById(id);
	        if(El.isPresent())
	        {
	        return El.get();
	        }
	        else
	        {
	        	
	           return null;
	        }
	    }
	  
	  
	  //DELETE
	  public EmployeeDetails deleteStudentById(Integer id) {

	        //Optional<Student> del = repository.findById(id);
	        er.deleteById(id);
	        return null;
	    }
	  
	  //UPDATE
	  public List<EmployeeDetails> modifyStudentId(Integer id, String name,String position , int salary) 
	  {
		  
		  
	        Optional<EmployeeDetails> student1 = er.findById(id);
	        student1.get().setName(name);
	        student1.get().setId(id);
	        student1.get().setPosition(position);
	        student1.get().setSalary(salary);
	        
	        er.save(student1.get());
	        List<EmployeeDetails> studentList = er.findAll();

	        if(studentList.size() > 0) {
	            return studentList;
	        }
	        else {
	            return new ArrayList<EmployeeDetails>();
	        }
	  
	  }
	  
	  
	  
}
