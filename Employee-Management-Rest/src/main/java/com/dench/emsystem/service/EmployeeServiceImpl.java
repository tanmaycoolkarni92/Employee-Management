package com.dench.emsystem.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dench.emsystem.entity.Employee;
import com.dench.emsystem.repository.EmployeeRepository;

@Service 
public class EmployeeServiceImpl implements EmployeeService {

	private static final Integer NOT_FOUND = 0;
	private static final Integer SUCCESS = 2;
	private static final Integer EXIST =1;
	
	@Autowired
	EmployeeRepository employeeRepository;	
	
	@Override
	public void deleteEmployeeById(long id) {
		
			employeeRepository.deleteById(id);		
	}

	@Override
	public Employee findemployeeById(Long id) {
	
		Employee employee =employeeRepository.findById(id).get();
		return employee;
	}
	
	@Override
	public List<Employee> findEmployeeByRole(String role) {
		
		return employeeRepository.findByRole(role);
	}

	@Override
	public Integer saveEmployee(@Valid Employee employee) {
		
		List <Employee> result = employeeRepository.findByEmailId(employee.getEmailId());
	
		if(result.size()>0) {
			return EXIST;
		}
		else {
			//employee.setStatus("Active");
			employeeRepository.save(employee);
			return SUCCESS;
		}
			
	}

	@Override
	public List<Employee> findAllEmployees() {
		
		return employeeRepository.findAll();
	}

	@Override
	public Integer updateEmployee(Employee employee) {
		
		Employee currentEmployee=findemployeeById(employee.getId());
			
		if(currentEmployee==null) {
			return NOT_FOUND;
		}
		
		currentEmployee.setFirstName(employee.getFirstName());
		currentEmployee.setLastName(employee.getLastName());
		currentEmployee.setAddress(employee.getAddress());
		currentEmployee.setDateOfBirth(employee.getDateOfBirth());
		currentEmployee.setMobileNo(employee.getMobileNo());
		currentEmployee.setEmailId(employee.getEmailId());
		//currentEmployee.setCity(employee.getCity());

		 employeeRepository.save(currentEmployee);
		 
		 return SUCCESS; 
		
	}

	@Override
	public Integer loginManager(Employee manager) {
		
		List<Employee> result= employeeRepository.findByEmailIdAndPassword(manager.getEmailId(),manager.getPassword());
		
		if(result.size()>0) {
			return SUCCESS;
		}
		else {
			return NOT_FOUND;
		}
		
	}
	
}
