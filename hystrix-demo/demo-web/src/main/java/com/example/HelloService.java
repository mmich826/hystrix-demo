package com.example;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    private String name = "Hans-Karl";

    public HelloService(String name) {
        this.name = name;
    }

    @HystrixCommand(fallbackMethod = "helloFallback", threadPoolKey = "DemoGroup")
    public String sayHello()

    {
        return "Hello " + name + "!";
    }

    public String helloFallback() {
        return "Hello Failure " + name + "!";
    }
}
