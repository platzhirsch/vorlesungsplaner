package dhbw.vorlesungsplaner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class VorlesungsplanerApplication {

	public static void main(String[] args) {
		SpringApplication.run(VorlesungsplanerApplication.class, args);
	}

}

@RestController
class DefaultController {

	@GetMapping("/")
		String hello(){
		return "Hello";
		}
}