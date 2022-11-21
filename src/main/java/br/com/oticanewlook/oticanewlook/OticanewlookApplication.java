package br.com.oticanewlook.oticanewlook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class OticanewlookApplication {

	public static void main(String[] args) {
		SpringApplication.run(OticanewlookApplication.class, args);
	}

	@GetMapping("/")
    public String login() {
        return "home/login";
    }

}
