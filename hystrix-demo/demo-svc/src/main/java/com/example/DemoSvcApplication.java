package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoSvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSvcApplication.class, args);
	}
}

x
@RestController
class MyServiceController {
	int counter = 0;
	int sleepMilli = 400;

	@RequestMapping(value="/car", method = RequestMethod.GET)
	String getCarData(Model model) {
		try {
			Thread.sleep(sleepMilli);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Car " + counter++;
	}

}
