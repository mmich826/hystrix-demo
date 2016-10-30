package com.example;

import com.netflix.config.ConfigurationManager;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.Map;

import static com.netflix.config.ConfigurationManager.*;

@EnableHystrix
@EnableHystrixDashboard
@Component
@SpringBootApplication
public class DemoWebApplication {

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public GetDataCommand helloCmd() {
		return new GetDataCommand("mikey");
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoWebApplication.class, args);
	}
}


@Controller
class WelcomeController {

	@Autowired
	CarDataDao carDao;

	@Autowired
	GetDataCommand helloCmd;

	@Value("${application.message:Hello World}")
	private String message = "Hello World";

	@GetMapping("/yurcar")
	public String getYurCar(Map<String, Object> model) {
		System.out.println("------ ctrl");
		model.put("time", new Date());
		model.put("message", carDao.getStuff() );
		return "index";
	}

	@GetMapping("/yurcar-cmd")
	public String getYurCarCmd(Map<String, Object> model) {
		System.out.println("------ ctrl-cmd");
		model.put("time", new Date());
		model.put("message", helloCmd.run() );
		return "index";
	}

	@RequestMapping("/serviceUnavailable")
	public String ServiceUnavailable() {
		throw new ServiceUnavailableException();
	}

	@RequestMapping("/bang")
	public String bang() {
		throw new RuntimeException("Boom");
	}

	@RequestMapping("/insufficientStorage")
	public String insufficientStorage() {
		throw new InsufficientStorageException();
	}

	@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
	private static class ServiceUnavailableException extends RuntimeException {

	}

	@ResponseStatus(HttpStatus.INSUFFICIENT_STORAGE)
	private static class InsufficientStorageException extends RuntimeException {

	}
}
