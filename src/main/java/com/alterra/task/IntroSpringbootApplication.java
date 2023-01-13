package com.alterra.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class IntroSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntroSpringbootApplication.class, args);
	}

	@GetMapping("/v1/messages")
	public String hello() {
		return "hello world";
	}

	@PutMapping("/v1/messages")
	public String helloPost() {
		return "hello world";
	}

	@DeleteMapping("/v1/messages")
	public String helloDelete() {
		return "hello world";
	}
}
