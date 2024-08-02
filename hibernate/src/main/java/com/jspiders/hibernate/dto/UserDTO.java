package com.jspiders.hibernate.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class UserDTO {
	
	@Id
	private int id;
	private String name;
	private String email;
	private long mobile;
	private String password;

}
