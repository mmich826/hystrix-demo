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

//	private static DynamicLongProperty timeToWait = DynamicPropertyFactory
//		.getInstance().getLongProperty("hystrixdemo.sleep", 100);

	public static void main(String[] args) {
		SpringApplication.run(DemoSvcApplication.class, args);
	}
}


@RestController
class MyServiceController {
	int counter = 0;
	int sleepMilli = 5000;

	@RequestMapping(value="/car", method = RequestMethod.GET)
	String getCarData(Model model) {
		try {
			Thread.sleep(sleepMilli);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Car " + counter++;
	}

	@RequestMapping(value="/car-slow", method = RequestMethod.GET)
	String getCarDataSlow(Model model) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Car " + counter++;
	}

}
