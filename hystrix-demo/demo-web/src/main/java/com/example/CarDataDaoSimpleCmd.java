package com.example;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CarDataDaoSimpleCmd {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "carDataFallback", threadPoolKey = "DemoGroup")
    public String getCarData()

    {
        final String uri = "http://localhost:9090/msds/car";

        String result = restTemplate.getForObject(uri, String.class);

        System.out.println(result);
        return result;
    }

    public String carDataFallback() {
        System.out.println("------ carDataFallback");
        return "No Car (carDataFallback)";
    }


    public String getCarDataDirect() {
        final String uri = "http://localhost:9090/msds/car-slow";

        String result = restTemplate.getForObject(uri, String.class);

        System.out.println(result);
        return result;
    }
}
