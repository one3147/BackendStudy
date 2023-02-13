package com.iStudyJava.dowonjune;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
@RestController
public class DowonjuneApplication {
	public static void main(String[] args) {

		SpringApplication.run(DowonjuneApplication.class, args);
	}
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name)
	{
		return String.format("<h1>Hello, " + name + "</h1>");
	}

	@GetMapping("/bye")
	public String bye(@RequestParam(value = "test", defaultValue = "Do you want to get a flag?") String test)
	{
		if (test.equals("flag"))
		{
			return String.format("Spring{You_kn0w_J4va?}");
		}
		else
		{
			return String.format(test);
		}
	}

}
