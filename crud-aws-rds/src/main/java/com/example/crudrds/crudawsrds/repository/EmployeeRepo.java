package com.example.crudrds.crudawsrds.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crudrds.crudawsrds.dto.EmployeeDetails;


@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeDetails , Integer>
{
		

}
