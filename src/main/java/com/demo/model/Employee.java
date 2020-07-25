package com.demo.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
@Entity
public class Employee {
		@Id
	    @GeneratedValue(strategy = IDENTITY)
	    public Long empId;
	    
	    @NotBlank(message = "Name is mandatory")
	    private String name;
	    
	    @NotBlank(message = "Email is mandatory")
	    private String email;

	    @Column(name = "phone_no")
	    private Long phoneNo;

		public Employee() {
			super();
		}

		public Employee(Long empId, @NotBlank(message = "Name is mandatory") String name,
				@NotBlank(message = "Email is mandatory") String email, Long phoneNo) {
			super();
			this.empId = empId;
			this.name = name;
			this.email = email;
			this.phoneNo = phoneNo;
		}

		public Long getempId() {
			return empId;
		}

		public void setempId(Long empId) {
			this.empId = empId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Long getPhoneNo() {
			return phoneNo;
		}

		public void setPhoneNo(Long phoneNo) {
			this.phoneNo = phoneNo;
		}
	    
	    
	    

}
