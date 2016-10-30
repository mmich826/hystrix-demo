package com.example;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CarDataUsingCmdDao {

    @Autowired
    private RestTemplate restTemplate;

    public String getCarData2()

    {
        String result = new CarDataCommand(restTemplate).execute();
        return result;
    }
}
