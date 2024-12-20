package fr.insa.soa.userManagementMS;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.*;
import fr.insa.soa.userManagementMS.database.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/users")
public class UserController{
	
	@Autowired
	private RestTemplate restTemplate;
	
	UserDAOImplementation dbOperations = new UserDAOImplementation();
	
	@GetMapping("/test")
	public int test() {
		return 10000;
	}
	
	
	@PostMapping("/register/")
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
	
	
	
	@GetMapping("/getuser/{username}")
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