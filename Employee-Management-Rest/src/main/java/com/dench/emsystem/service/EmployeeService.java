package com.dench.emsystem.service;

import java.util.List;

import javax.validation.Valid;

import com.dench.emsystem.entity.Employee;

public interface EmployeeService {
	
	void deleteEmployeeById(long id);

	Employee findemployeeById(Long id);
	
	
	Integer saveEmployee(@Valid Employee employee);

	List<Employee> findAllEmployees();

	Integer updateEmployee(Employee currentEmployee);

	List<Employee> findEmployeeByRole(String role);

	Integer loginManager(Employee manager);
}
