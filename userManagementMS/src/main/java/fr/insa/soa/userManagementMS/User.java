package fr.insa.soa.userManagementMS;

import java.util.UUID;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="User")
public class User {
	private UUID id;
	private String username;
	private String email;
	private String password;
	private Status status;
	
	public enum Status {
		HELPEE, HELPER, VALIDATOR
	}
	
	public User() {
	}
	
	public User(String username, String email, Status status, String password){
		this.id = UUID.randomUUID(); 
		this.username = username;
		this.email = email;
		this.status = status;
		//TODO : Encrypt password
		this.password = password;
	}
		
	public UUID getId() {
		return id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getEmail() {
		return email;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

}