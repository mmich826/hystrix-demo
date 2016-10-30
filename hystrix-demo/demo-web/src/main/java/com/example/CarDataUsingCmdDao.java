package com.example;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CarDataUsingCmdDao {

    @Autowired
    private CarDataCommand carDataCommand;

    @HystrixCommand(fallbackMethod = "carData2Fallback")
    public String getCarData2()

    {
        return carDataCommand.run();
    }

    public String carData2Fallback() {
        System.out.println("------ carData2Fallback");
        return "No Car (carData2Fallback)";
    }
}
