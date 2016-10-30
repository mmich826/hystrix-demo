package com.example;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;


public class CarDataCommand extends HystrixCommand<String> {

    @Autowired
    private RestTemplate restTemplate;

    public CarDataCommand() {
        super(
            Setter.withGroupKey(
                HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
                .andCommandPropertiesDefaults(
                    HystrixCommandProperties.Setter()
                        .withExecutionTimeoutInMilliseconds(500)
                )
        );
    }

    @Override
    protected String run() {
        final String uri = "http://localhost:9090/msds/car";

        String result = restTemplate.getForObject(uri, String.class);

        System.out.println(result);
        return result;
    }

    @Override
    protected String getFallback() {
        System.out.println("------ carDataFallback");
        return "No Car (Fallback)";
    }
}
