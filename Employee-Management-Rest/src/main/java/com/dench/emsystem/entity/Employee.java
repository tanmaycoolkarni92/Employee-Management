package com.dench.emsystem.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="Employee_Details")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="FirstName" ,length=20)
	private String firstName;
	
	@Column(name="LastName",length=20)
	private String lastName;
	
	@Column(name="Address",length=200)
	private String address;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name="DateOfBirth")
	private Date dateOfBirth;
	
	@Column(name="MobileNumber",length=12)
	private String mobileNo;
	
	@Column(name="EmailId" ,length=30)
	private String emailId;
	
	@Column(name="Password",length=30)
	private String password;
	
	@Column(name="Role",length=15)
	private String role;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getMobileNo() {
		return mobileNo;
	}
	
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	public String getEmailId() {
		return emailId;
	}
	
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	public Employee() {
	}

	public Employee(Long id, String firstName, String lastName, String address, Date dateOfBirth, String mobileNo,
			String emailId, String password, String role) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.password = password;
		this.role = role;
		
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", dateOfBirth=" + dateOfBirth + ", mobileNo=" + mobileNo + ", emailId=" + emailId + ", password="
				+ password + ", role=" + role + "]";
	}

	
	
	
	
	
	
}
