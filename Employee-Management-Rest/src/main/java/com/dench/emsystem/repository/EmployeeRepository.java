package com.dench.emsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dench.emsystem.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{

	List<Employee> findByRole(String role);

	List<Employee> findByEmailId(String emailId);

	List<Employee> findByEmailIdAndPassword(String emailId, String password);
	

}
