package fr.insa.soa.userManagementMS;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.*;
import fr.insa.soa.userManagementMS.database.*;

@RestController
public class UserController{
	
	UserDAOImplementation dbOperations = new UserDAOImplementation();
	
	@GetMapping("/users/test")
	public int test() {
		return 10000;
	}
	
	
	@PostMapping("/users/register/")
	public User register(@RequestBody User user) {
		try {
			User otherUser = dbOperations.getUser(user.getUsername());
			if (otherUser==null) {
				try {
					dbOperations.add(user);
				} catch (SQLException e) {
					System.out.println("User " + user.getId().toString() + " was not added to db.");
				}
			} else {
				System.out.println("Username already taken. Please try again with a new username.");
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return user;
	}
	
	
	
	@GetMapping("/users/getuser/{username}")
	public User register(@PathVariable String username) {
		try {
			User user = dbOperations.getUser(username);
			if (user==null) {
				System.out.println("User " + username + " not found.");
				}
			return user;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}
	
}