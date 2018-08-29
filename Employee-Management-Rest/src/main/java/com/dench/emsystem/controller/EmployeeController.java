package com.dench.emsystem.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dench.emsystem.entity.Employee;
import com.dench.emsystem.exception.CustomErrorType;
import com.dench.emsystem.service.EmployeeService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	// Save Employee
	@PostMapping("/saveemployee")
	public ResponseEntity<?> saveEmployee(@RequestBody Employee employee) {
		
		Integer result=employeeService.saveEmployee(employee);
		if(result==1) {
			return new ResponseEntity<>(new CustomErrorType(
							"Unable to save Employee. " + employee.getEmailId() + " Email Id already exist"),HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(new CustomErrorType(" Record Saved"), HttpStatus.OK);

	}
	

	// get all employees
	@GetMapping("/getallemployees/{role}")
	public ResponseEntity<List<Employee>> getAllEmployees(@PathVariable(value="role") String role) {

		
		List<Employee>employees = employeeService.findEmployeeByRole(role);
		
		if (employees == null) {
			return new ResponseEntity<List<Employee>>(employees, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}

	// get employee by id
	@GetMapping("/getemployeebyid/{id}")
	public Employee getEmployeeById(@PathVariable(value = "id") Long id) {

		return employeeService.findemployeeById(id);

	}

	// update Employee Details
	@PutMapping("/updateemployee/{id}")
	public ResponseEntity<?> updateEmployee(@PathVariable(value = "id") long id, @RequestBody Employee employee) {

		Integer currentEmployee = employeeService.updateEmployee(employee);

		if (currentEmployee == 0) {

			return new ResponseEntity<>(new CustomErrorType("Unable to update. Emploee with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	// delete employee
	@DeleteMapping("/deleteemployee/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {

		Employee employee = employeeService.findemployeeById(id);

		if (employee == null) {

			return new ResponseEntity<>(new CustomErrorType("Unable to delete. Employee with id " + id + " not found."),
					HttpStatus.NOT_FOUND);

		}

		employeeService.deleteEmployeeById(id);

		return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);

	}
	
	//Public ResponseEntity<?> managerLogin()
	
	// check with emailId and password
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Employee manager) {

		Integer result = employeeService.loginManager(manager);

		if (result == 2) {
			return new ResponseEntity<>(new CustomErrorType("Manager Login Successfull"), HttpStatus.OK);
		}
		return new ResponseEntity<>(new CustomErrorType("Please Check userName and password"),
				HttpStatus.NOT_ACCEPTABLE);

	}

	
}
