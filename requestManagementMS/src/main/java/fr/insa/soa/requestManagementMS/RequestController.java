package fr.insa.soa.requestManagementMS;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/requests")
public class RequestController{
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/test")
	public int test() {
		return 10;
	}
}