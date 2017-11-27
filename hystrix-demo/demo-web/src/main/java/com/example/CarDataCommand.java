package com.example;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CarDataCommand extends HystrixCommand<String> {

    private RestTemplate restTemplate;

    public CarDataCommand(RestTemplate restTemplate) {
        super(
            Setter.withGroupKey(
                HystrixCommandGroupKey.Factory.asKey("DemoGroup"))
                .andCommandPropertiesDefaults(
                    HystrixCommandProperties.Setter()
                        .withExecutionTimeoutInMilliseconds(1200)
                )
        );

        this.restTemplate = restTemplate;
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
