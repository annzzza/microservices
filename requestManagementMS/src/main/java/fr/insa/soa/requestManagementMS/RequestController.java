package fr.insa.soa.requestManagementMS;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController{
	
	@GetMapping("/requests/test")
	public int test() {
		return 10;
	}
}