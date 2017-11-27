package com.example;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CarDataDao {

    @Autowired
    private RestTemplate restTemplate;

    public String getCarData()

    {
        final String uri = "http://localhost:9090/msds/car";

        String result = restTemplate.getForObject(uri, String.class);

        System.out.println(result);
        return result;
    }
}
